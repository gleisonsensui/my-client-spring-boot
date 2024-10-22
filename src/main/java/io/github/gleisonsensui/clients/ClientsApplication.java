package io.github.gleisonsensui.clients;

import io.github.gleisonsensui.clients.model.entity.Client;
import io.github.gleisonsensui.clients.model.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ClientsApplication {

    @Bean
    public CommandLineRunner run(@Autowired ClientRepository repository) {
        return args -> {
            Client client = Client.builder().cpf("00000000000").name("Fulano da Silva").build();
            repository.save(client);
        };
    }





    public static void main(String[] args) {
        SpringApplication.run(ClientsApplication.class, args);
    }
}
