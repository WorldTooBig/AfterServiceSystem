package com.yinlong.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yinlong.dao.IDepartmentDao;
import com.yinlong.entity.Company;
import com.yinlong.entity.Department;
import com.yinlong.service.IDepartmentService;

@Service("departmentService")
@Transactional(propagation = Propagation.REQUIRED)
public class DepartmentServiceImpl implements IDepartmentService {

	@Resource(name = "departmentDao")
	private IDepartmentDao departmentDao;
	
	public void setDepartmentDao(IDepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}


	/**
	 * 添加部门
	 * @param department
	 * @return
	 */
	public boolean addDepartment(Department department) {
		return departmentDao.addDepartment(department);
	}
	
	/**
	 * 查询所有的部门信息  根据公司ID
	 * @return
	 */
	public List<Department> findDepartmentList(Company company) {
		String hql = "from Department d where d.company.compId = " + company.getCompId();
		return departmentDao.queryDepartmentListHql(hql);
	}

}
