package com.yinlong.dao;

import java.util.List;

import com.yinlong.entity.User;

public interface IUserDao {

	public List<User> queryUserHql(String hql);
		
	public boolean addUser(User user);
	
	public List queryHql(String hql);
}
