package io.github.gleisonsensui.clients.rest.exception;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class ApiErrors {

    @Getter
    private List<String> errors;

    public ApiErrors(List<String> errorsEntry) {
        this.errors = errorsEntry;
    }

    public ApiErrors(String messageEntry) {
        this.errors = Arrays.asList(messageEntry);
    }
}
