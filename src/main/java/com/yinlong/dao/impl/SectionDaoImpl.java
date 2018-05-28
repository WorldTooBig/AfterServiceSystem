package com.yinlong.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yinlong.dao.ISectionDao;
import com.yinlong.entity.Section;

@Repository("sectionDao")
public class SectionDaoImpl extends BaseDao implements ISectionDao {

	/**
	 * ��ӿ���
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
	 * ����HQL����ȡ��Ϣ
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
