package com.yinlong.dao;

import java.util.List;

import com.yinlong.entity.Reply;

public interface IReplyDao {

	/**
	 * 添加
	 * @param reply
	 * @return
	 */
	public boolean addReply(Reply reply);
	
	/**
	 * 查询所有Reply
	 * @param hql
	 * @return
	 */
	public List<Reply> findReplyList(String hql);

	/**
	 * 根据ID查询Reply
	 * @param reply
	 * @return
	 */
	public Reply findReplyById(Reply reply);
	
	/**
	 * 查询答复中和所有答复完成待下结论的Notified
	 * @param hql
	 * @return
	 */
	public int findReplyCount(String hql);
}
