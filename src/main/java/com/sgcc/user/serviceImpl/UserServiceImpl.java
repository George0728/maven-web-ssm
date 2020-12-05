package com.sgcc.user.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sgcc.user.dao.UserDao;
import com.sgcc.user.pojo.User;
import com.sgcc.user.service.UserService;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {
	
	
	@Resource
	private UserDao userDao;

	public User getUserById(String id) {
		// TODO Auto-generated method stub
		return this.userDao.getUserById(id);
	}

	public List<User> getAll() {
		
		return userDao.getAllUser();
	}

	public User getUserByName(String userName) {
		// TODO Auto-generated method stub
		return userDao.getUserByName(userName);
	}

	public void insertByNamePassWord(String userName, String password) {
		// TODO Auto-generated method stub
		userDao.insertByNamePassWord(userName, password);
	}

	public void insert(User user) throws Exception{
		userDao.insert(user);
		
	}

	

}
