package com.yinlong.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yinlong.dao.ICompanyDao;
import com.yinlong.entity.Company;

@Repository("companyDao")
public class CompanyDaoImpl extends BaseDao implements ICompanyDao {

	/**
	 * ���� HQL����ѯ��˾��Ϣ
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
	 * ����SQL����ѯ��Ҫ����Ϣ
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
	 * ��ӹ�˾
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
	 * ����ID��ѯ��˾��Ϣ
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
