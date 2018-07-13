package com.yinlong.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yinlong.dao.IProductTypeDao;
import com.yinlong.entity.ProductType;

@Repository("productTypeDao")
public class ProductTypeDaoImpl extends BaseDao implements IProductTypeDao {

	/**
	 * 查找所有的ProductType
	 */
	@Override
	public List<ProductType> findProductTypeList(String hql) {
		try {
			return getSession().createQuery(hql).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
