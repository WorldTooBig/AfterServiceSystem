package com.yinlong.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yinlong.dao.IFeedbackDao;
import com.yinlong.entity.Feedback;
import com.yinlong.service.IFeedbackService;


@Service("feedbackService")
@Transactional(propagation = Propagation.REQUIRED)
public class FeedbackServiceImpl implements IFeedbackService {

	@Resource(name = "feedbackDao")
	private IFeedbackDao feedbackDao;
	
	public void setFeedbackDao(IFeedbackDao feedbackDao) {
		this.feedbackDao = feedbackDao;
	}


	/**
	 * 添加反馈单
	 * @param feedback
	 * @return
	 */
	@Override
	public boolean addOrUpdateFeedback(Feedback feedback) {
		return feedbackDao.addAndUpdateFeedback(feedback);
	}

	/**
	 * 根据id查询反馈单
	 * @param feedback
	 * @return
	 */
	@Override
	public Feedback findFeedbackById(Feedback feedback) {
		return feedbackDao.findFeedbackById(feedback);
	}

}
