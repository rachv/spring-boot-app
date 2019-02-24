package com.rachel.account.controller;

import com.rachel.account.model.Account;
import com.rachel.account.model.AccountTransaction;
import com.rachel.account.model.User;
import com.rachel.account.service.AccountService;
import com.rachel.account.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{accountId}/transactions")
    public Set<AccountTransaction> getUserAccounts(@PathVariable Long accountId) {
        Optional<Account> accountOptional = accountService.getAccount(accountId);
        if (accountOptional.isPresent()) {
            Account account =  accountOptional.get();
            return account.getAccountTransactions();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account Not Found");
        }
    }
}
