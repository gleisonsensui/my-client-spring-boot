package io.github.gleisonsensui.clients.model.repository;

import io.github.gleisonsensui.clients.model.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Integer> {
    
}
