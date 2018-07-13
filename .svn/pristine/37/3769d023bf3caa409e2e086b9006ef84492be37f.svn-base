package com.yinlong.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yinlong.dao.IProblemTypeDao;
import com.yinlong.entity.ProblemType;

@Repository("problemTypeDao")
public class ProblemTypeDaoImpl extends BaseDao implements IProblemTypeDao {
	
	/**
	 * 查询所有的ProblemType
	 * @param hql
	 * @return
	 */
	@Override
	public List<ProblemType> findProblemTypeList(String hql) {
		try {
			return getSession().createQuery(hql).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
