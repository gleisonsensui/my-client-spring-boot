package io.github.gleisonsensui.clients.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    private  String description;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private  Client client;

    @Column
    private BigDecimal value;

}
