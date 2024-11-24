package com.example.team11.Service;

import com.example.team11.DTO.AccountDTO;
import com.example.team11.Entity.Account;
import com.example.team11.Repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    // Create a new account
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    // Get account by ID
    public AccountDTO getAccountById(int id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        return mapToDTO(account);
    }

    // Get all accounts
    public List<AccountDTO> getAllAccounts() {
        return accountRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // Update account
    public Account updateAccount(int id, Account updatedAccount) {
        Account existingAccount = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        existingAccount.setUsername(updatedAccount.getUsername());
        existingAccount.setEmail(updatedAccount.getEmail());
        existingAccount.setPhoneNo(updatedAccount.getPhoneNo());
        existingAccount.setCompany(updatedAccount.getCompany());
        existingAccount.setAddress(updatedAccount.getAddress());
        return accountRepository.save(existingAccount);
    }

    // Delete account
    public void deleteAccount(int id) {
        accountRepository.deleteById(id);
    }

    // Utility: Map Entity to DTO
    public AccountDTO mapToDTO(Account account) {
        AccountDTO dto = new AccountDTO();
        dto.setId(account.getId());
        dto.setUsername(account.getUsername());
        dto.setEmail(account.getEmail());
        dto.setRole(account.getRole().name());
        dto.setPhoneNo(account.getPhoneNo());
        dto.setCompany(account.getCompany());
        dto.setAddress(account.getAddress());
        return dto;
    }
}

