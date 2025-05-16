package com.oleh.pavliuk.patterns.repository;

import com.oleh.pavliuk.patterns.model.ITAdministrator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ITAdministratorRepository extends JpaRepository<ITAdministrator, Long> {
    Optional<ITAdministrator> findByName(String name);
}
