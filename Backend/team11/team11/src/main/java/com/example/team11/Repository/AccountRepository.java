package com.example.team11.Repository;

import com.example.team11.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    // Find account by email (used for login)
    Account findByEmail(String email);

    // Optional: Find by username
    Account findByUsername(String username);
}
