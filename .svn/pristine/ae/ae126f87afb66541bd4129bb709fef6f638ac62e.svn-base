package com.yinlong.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yinlong.dao.IDelayDao;
import com.yinlong.entity.Reply;
import com.yinlong.entity.RequestDelay;

@Repository("delayDao")
public class DelayDaoImpl extends BaseDao implements IDelayDao {

	/**
	 * 添加
	 */
	@Override
	public boolean addDelay(RequestDelay delay) {
		try {
			getSession().saveOrUpdate(delay);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}


	/**
	 * 根据ID查询Delay
	 * @param delay
	 * @return
	 */
	@Override
	public RequestDelay findDelayById(RequestDelay delay) {
		try {
			return getSession().get(RequestDelay.class, delay.getReqId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public List<RequestDelay> queryDelayList(String hql) {
		try {
			return getSession().createQuery(hql).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
