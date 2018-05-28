package com.yinlong.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yinlong.dao.ICompanyDao;
import com.yinlong.entity.Company;

@Repository("companyDao")
public class CompanyDaoImpl extends BaseDao implements ICompanyDao {

	/**
	 * 根据 HQL语句查询公司信息
	 * @param hql
	 * @return
	 */
	public List<Company> queryCompanyHql(String hql) {
		try {
			return getSession().createQuery(hql).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 根据SQL语句查询需要的信息
	 * @param sql
	 * @return
	 */
	public List queryCompanySql(String sql) {
		try {
			return getSession().createSQLQuery(sql).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 添加公司
	 * @param company
	 * @return
	 */
	public boolean addCompany(Company company) {
		try {
			getSession().save(company);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 根据ID查询公司信息
	 * @param company
	 * @return
	 */
	public Company queryCompanyById(Company company) {
		try {
			return getSession().get(Company.class, company.getCompId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
