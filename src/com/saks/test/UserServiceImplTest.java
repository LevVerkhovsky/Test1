package com.saks.test;

import org.junit.Before;
import org.junit.Test;

import com.saks.dao.UserDaoImpl;
import com.saks.service.UserServiceImpl;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class UserServiceImplTest {
	UserServiceImpl userService = null;

	@Before
	public void init(){
		userService = new UserServiceImpl();
		UserDaoImpl userDao = new UserDaoImpl();

		userService.setUserDao(userDao);
	}

    @Test
    public void shouldReturnEmptyUserNameList() {
        List<String> userNameList = userService.showUsers();
 
        assertNotNull(userNameList);
        assertTrue(userNameList.size() == 0);
    }
 
    @Test
    public void shouldReturnPopulatedUserNameList() {
        boolean result = userService.addUser("test");
        assertTrue(result);
 
        List<String> userNameList = userService.showUsers();
 
        assertNotNull(userNameList);
        assertTrue(userNameList.size() == 1);
    }

    @Test
    public void shouldReturnErrorOnNullUserName() {
        boolean result = userService.addUser(null);
        assertFalse(result);
        result = userService.addUser("     ");
        assertFalse(result);
    }
}