package com.yinlong.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yinlong.dao.ICompanyDao;
import com.yinlong.entity.Company;
import com.yinlong.service.ICompanyService;

@Service("companyService")
@Transactional(propagation = Propagation.REQUIRED)
public class CompanyServiceImpl implements ICompanyService {
	
	@Resource(name = "companyDao")
	private ICompanyDao companyDao;

	public void setCompanyDao(ICompanyDao companyDao) {
		this.companyDao = companyDao;
	}
	
	/**
	 * ��ӹ�˾
	 * @param company
	 * @return
	 */
	public boolean addCompany(Company company) {
		return companyDao.addCompany(company);
	}

	/**
	 * ��ѯ���й�˾��Ϣ
	 * @return
	 */
	public List<Company> findCompanyList() {
		String hql = "from Company";
		return companyDao.queryCompanyHql(hql);
	}

	/**
	 * ����ID��ѯ��˾��Ϣ
	 * @param company
	 * @return
	 */
	public Company findCompanyById(Company company) {
		return companyDao.queryCompanyById(company);
	}

}
