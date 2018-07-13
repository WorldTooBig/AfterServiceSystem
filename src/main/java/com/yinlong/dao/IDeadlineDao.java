package com.yinlong.dao;

import java.util.List;

import com.yinlong.entity.Deadline;

public interface IDeadlineDao {

	/**
	 * 添加
	 * @param deadline
	 * @return
	 */
	public boolean addDeadline(Deadline deadline);
	
	/**
	 * 根据hql语句查询Deadline集合
	 * @param hql
	 * @return
	 */
	public List<Deadline> queryDeadline(String hql);
	
	/**
	 * 根据ID查询Deadline
	 * @param deadline
	 * @return
	 */
	public Deadline queryDeadlineById(Deadline deadline);
}
