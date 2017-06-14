package com.simpz.bitcoder.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simpz.bitcoder.dao.UserDao;
import com.simpz.bitcoder.model.po.UserPo;
import com.simpz.bitcoder.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public List<UserPo> getAllUser() {
		return userDao.getAllUser();
	}

}
