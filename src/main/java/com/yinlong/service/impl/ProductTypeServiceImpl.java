package com.yinlong.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yinlong.dao.IProductTypeDao;
import com.yinlong.entity.ProductType;
import com.yinlong.service.IProductTypeService;

@Service("productTypeService")
@Transactional(propagation = Propagation.REQUIRED)
public class ProductTypeServiceImpl implements IProductTypeService {

	@Resource(name = "productTypeDao")
	private IProductTypeDao productTypeDao;
	
	public void setProductTypeDao(IProductTypeDao productTypeDao) {
		this.productTypeDao = productTypeDao;
	}

	/**
	 * 查询所有的ProductType
	 * @return
	 */
	@Override
	public List<ProductType> findProductTypeList() {
		String hql = "from ProductType";
		return productTypeDao.findProductTypeList(hql);
	}

}
