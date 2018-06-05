package com.yinlong.dao.impl;

import org.springframework.stereotype.Repository;

import com.yinlong.dao.IQuas002Dao;
import com.yinlong.entity.Quas002;

@Repository("quas002Dao")
public class Quas002Dao extends BaseDao implements IQuas002Dao {

	
	public boolean addQuas002(Quas002 quas002) {
		try {
			getSession().save(quas002);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}


}
