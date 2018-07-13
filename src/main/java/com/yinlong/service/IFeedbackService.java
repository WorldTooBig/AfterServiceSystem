package com.yinlong.service;

import java.util.List;

import com.yinlong.entity.Feedback;

public interface IFeedbackService {

	/**
	 * 添加反馈单
	 * @param feedback
	 * @return
	 */
	public boolean addOrUpdateFeedback(Feedback feedback);
	
	/**
	 * 根据id查询反馈单
	 * @param feedback
	 * @return
	 */
	public Feedback findFeedbackById(Feedback feedback);

	/**
	 * 查询所有反馈单
	 * @return
	 */
	public List<Feedback> findfeedbackList();
	
	/**
	 * 查询所有待归档的反馈单
	 * @return
	 */
	public List<Feedback> findfeedbackListBending();
	
	/**
	 * 按需查询反馈单
	 * @param feedback
	 * @return
	 */
	public List<Feedback> findfeedbackListLike(Feedback feedback);
	
	
}
