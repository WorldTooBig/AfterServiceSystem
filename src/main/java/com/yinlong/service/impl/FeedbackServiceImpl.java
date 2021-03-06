package com.yinlong.service.impl;

import java.util.List;

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

	/**
	 * 查询所有反馈单
	 * @return
	 */
	@Override
	public List<Feedback> findfeedbackList() {
		String hql = "from Feedback";
		return feedbackDao.findFeedBackList(hql);
	}

	/**
	 * 查询所有待归档的反馈单
	 * @return
	 */
	@Override
	public List<Feedback> findfeedbackListBending() {
		String hql = "from Feedback where process.proId = 2";
		return feedbackDao.findFeedBackList(hql);
	}

	/**
	 * 按需查询反馈单
	 * @param feedback
	 * @return
	 */
	@Override
	public List<Feedback> findfeedbackListLike(Feedback feedback) {
		String hql = "from Feedback where 1=1";
		// 编号
		if(feedback.getDocId() != null && feedback.getDocId() != "")
			hql += " and docId like '%" + feedback.getDocId() + "%' ";
		// 主题
		if(feedback.getDocTheme() != null && feedback.getDocTheme() != "")
			hql += " and docTheme like '%" + feedback.getDocTheme() + "%' ";
		// 发现地点
		if(feedback.getDocFindAddr() != null && feedback.getDocFindAddr() != "")
			hql += " and docFindAddr like '%" + feedback.getDocFindAddr() + "%' ";
		// 客户名称
		if(feedback.getDocCustName() != null && feedback.getDocCustName() != "")
			hql += " and docCustName like '%" + feedback.getDocCustName() + "%' ";
		// 产品型号
		if(feedback.getDocProMode() != null && feedback.getDocProMode() != "")
			hql += " and docProMode like '%" + feedback.getDocProMode() + "%' ";
		// 订单号
		if(feedback.getDocOrderNum() != null && feedback.getDocOrderNum() != "")
			hql += " and docOrderNum like '%" + feedback.getDocOrderNum() + "%' ";
		// 生产单位
		if(feedback.getDocProDep() != null && feedback.getDocProDep() != "")
			hql += " and docProDep like '%" + feedback.getDocProDep() + "%' ";
		// 生产班组
		if(feedback.getDocProTeam() != null && feedback.getDocProTeam() != "")
			hql += " and docProTeam like '%" + feedback.getDocProTeam() + "%' ";
		// 物料类型
		if(feedback.getDocItemType() != null && feedback.getDocItemType() != "")
			hql += " and docItemType like '%" + feedback.getDocItemType() + "%' ";
		// 物料名称
		if(feedback.getDocItemName() != null && feedback.getDocItemName() != "")
			hql += " and docItemName like '%" + feedback.getDocItemName() + "%' ";
		// 物料编码
		if(feedback.getDocItemNum() != null && feedback.getDocItemNum() != "")
			hql += " and docItemNum like '%" + feedback.getDocItemNum() + "%' ";
		// 供应商名称
		if(feedback.getDocSupName() != null && feedback.getDocSupName() != "")
			hql += " and docSupName like '%" + feedback.getDocSupName() + "%' ";
		// 停线工时损失
		if(feedback.getDocLoss() != null && feedback.getDocLoss() != "")
			hql += " and docLoss like '%" + feedback.getDocLoss() + "%' ";
		// 使用数量
		if(feedback.getDocUsedCounts() != 0)
			hql += " and docUsedCounts = " + feedback.getDocUsedCounts() + " ";
		// 不良品数量
		if(feedback.getDocDefproCounts() != 0)
			hql += " and docDefproCounts = " + feedback.getDocDefproCounts() + " ";
		// 不合格严重等级
		if(feedback.getDocSeverityLevel() != null && feedback.getDocSeverityLevel() != "")
			hql += " and docSeverityLevel like '%" + feedback.getDocSeverityLevel() + "%' ";
		// 是否批量
		if(feedback.getDocIsBatch() == 0 || feedback.getDocIsBatch() == 1)
			hql += " and docIsBatch = " + feedback.getDocIsBatch() + " ";
		// 产品类别
		if(feedback.getProductType().getPdtId() != 0)
			hql += " and productType.pdtId = " + feedback.getProductType().getPdtId()+ "";
		// 责任单位 反馈人 反馈时间  状态   发现时间
		return feedbackDao.findFeedBackList(hql);
	}
	
	

}
