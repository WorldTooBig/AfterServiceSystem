package com.yinlong.service;

import java.util.List;

import com.yinlong.entity.Notified;
import com.yinlong.entity.Reply;

public interface IReplyService {


	/**
	 * 添加
	 * @param reply
	 * @return
	 */
	public boolean addReply(Reply reply);

	/**
	 * 根据ID查询Reply
	 * @param reply
	 * @return
	 */
	public Reply findReplyById(Reply reply);
	
	/**
	 * 根据Notified查询Reply Notifid下的所有Reply
	 * @param notified
	 * @return
	 */
	public List<Reply> findReplyByNotified(Notified notified);
	
	/**
	 * 查询所有的Reply 
	 * @return
	 */
	public List<Reply> findReplyList();
	
	/**
	 * 查询登录人部门的答复单
	 * @param repHandleStep
	 * @return
	 */
	public List<Reply> findReplyOnDept(int repHandleStep);
	
	/**
	 * 该Notified的所有Reply是否都答复完毕
	 * @param notified
	 * @return
	 */
	public boolean ReplyIsHandleEnd(Notified notified);
	
	/**
	 * 查询待处理的限期整改单
	 * @return
	 */
	public List<Reply> findReplyOnDeadline();
	
	/**
	 * 查询等待下结论的考核单中的所有Reply
	 * @return
	 */
	public List<Reply> findReplyOnConclusion(Notified notified);
}
