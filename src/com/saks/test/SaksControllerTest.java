package com.saks.test;

import org.junit.Before;
import org.junit.Test;

import com.saks.dao.UserDaoImpl;
import com.saks.service.UserServiceImpl;
import com.saks.util.UserUtils;
import com.saks.web.SaksController;

import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

public class SaksControllerTest {
	SaksController controller = null;

	@Before
	public void init(){
		controller = new SaksController();
		UserServiceImpl userService = new UserServiceImpl();
		UserDaoImpl userDao = new UserDaoImpl();

		userService.setUserDao(userDao);
		controller.setUserService(userService);
	}

    @Test
    public void shouldReturnEmptyUserNameList() {
    	String expected = UserUtils.convertListToJSON(new ArrayList<String>());
        String userNameList = controller.getUsers();
 
        assertNotNull(userNameList);
        assertEquals(expected, userNameList);
    }
 
    @Test
    public void shouldAddUserAndReturnTrue() {
    	String expected = UserUtils.convertStatusToJSON(true);
        String result = controller.addUser("test");
        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    public void shouldReturnErrorOnNullUserName() {
    	String expected = UserUtils.convertStatusToJSON(false);
        String result = controller.addUser(null);
        assertNotNull(result);
        assertEquals(expected, result);
    }
}