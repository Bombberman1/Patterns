package com.oleh.pavliuk.patterns.repository;

import com.oleh.pavliuk.patterns.model.Workstation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkstationRepository extends JpaRepository<Workstation, Long> {
}
