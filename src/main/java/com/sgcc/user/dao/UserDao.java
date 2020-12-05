package com.sgcc.user.dao;

import java.util.List;

import com.sgcc.user.pojo.User;

public interface UserDao {

	List<User> getAllUser();

	User getUserById(String id);

	User getUserByName(String userName);

	void insertByNamePassWord(String userName, String password);

	int insert(User user) throws Exception;


}
