package com.yinlong.service;

import java.util.List;

import com.yinlong.entity.Department;
import com.yinlong.entity.Section;

public interface ISectionService {

	/**
	 * ��ӿ���
	 * @param section
	 * @return
	 */
	public boolean addSection(Section section);
	
	/**
	 * ��ѯ���п�����Ϣ
	 * @return
	 */
	public List<Section> findSectionList(Department department);
	
}
