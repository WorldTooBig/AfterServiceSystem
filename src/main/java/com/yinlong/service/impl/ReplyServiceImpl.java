package com.yinlong.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;
import com.yinlong.dao.IReplyDao;
import com.yinlong.entity.Notified;
import com.yinlong.entity.Reply;
import com.yinlong.entity.User;
import com.yinlong.service.IReplyService;

@Service("replyService")
@Transactional(propagation = Propagation.REQUIRED)
public class ReplyServiceImpl implements IReplyService {

	@Resource(name = "replyDao")
	private IReplyDao replyDao;
	
	public void setReplyDao(IReplyDao replyDao) {
		this.replyDao = replyDao;
	}

	/**
	 * 添加
	 * @param reply
	 * @return
	 */
	@Override
	public boolean addReply(Reply reply) {
		return replyDao.addReply(reply);
	}

	/**
	 * 根据ID查询Reply
	 * @param reply
	 * @return
	 */
	@Override
	public Reply findReplyById(Reply reply) {
		return replyDao.findReplyById(reply);
	}

	/**
	 * 查询所有Reply
	 * @param hql
	 * @return
	 */
	@Override
	public List<Reply> findReplyList() {
		String hql = "from Reply";
		return replyDao.findReplyList(hql);
	}

	/**
	 * 根据Notified查询Reply Notifid下的所有Reply
	 * @param notified
	 * @return
	 */
	@Override
	public List<Reply> findReplyByNotified(Notified notified) {
		String hql = "from Reply where notified.notId = " + notified.getNotId();
		return replyDao.findReplyList(hql);
	}

	/**
	 * 查询登录人部门的答复单,已答复，未审核
	 * @param repHandleStep 答复单状态节点
	 * @return
	 */
	@Override
	public List<Reply> findReplyOnDept(int repHandleStep) {
		User user = (User) ActionContext.getContext().getSession().get("user_login");
		String hql = "select r from Reply r where r.repHandleStep = " + repHandleStep + " and r.notified.placeFile.feedback.process.proId = 9 and r.department.deptId = " + user.getSection().getDepartment().getDeptId();           
		return replyDao.findReplyList(hql);
	}

	/**
	 * 查询登录人所在部门的答复单  未答复
	 * @return
	 */
/*	@Override
	public List<Reply> findReplyOnDepartment() {
		User user = (User) ActionContext.getContext().getSession().get("user_login");
		String hql = "from Reply where department.deptId=" + user.getSection().getDepartment().getDeptId() + " and repHandleStep=0 and notified.placeFile.feedback.process.proId=9";
		return replyDao.findReplyList(hql);
	}*/

	/**
	 * 该Notified的所有Reply是否都答复完毕
	 * @param notified
	 * @return
	 */
	@Override
	public boolean ReplyIsHandleEnd(Notified notified) {
		String hql = "select count(*) from Reply where notified.notId = " + notified.getNotId() + " and repHandleStep != 3";
		if (replyDao.findReplyCount(hql) == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 查询待处理的限期整改单
	 * @return
	 */
	@Override
	public List<Reply> findReplyOnDeadline() {
		User user = (User) ActionContext.getContext().getSession().get("user_login");
		String hql = "from Reply where department.deptId=" + user.getSection().getDepartment().getDeptId() + " and repHandleStep=0 and deadline.placeFile.feedback.process.proId=9";
		return replyDao.findReplyList(hql);
	}

	/**
	 * 查询等待下结论的考核单中的所有Reply
	 * @return
	 */
	@Override
	public List<Reply> findReplyOnConclusion(Notified notified) {
		String hql = "select r from Reply r left join r.notified n where n.placeFile.feedback.process.proId = 15 and n.notId = " + notified.getNotId();
		return replyDao.findReplyList(hql);
	}
	
	

}
