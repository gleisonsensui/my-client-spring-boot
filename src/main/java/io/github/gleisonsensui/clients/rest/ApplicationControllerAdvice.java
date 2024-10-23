package io.github.gleisonsensui.clients.rest;

import io.github.gleisonsensui.clients.rest.exception.ApiErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class )
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleValidationErrors (MethodArgumentNotValidException exc) {
        BindingResult bindingResult = exc.getBindingResult();
        List<String> messages =  bindingResult.getAllErrors()
                .stream()
                .map(objectError -> objectError.getDefaultMessage())
                .collect(Collectors.toList());
        return new ApiErrors(messages);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity handleResponseStatusException (ResponseStatusException exc) {
        String messageError = exc.getMessage();
        HttpStatus statusCodeReceive = (HttpStatus) exc.getStatusCode();

        ApiErrors apiErrors = new ApiErrors(messageError);

        return new ResponseEntity(apiErrors, statusCodeReceive);
    }
}
