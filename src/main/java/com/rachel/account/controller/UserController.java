package com.rachel.account.controller;

import com.rachel.account.model.Account;
import com.rachel.account.model.User;
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
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}/accounts")
    public Set<Account> getUserAccounts(@PathVariable Long userId) {
        Optional<User> userOptional = userService.getUser(userId);
        if (userOptional.isPresent()) {
            User user =  userOptional.get();
            return user.getAccounts();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User Not Found");
        }
    }
}
