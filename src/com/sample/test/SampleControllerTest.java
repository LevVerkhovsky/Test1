package com.sample.test;

import org.junit.Before;
import org.junit.Test;

import com.sample.dao.UserDaoImpl;
import com.sample.service.UserServiceImpl;
import com.sample.util.UserUtils;
import com.sample.web.SampleController;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

public class SampleControllerTest {
	SampleController controller = null;

	@Before
	public void init(){
		controller = new SampleController();
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
    public void shouldReturnNonEmptyUserNameList() {
    	List<String> list = new ArrayList<String>();
    	String u1 = "Username1";
    	String u2 = "Username2";
    	list.add(u1);
    	list.add(u2);
    	list.add(u1);

    	controller.addUser(u1);
    	controller.addUser(u2);
    	controller.addUser(u1);

    	String expected = UserUtils.convertListToJSON(list);
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

        result = controller.addUser("        ");
        assertNotNull(result);
        assertEquals(expected, result);
    }
}