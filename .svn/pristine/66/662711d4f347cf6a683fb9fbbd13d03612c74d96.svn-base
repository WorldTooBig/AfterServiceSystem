package com.yinlong.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.yinlong.entity.Department;
import com.yinlong.entity.Section;
import com.yinlong.service.ISectionService;

@Controller("sectionAction")
@Scope("prototype")
public class SectionAction {

	@Resource(name = "sectionService")
	private ISectionService sectionService;
	
	private Department department;
	private Section section;
	
	private List<Section> list;

	
	/**
	 * 添加科室
	 * @return
	 */
	public String addSection() {
		section.setDepartment(department);
		if (sectionService.addSection(section)) {
			
		}
		return "addSection";
	}
	
	/**
	 * 查询所有科室信息
	 * @return
	 */
	public String findSectionList() {
		list = sectionService.findSectionList(department);
		return "findSectionList";
	}
	
	
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public List<Section> getList() {
		return list;
	}

	public void setList(List<Section> list) {
		this.list = list;
	}

	public void setSectionService(ISectionService sectionService) {
		this.sectionService = sectionService;
	}
	
	
}
