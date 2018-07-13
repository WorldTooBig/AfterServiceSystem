package com.yinlong.service;

import java.util.List;

import com.yinlong.entity.Conclusion;

public interface IConclusionService {

	/**
	 * 添加
	 * @param conclusion
	 * @return
	 */
	public boolean addConclusion(Conclusion conclusion);

	/**
	 * 查询所有Conclusion
	 * @param hql
	 * @return
	 */
	public List<Conclusion> findConclusion();

	/**
	 * 根据ID查询Conclusion
	 * @param conclusion
	 * @return
	 */
	public Conclusion findConclusionById(Conclusion conclusion);
	
	/**
	 * 查询本部门的待审核结论单
	 * @return
	 */
	public List<Conclusion> findConclusionListOnDept(int proId);
	
}
