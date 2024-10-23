package io.github.gleisonsensui.clients.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

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
    private  String cpf;

    @Column(name = "date_register")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dateRegister;

    @PrePersist
    public  void prePersist() {
        setDateRegister(LocalDate.now());
    }

}
