package com.simpz.bitcoder.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.simpz.bitcoder.model.po.UserPo;

@Repository
public class UserDao extends MySQLBaseDao {
	
	public static final String MAPPER_BASE = "com.simpz.bitcoder.dao.UserDao.";

	public List<UserPo> getAllUser(){
		return getSqlSession().selectList(MAPPER_BASE + "getAllUser");
	}
}
