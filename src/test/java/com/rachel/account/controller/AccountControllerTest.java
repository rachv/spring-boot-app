package com.rachel.account.controller;

import com.rachel.account.model.Account;
import com.rachel.account.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Collections;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AccountController.class)
public class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountService accountService;

    @Test
    public void getUserAccountsShouldReturnSuccessfulStatus() throws Exception{
        Account account = new Account();
        account.setId(1L);
        account.setAccountName("1111");
        account.setAccountTransactions(Collections.emptySet());
        when(accountService.getAccount(anyLong())).thenReturn(Optional.of(account));
        ResultActions resultActions = mockMvc.perform(get("/accounts/1/transactions"));
        resultActions
                .andExpect(status().isOk());
        verify(accountService, times(1)).getAccount(anyLong());
        verifyNoMoreInteractions(accountService);
    }

    @Test
    public void getUserAccountsShouldReturnUnsuccessfulStatus() throws Exception{
        when(accountService.getAccount(anyLong())).thenReturn(Optional.empty());
        ResultActions resultActions = mockMvc.perform(get("/accounts/1/transactions"));
        resultActions
                .andExpect(status().is4xxClientError());
        verify(accountService, times(1)).getAccount(anyLong());
        verifyNoMoreInteractions(accountService);
    }

}
