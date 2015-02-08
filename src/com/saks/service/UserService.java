package com.saks.service;

import java.util.List;

public interface UserService {
	public List<String> showUsers();
	public boolean addUser(String username);
}
