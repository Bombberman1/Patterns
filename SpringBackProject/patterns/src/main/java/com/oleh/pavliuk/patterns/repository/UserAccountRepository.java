package com.oleh.pavliuk.patterns.repository;

import com.oleh.pavliuk.patterns.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
}
