package com.rachel.account;

import com.rachel.account.controller.AccountController;
import com.rachel.account.controller.UserController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountApplicationTests {

	@Autowired
	private AccountController accountController;

	@Autowired
	private UserController userController;

	@Test
	public void contextLoads() {
		assertNotNull(accountController);
		assertNotNull(userController);

	}

}
