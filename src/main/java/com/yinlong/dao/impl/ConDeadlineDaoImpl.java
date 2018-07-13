package com.yinlong.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yinlong.dao.IConDeadlineDao;
import com.yinlong.entity.Conclusion;

@Repository("conDeadlineDao")
public class ConDeadlineDaoImpl extends BaseDao implements IConDeadlineDao {

	@Override
	public boolean addConclusion(Conclusion conclusion) {
		try {
			getSession().saveOrUpdate(conclusion);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Conclusion> findConclusion(String hql) {
		try {
			return getSession().createQuery(hql).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Conclusion findConclusionById(Conclusion conclusion) {
		try {
			return getSession().get(Conclusion.class, conclusion.getConId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
