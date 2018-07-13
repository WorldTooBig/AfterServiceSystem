package com.yinlong.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.yinlong.entity.Company;
import com.yinlong.service.ICompanyService;

@Controller("companyAction")
@Scope("prototype")
public class CompanyAction {

	@Resource(name = "companyService")
	private ICompanyService companyService;
	
	private Company company;
	private List<Company> list;
	
	
	/**
	 * 添加公司
	 * @return
	 */
	public String addCompany() {
		if(companyService.addCompany(company)) {
			
		}
		return "addCompany";
	}
	
	/**
	 * 查询所有公司信息
	 * @return
	 */
	public String findCompanyList() {
		list = companyService.findCompanyList();
		ActionContext.getContext().getSession().put("compList", list);
		return "findCompanyList";
	}
	
	public String findCompanyListJson() {
		list = companyService.findCompanyList();
		return "findCompanyListJson";
	}
	
	/**
	 * 根据ID查询公司信息
	 * @return
	 */
	public String findCompanyById() {
		company = companyService.findCompanyById(company);
		return "findCompanyById";
	}
	
	

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<Company> getList() {
		return list;
	}

	public void setList(List<Company> list) {
		this.list = list;
	}

	public void setCompanyService(ICompanyService companyService) {
		this.companyService = companyService;
	}
	
	
}
