package com.yinlong.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yinlong.dao.IUserDao;
import com.yinlong.entity.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDao implements IUserDao {

	
	public List<User> queryUserHql(String hql) {
		try {
			return getSession().createQuery(hql).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean addUser(User user) {
		try {
			getSession().save(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List queryHql(String hql) {
		try {
			return getSession().createQuery(hql).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public User queryUserById(User user) {
		try {
			return getSession().get(User.class, user.getUserId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


}
