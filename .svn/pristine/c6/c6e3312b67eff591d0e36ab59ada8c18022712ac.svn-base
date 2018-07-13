package com.yinlong.service;

import java.util.List;

import com.yinlong.entity.Deadline;
import com.yinlong.entity.Reply;

public interface IReplyDeadlineService {


	/**
	 * 添加
	 * @param reply
	 * @return
	 */
	public boolean addReplyDeadline(Reply reply);


	/**
	 * 该Deadline的所有Reply是否都答复完毕
	 * @param notified
	 * @return
	 */
	public boolean ReplyIsHandleEnd(Deadline deadline);
	
	/**
	 * 查询所有待处理的答复单
	 * @param repHandleStep
	 * @return
	 */
	public List<Reply> findReplyOnDeadline(int repHandleStep);
	
	/**
	 * 查询所有待确认申请的答复单
	 * @param repHandleStep
	 * @return
	 */
	public List<Reply> findReplyOnDelay(int repHandleStep);
	
	/**
	 * 根据Deadline查询
	 * @param deadline
	 * @return
	 */
	public List<Reply> findReplyByDeadline(Deadline deadline);
	
	/**
	 * 根据ID查询Reply
	 * @param reply
	 * @return
	 */
	public Reply findReplyById(Reply reply);
}
