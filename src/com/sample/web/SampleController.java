package com.sample.web;

import javax.servlet.http.HttpServlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sample.service.UserService;
import com.sample.util.UserUtils;

@Controller("sampleController")
public class SampleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns a JSON list of all users in repository 
	 *
	 * @return      JSON representation of a list of users
	 */
	@RequestMapping(value = "/user/show", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody String getUsers() {
		return UserUtils.convertListToJSON(userService.showUsers());
	}

	/**
	 * Attempts to add a user to repository and returns status of that operation as JSON 
	 *
	 * @param  username  user name of new user
	 * @return      JSON representation of a status of the operation
	 */
	@RequestMapping(value = "/user/add", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody String addUser(@RequestParam("username") String username) {
		return UserUtils.convertStatusToJSON(userService.addUser(username));
	}
}