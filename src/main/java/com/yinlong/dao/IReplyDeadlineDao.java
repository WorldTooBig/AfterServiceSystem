package com.yinlong.dao;

import java.util.List;

import com.yinlong.entity.Reply;

public interface IReplyDeadlineDao {

	/**
	 * 添加
	 * @param reply
	 * @return
	 */
	public boolean addReplyDeadline(Reply reply);
	
	/**
	 * 查询所有Reply
	 * @param hql
	 * @return
	 */
	public List<Reply> findReplyListDeadline(String hql);

	/**
	 * 根据ID查询Reply
	 * @param reply
	 * @return
	 */
	public Reply findReplyByIdDeadline(Reply reply);
	
	/**
	 * 查询答复中和所有答复完成待下结论的Deadline
	 * @param hql
	 * @return
	 */
	public int findReplyCountDeadline(String hql);
}
