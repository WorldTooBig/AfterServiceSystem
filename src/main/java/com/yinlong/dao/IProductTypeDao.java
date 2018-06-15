package com.yinlong.dao;

import java.util.List;

import com.yinlong.entity.ProductType;

public interface IProductTypeDao {

	/**
	 * 查找所有的ProductType
	 * @return
	 */
	public List<ProductType> findProductTypeList(String hql);
}
