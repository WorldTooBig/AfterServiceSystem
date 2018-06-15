package com.yinlong.dao;

import java.util.List;

import com.yinlong.entity.Section;

public interface ISectionDao {

	/**
	 * 添加科室
	 * @param section
	 * @return
	 */
	public boolean addSection(Section section);
	
	/**
	 * 根据HQL语句获取信息
	 * @param hql
	 * @return
	 */
	public List<Section> querySectionListHql(String hql);
}
