package com.rachel.account.service;

import com.rachel.account.model.Account;
import com.rachel.account.repository.AccountRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class AccountServiceTest {

    @MockBean
    private AccountRepository accountRepository;

    private AccountService accountService;

    @Before
    public void init() {
        accountService = new AccountService(accountRepository);
    }

    @Test
    public void getAccountShouldReturnAccount() {
        Account account = new Account();
        account.setId(1L);
        account.setAccountName("1111");
        account.setAccountTransactions(Collections.emptySet());
        when(accountRepository.findById(1L)).thenReturn(Optional.of(account));

        Account actualAccount = accountService.getAccount(1L).get();
        verify(accountRepository, times(1)).findById(1L);
        assertEquals(account,actualAccount);
    }

    @Test
    public void getAccountShouldReturnNullUserIfNotIdNotFound() {
        when(accountRepository.findById(anyLong())).thenReturn(Optional.empty());

        Account actualAccount = accountService.getAccount(2L).orElse(null);
        verify(accountRepository, times(1)).findById(anyLong());
        assertNull(actualAccount);
    }
}
