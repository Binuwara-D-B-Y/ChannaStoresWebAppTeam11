package com.example.team11.Controller;

import com.example.team11.DTO.AccountDTO;
import com.example.team11.Entity.Account;
import com.example.team11.Service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    // Create a new account
    @PostMapping
    public AccountDTO createAccount(@RequestBody Account account) {
        return accountService.mapToDTO(accountService.createAccount(account));///////////////
    }

    // Get account by ID
    @GetMapping("/{id}")
    public AccountDTO getAccountById(@PathVariable int id) {
        return accountService.getAccountById(id);
    }

    // Get all accounts
    @GetMapping
    public List<AccountDTO> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    // Update account
    @PutMapping("/{id}")
    public AccountDTO updateAccount(@PathVariable int id, @RequestBody Account updatedAccount) {
        return accountService.mapToDTO(accountService.updateAccount(id, updatedAccount));
    }

    // Delete account
    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable int id) {
        accountService.deleteAccount(id);
    }
}

