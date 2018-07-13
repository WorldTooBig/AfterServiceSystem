package com.yinlong.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yinlong.dao.IDeadlineDao;
import com.yinlong.entity.Deadline;

@Repository("deadlineDao")
public class DeadlineDaoImpl extends BaseDao implements IDeadlineDao {

	/**
	 * 添加
	 * @param deadline
	 * @return
	 */
	@Override
	public boolean addDeadline(Deadline deadline) {
		try {
			getSession().saveOrUpdate(deadline);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 根据hql语句查询Deadline集合
	 * @param hql
	 * @return
	 */
	@Override
	public List<Deadline> queryDeadline(String hql) {
		try {
			return getSession().createQuery(hql).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 根据ID查询Deadline
	 * @param deadline
	 * @return
	 */
	@Override
	public Deadline queryDeadlineById(Deadline deadline) {
		try {
			return getSession().get(Deadline.class, deadline.getDeaId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

	
}
