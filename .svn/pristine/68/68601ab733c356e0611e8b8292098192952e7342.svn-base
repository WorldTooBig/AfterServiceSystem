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
	 * 添加公司
	 * @param company
	 * @return
	 */
	public boolean addCompany(Company company) {
		return companyDao.addCompany(company);
	}

	/**
	 * 查询所有公司信息
	 * @return
	 */
	public List<Company> findCompanyList() {
		String hql = "from Company";
		return companyDao.queryCompanyHql(hql);
	}

	/**
	 * 根据ID查询公司信息
	 * @param company
	 * @return
	 */
	public Company findCompanyById(Company company) {
		return companyDao.queryCompanyById(company);
	}

}
