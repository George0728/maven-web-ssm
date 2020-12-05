package com.sgcc.user.service;

import java.util.List;

import com.sgcc.user.pojo.User;

public interface UserService {

	public User getUserById(String id);
	
	public User getUserByName(String userName);

	public List<User> getAll();

	public void insertByNamePassWord(String userName, String password);

	public void insert(User user) throws Exception;

}
