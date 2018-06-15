package com.yinlong.dao.impl;

import org.springframework.stereotype.Repository;

import com.yinlong.dao.IFeedbackDao;
import com.yinlong.entity.Feedback;

@Repository("feedbackDao")
public class FeedbackDaoImpl extends BaseDao implements IFeedbackDao {

	/**
	 * 添加或修改反馈单
	 * @param feedback
	 * @return
	 */
	@Override
	public boolean addAndUpdateFeedback(Feedback feedback) {
		try {
			getSession().saveOrUpdate(feedback);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 根据ID查询反馈单
	 * @param feedback
	 * @return
	 */
	@Override
	public Feedback findFeedbackById(Feedback feedback) {
		try {
			return getSession().get(Feedback.class, feedback.getDocId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
