package com.yinlong.dao;

import java.util.List;

import com.yinlong.entity.Company;

public interface ICompanyDao {

	/**
	 * ���� HQL����ѯ��˾��Ϣ
	 * @param hql
	 * @return
	 */
	public List<Company> queryCompanyHql(String hql);
	
	/**
	 * ����SQL����ѯ��Ҫ����Ϣ
	 * @param sql
	 * @return
	 */
	public List queryCompanySql(String sql);
	
	/**
	 * ��ӹ�˾
	 * @param company
	 * @return
	 */
	public boolean addCompany(Company company);
	
	/**
	 * ����ID��ѯ��˾��Ϣ
	 * @param company
	 * @return
	 */
	public Company queryCompanyById(Company company);
}
