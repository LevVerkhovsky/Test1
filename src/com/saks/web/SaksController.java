package com.saks.web;

import javax.servlet.http.HttpServlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.saks.service.UserService;
import com.saks.util.UserUtils;

@Controller
public class SaksController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/user/show", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody String getUsers() {
		return UserUtils.convertListToJSON(userService.showUsers());
	}

	@RequestMapping(value = "/user/add", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody String addUser(@RequestParam("username") String username) {
		return UserUtils.convertStatusToJSON(userService.addUser(username));
	}
}