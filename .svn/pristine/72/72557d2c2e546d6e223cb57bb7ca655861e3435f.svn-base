package com.yinlong.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yinlong.dao.IReplyDeadlineDao;
import com.yinlong.entity.Reply;

@Repository("replyDeadlineDao")
public class ReplyDeadlineDaoImpl extends BaseDao implements IReplyDeadlineDao {

	/**
	 * 添加
	 * @param reply
	 * @return
	 */
	@Override
	public boolean addReplyDeadline(Reply reply) {
		try {
			getSession().saveOrUpdate(reply);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 根据ID查询Reply
	 * @param reply
	 * @return
	 */
	@Override
	public Reply findReplyByIdDeadline(Reply reply) {
		try {
			return getSession().get(Reply.class, reply.getRepId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 查询所有Reply
	 * @param hql
	 * @return
	 */
	@Override
	public List<Reply> findReplyListDeadline(String hql) {
		try {
			return getSession().createQuery(hql).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @param hql
	 * @return
	 */
	@Override
	public int findReplyCountDeadline(String hql) {
		try {
			Long count = (Long) getSession().createQuery(hql).uniqueResult();
			return count.intValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
