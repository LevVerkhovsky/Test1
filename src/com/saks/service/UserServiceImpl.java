package com.saks.service;

import java.util.List;

import com.saks.dao.UserDao;

public class UserServiceImpl implements UserService {
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<String> showUsers() {
		return userDao.show();
	}

	@Override
	public boolean addUser(String username) {
		if(username==null || username.trim().equals("")){
			//log it
			return false;
		}
		return userDao.add(username);
	}	
}