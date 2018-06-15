package com.yinlong.dao;

import com.yinlong.entity.Feedback;

public interface IFeedbackDao {

	/**
	 * 添加或修改反馈单
	 * @param feedback
	 * @return
	 */
	public boolean addAndUpdateFeedback(Feedback feedback);
	
	/**
	 * 根据ID查询反馈单
	 * @param feedback
	 * @return
	 */
	public Feedback findFeedbackById(Feedback feedback);
	
}
