package com.yinlong.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.yinlong.entity.Company;
import com.yinlong.entity.Department;
import com.yinlong.service.IDepartmentService;

@Controller("departmentAction")
@Scope("prototype")
public class DepartmentAction {

	@Resource(name = "departmentService")
	private IDepartmentService departmentService;
	
	private Company company;
	private Department department;
	private List<Department> list;
	

	/**
	 * ��Ӳ���
	 * @return
	 */
	public String addDepartment() {
		department.setCompany(company);
		if (departmentService.addDepartment(department)) {
			 //////////////////////////////
		}
		return "addDepartment";
	}
	
	/**
	 * ��ѯ���в�����Ϣ,���ݹ�˾ID
	 * @return
	 */
	public String findDepartmentList() {
		list = departmentService.findDepartmentList(company);
		return "findDepartmentList";
	}
	
	
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public List<Department> getList() {
		return list;
	}
	public void setList(List<Department> list) {
		this.list = list;
	}
	public void setDepartmentService(IDepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	
}
