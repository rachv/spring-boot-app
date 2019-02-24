package com.rachel.account.service;

import com.rachel.account.model.User;
import com.rachel.account.repository.UserRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class UserServiceTest {

    @MockBean
    private UserRepository userRepository;

    private UserService userService;

    @Before
    public void init() {
        userService = new UserService(userRepository);
    }

    @Test
    public void getUserShouldReturnUser() {
        User user = new User();
        user.setId(1L);
        user.setUserName("user1");
        user.setFirstName("firtname");
        user.setLastName("lastname");
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        User actualUser = userService.getUser(1L).get();
        verify(userRepository, times(1)).findById(1L);
        assertEquals(user,actualUser);
    }

    @Test
    public void getUserShouldReturnNullUserIfNotIdNotFound() {
        when(userRepository.findById(anyLong())).thenReturn(Optional.empty());

        User actualUser = userService.getUser(1L).orElse(null);
        verify(userRepository, times(1)).findById(anyLong());
        assertNull(actualUser);
    }
}
