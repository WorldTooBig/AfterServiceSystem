package com.yinlong.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yinlong.dao.IQuas002Dao;
import com.yinlong.entity.Quas002;
import com.yinlong.service.IQuas002Service;

@Service("quas002Service")
@Transactional(propagation = Propagation.REQUIRED)
public class Quas002ServiceImpl implements IQuas002Service {

	@Resource(name = "")
	private IQuas002Dao quas002Dao;
	

	public void setQuas002Dao(IQuas002Dao quas002Dao) {
		this.quas002Dao = quas002Dao;
	}


	@Override
	public boolean addQuas002(Quas002 quas002) {
		return quas002Dao.addQuas002(quas002);
	}

	

}
