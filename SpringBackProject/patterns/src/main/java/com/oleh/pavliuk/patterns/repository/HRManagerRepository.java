package com.oleh.pavliuk.patterns.repository;

import com.oleh.pavliuk.patterns.model.HRManager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HRManagerRepository extends JpaRepository<HRManager, Long> {
    Optional<HRManager> findByName(String name);
}
