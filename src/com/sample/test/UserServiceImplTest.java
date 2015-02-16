package com.sample.test;

import org.junit.Before;
import org.junit.Test;

import com.sample.dao.UserDaoImpl;
import com.sample.service.UserServiceImpl;

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
    	String u1 = "Username1";
    	String u2 = "Username2";
        boolean result = userService.addUser(u1);
        assertTrue(result);
 
        List<String> userNameList = userService.showUsers();
 
        assertNotNull(userNameList);
        assertTrue(userNameList.size() == 1);

        result = userService.addUser(u2);
        assertTrue(result);

        userNameList = userService.showUsers();
        
        assertNotNull(userNameList);
        assertTrue(userNameList.size() == 2);
    }

    @Test
    public void shouldReturnErrorOnNullUserName() {
    	List<String> listBefore = userService.showUsers();
    	assertNotNull(listBefore);
    	
        boolean result = userService.addUser(null);
        assertFalse(result);
        result = userService.addUser("     ");
        assertFalse(result);

        List<String> listAfter = userService.showUsers();
        assertNotNull(listAfter);
        assertTrue(listBefore.equals(listAfter));
    }

    @Test
    public void shouldReturnSuccess() {
    	String u1 = "Username1";
    	String u2 = "Username2";
        boolean result = userService.addUser(u1);
        assertTrue(result);

        List<String> list = userService.showUsers();
        assertNotNull(list);
        assertTrue(list.contains(u1));

        //testing for multiple inserts
        result = userService.addUser(u2);
        assertTrue(result);

        list = userService.showUsers();
        assertNotNull(list);
        assertTrue(list.contains(u2));
        
        //no limitations on adding same user twice
        result = userService.addUser(u1);
        assertTrue(result);

        list = userService.showUsers();
        assertNotNull(list);
        assertTrue(list.contains(u1));
    }
}