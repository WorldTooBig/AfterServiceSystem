package com.yinlong.service;

import java.util.List;

import com.yinlong.entity.Notified;

public interface INotifiedService {
	
	/**
	 * 添加Notified
	 * @param notified
	 * @return
	 */
	public boolean addNotified(Notified notified);
	
	/**
	 * 查询所有的Notified
	 * @return
	 */
	public List<Notified> findNotifiedList();
}
