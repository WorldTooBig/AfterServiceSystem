package com.yinlong.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yinlong.dao.ISectionDao;
import com.yinlong.entity.Department;
import com.yinlong.entity.Section;
import com.yinlong.service.ISectionService;

@Service("sectionService")
@Transactional(propagation = Propagation.REQUIRED)
public class SectionServiceImpl implements ISectionService {

	@Resource(name = "sectionDao")
	private ISectionDao sectionDao;

	public void setSectionDao(ISectionDao sectionDao) {
		this.sectionDao = sectionDao;
	}

	
	/**
	 * 添加科室
	 * @param section
	 * @return
	 */
	public boolean addSection(Section section) {
		return sectionDao.addSection(section);
	}

	/**
	 * 查询所有科室信息
	 * @return
	 */
	public List<Section> findSectionList(Department department) {
		String hql = "from Section s where s.department.deptId = " + department.getDeptId();
		return sectionDao.querySectionListHql(hql);
	}

}
