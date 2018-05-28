package com.yinlong.service;

import java.util.List;

import com.yinlong.entity.Company;

public interface ICompanyService {

	/**
	 * ��ӹ�˾
	 * @param company
	 * @return
	 */
	public boolean addCompany(Company company);
	
	/**
	 * ��ѯ���й�˾��Ϣ
	 * @return
	 */
	public List<Company> findCompanyList();
	
	/**
	 * ����ID��ѯ��˾��Ϣ
	 * @param company
	 * @return
	 */
	public Company findCompanyById(Company company);
}
