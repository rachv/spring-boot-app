package com.rachel.account.controller;

import com.rachel.account.model.Account;
import com.rachel.account.model.User;
import com.rachel.account.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void getUserAccountsShouldReturnSuccessfulStatus() throws Exception{
        User user = new User();
        user.setId(1L);
        user.setUserName("user1");
        user.setFirstName("firtname");
        user.setLastName("lastname");
        Account account = new Account();
        account.setId(1L);
        account.setAccountName("1111");
        account.setAccountTransactions(Collections.emptySet());
        user.setAccounts(new HashSet<>(Collections.singletonList(account)));
        when(userService.getUser(anyLong())).thenReturn(Optional.of(user));
        ResultActions resultActions = mockMvc.perform(get("/users/1/accounts"));
        resultActions
                .andExpect(status().isOk());
        verify(userService, times(1)).getUser(anyLong());
        verifyNoMoreInteractions(userService);
    }

    @Test
    public void getUserAccountsShouldReturnUnsuccessfulStatus() throws Exception{
        when(userService.getUser(anyLong())).thenReturn(Optional.empty());
        ResultActions resultActions = mockMvc.perform(get("/users/1/accounts"));
        resultActions
                .andExpect(status().is4xxClientError());
        verify(userService, times(1)).getUser(anyLong());
        verifyNoMoreInteractions(userService);
    }

}
