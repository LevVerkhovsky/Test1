package com.sample.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sample.dao.UserDao;

@Service("userService")
public class UserServiceImpl implements UserService {
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * Returns a List of all users 
	 *
	 * @return      a List of Strings representing usernames
	 */
	@Override
	public List<String> showUsers() {
		return userDao.show();
	}

	/**
	 * Returns a boolean indicating success/failure status of attempted addition of new user to repository. 
	 *
	 * @param  username  user's username to be added
	 * @return      boolean indicating success or failure
	 */
	@Override
	public boolean addUser(String username) {
		//dont add blank usernames
		if(username==null || username.trim().equals("")){
			//also log it possibly
			return false;
		}
		//dao doesnt check for uniqueness of usernames so will not check it; assuming its not required
		
		//dao also doesnt seem to be limited in size or have any other performance constraints defined 
		//so will not implement any logic related to that

		return userDao.add(username);
	}	
}