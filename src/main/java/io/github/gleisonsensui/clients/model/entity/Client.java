package io.github.gleisonsensui.clients.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;


import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    private  String name;

    @Column(nullable = false, length = 11)
    @NotNull(message = "{field.cpf.mandatory}")
    // @CPF(message = "{field.cpf.invalid}")
    private  String cpf;

    @Column(name = "date_register", updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-mm-yyyy")
    private LocalDate dateRegister;

    @PrePersist
    public  void prePersist() {
        setDateRegister(LocalDate.now());
    }

}
