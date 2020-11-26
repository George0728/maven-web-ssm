package com.sgcc.user.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sgcc.user.dao.UserDao;
import com.sgcc.user.pojo.User;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {
	
	
	@Resource
	private UserDao userDao;

	public User getUserById(Integer id) {
		// TODO Auto-generated method stub
		return this.userDao.getUserById(id);
	}
	

}
