package com.oleh.pavliuk.patterns.repository;

import com.oleh.pavliuk.patterns.model.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MentorRepository extends JpaRepository<Mentor, Long> {
}
