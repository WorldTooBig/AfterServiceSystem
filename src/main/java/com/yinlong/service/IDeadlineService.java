package com.yinlong.service;

import java.util.List;

import com.yinlong.entity.Deadline;

public interface IDeadlineService {

	/**
	 * 添加
	 * @param deadline
	 * @return
	 */
	public boolean addDeadline(Deadline deadline);
	
	/**
	 * 查询
	 * @param proId
	 * @return
	 */
	public List<Deadline> findDeadlineList(int proId);

	/**
	 * 根据ID查询Deadline
	 * @param deadline
	 * @return
	 */
	public Deadline findDeadlineById(Deadline deadline);
	
	/**
	 * 查询待下结论的Deadline
	 * @return
	 */
	public List<Deadline> findDeadlineOnConclusion();
	
}
