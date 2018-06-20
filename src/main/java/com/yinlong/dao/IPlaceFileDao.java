package com.yinlong.dao;

import java.util.List;

import com.yinlong.entity.PlaceFile;

public interface IPlaceFileDao {

	/**
	 * 添加归档
	 * @param placeFile
	 * @return
	 */
	public boolean addPlaceFile(PlaceFile placeFile);
	
	/**
	 * 查询所有的PlaceFile
	 * @param hql
	 * @return
	 */
	public List<PlaceFile> findPlacefileList(String hql);
	
	/**
	 * 根据ID查询PlaceFile
	 * @param placeFile
	 * @return
	 */
	public PlaceFile findPlaceFileById(PlaceFile placeFile);
}
