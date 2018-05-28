package com.yinlong.dao;

import java.util.List;

import com.yinlong.entity.Section;

public interface ISectionDao {

	/**
	 * ��ӿ���
	 * @param section
	 * @return
	 */
	public boolean addSection(Section section);
	
	/**
	 * ����HQL����ȡ��Ϣ
	 * @param hql
	 * @return
	 */
	public List<Section> querySectionListHql(String hql);
}
