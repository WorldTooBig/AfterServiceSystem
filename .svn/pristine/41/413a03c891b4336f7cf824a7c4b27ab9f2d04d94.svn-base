package com.yinlong.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yinlong.dao.ISectionDao;
import com.yinlong.entity.Section;

@Repository("sectionDao")
public class SectionDaoImpl extends BaseDao implements ISectionDao {

	/**
	 * 添加科室
	 * @param section
	 * @return
	 */
	public boolean addSection(Section section) {
		try {
			getSession().save(section);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 根据HQL语句获取信息
	 * @param hql
	 * @return
	 */
	public List<Section> querySectionListHql(String hql) {
		try {
			return getSession().createQuery(hql).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
