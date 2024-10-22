package io.github.gleisonsensui.clients.model.repository;

import io.github.gleisonsensui.clients.model.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public  interface ClientRepository extends JpaRepository <Client, Integer>{

}