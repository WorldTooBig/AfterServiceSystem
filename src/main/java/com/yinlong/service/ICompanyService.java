package com.yinlong.service;

import java.util.List;

import com.yinlong.entity.Company;

public interface ICompanyService {

	/**
	 * 添加公司
	 * @param company
	 * @return
	 */
	public boolean addCompany(Company company);
	
	/**
	 * 查询所有公司信息
	 * @return
	 */
	public List<Company> findCompanyList();
	
	/**
	 * 根据ID查询公司信息
	 * @param company
	 * @return
	 */
	public Company findCompanyById(Company company);
}
