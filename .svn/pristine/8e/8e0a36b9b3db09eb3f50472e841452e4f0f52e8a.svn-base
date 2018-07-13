package com.yinlong.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yinlong.dao.IConclusionDao;
import com.yinlong.entity.Conclusion;

@Repository("conclusionDao")
public class ConclusionDaoImpl extends BaseDao implements IConclusionDao {

	/**
	 * 添加
	 * @param conclusion
	 * @return
	 */
	@Override
	public boolean addConclusion(Conclusion conclusion) {
		try {
			getSession().save(conclusion);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 查询所有Conclusion
	 * @param hql
	 * @return
	 */
	@Override
	public List<Conclusion> findConclusion(String hql) {
		try {
			return getSession().createQuery(hql).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 根据ID查询Conclusion
	 * @param conclusion
	 * @return
	 */
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
