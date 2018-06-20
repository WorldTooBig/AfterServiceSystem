package com.yinlong.service;

import java.util.List;

import com.yinlong.entity.PlaceFile;

public interface IPlaceFileService {
	
	/**
	 * 添加归档
	 * @param placeFile
	 * @return
	 */
	public boolean addPlaceFile(PlaceFile placeFile);
	
	/**
	 * 查询所有的PlaceFile
	 * @return
	 */
	public List<PlaceFile> findPlaceFileList();

	/**
	 * 根据ID查询PlaceFile
	 * @param placeFile
	 * @return
	 */
	public PlaceFile findPlaceFileById(PlaceFile placeFile);
	
}
