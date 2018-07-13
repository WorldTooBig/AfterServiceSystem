package com.yinlong.dao;

import java.util.List;

import com.yinlong.entity.Company;

public interface ICompanyDao {

	/**
	 * 根据 HQL语句查询公司信息
	 * @param hql
	 * @return
	 */
	public List<Company> queryCompanyHql(String hql);
	
	/**
	 * 根据SQL语句查询需要的信息
	 * @param sql
	 * @return
	 */
	public List queryCompanySql(String sql);
	
	/**
	 * 添加公司
	 * @param company
	 * @return
	 */
	public boolean addCompany(Company company);
	
	/**
	 * 根据ID查询公司信息
	 * @param company
	 * @return
	 */
	public Company queryCompanyById(Company company);
}
