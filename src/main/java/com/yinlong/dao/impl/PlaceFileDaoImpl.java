package com.yinlong.dao.impl;

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
	public boolean addPlaceFile(PlaceFile placeFile) {
		try {
			getSession().saveOrUpdate(placeFile);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
