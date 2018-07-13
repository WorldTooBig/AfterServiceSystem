package com.yinlong.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.yinlong.entity.ProductType;
import com.yinlong.service.IProductTypeService;

@Controller("productTypeAction")
@Scope("prototype")
public class ProductTypeAction {

	@Resource(name = "productTypeService")
	private IProductTypeService productTypeService;
	
	private List<ProductType> productTypeList;
	
	/**
	 * 获得所有的ProductType
	 * @return
	 */
	public String findProductTypeList() {
		productTypeList = productTypeService.findProductTypeList();
		if(productTypeList != null) {
			return "findProductTypeList";
		} else {
			return "error";
		}
	}

	public List<ProductType> getProductTypeList() {
		return productTypeList;
	}
	public void setProductTypeList(List<ProductType> productTypeList) {
		this.productTypeList = productTypeList;
	}
	public void setProductTypeService(IProductTypeService productTypeService) {
		this.productTypeService = productTypeService;
	}
	
	
}
