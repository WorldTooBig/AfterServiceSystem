package com.yinlong.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yinlong.dao.INotifiedDao;
import com.yinlong.entity.Notified;

@Repository("notifiedDao")
public class NotifiedDaoImpl extends BaseDao implements INotifiedDao {

	/**
	 * 添加Notified
	 * @param notified
	 * @return
	 */
	@Override
	public boolean addNotified(Notified notified) {
		try {
			getSession().save(notified);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 查询所有的Notified
	 * @param hql
	 * @return
	 */
	@Override
	public List<Notified> findNotifiedList(String hql) {
		try {
			return getSession().createQuery(hql).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
