package com.yinlong.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yinlong.dao.IPlaceFileDao;
import com.yinlong.entity.PlaceFile;

@Repository("placeFileDao")
public class PlaceFileDaoImpl extends BaseDao implements IPlaceFileDao {
	
	/**
	 * 添加归档
	 * @param placeFile
	 * @return
	 */
	@Override
	public boolean addPlaceFile(PlaceFile placeFile) {
		try {
			getSession().saveOrUpdate(placeFile);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 查询所有的PlaceFile
	 * @param hql
	 * @return
	 */
	@Override
	public List<PlaceFile> findPlacefileList(String hql) {
		try {
			return getSession().createQuery(hql).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 根据ID查询PlaceFile
	 * @param placeFile
	 * @return
	 */
	@Override
	public PlaceFile findPlaceFileById(PlaceFile placeFile) {
		try {
			return getSession().get(PlaceFile.class, placeFile.getPlaId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
