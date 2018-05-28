package com.yinlong.service;

import java.util.List;

import com.yinlong.entity.Company;
import com.yinlong.entity.Department;

public interface IDepartmentService {

	/**
	 * ��Ӳ���
	 * @param department
	 * @return
	 */
	public boolean addDepartment(Department department);
	
	/**
	 * ��ѯ���еĲ�����Ϣ  ���ݹ�˾ID
	 * @return
	 */
	public List<Department> findDepartmentList(Company company);
}
