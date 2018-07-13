package com.yinlong.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yinlong.dao.IReplyDao;
import com.yinlong.entity.Reply;

@Repository("replyDao")
public class ReplyDaoImpl extends BaseDao implements IReplyDao {

	/**
	 * 添加
	 * @param reply
	 * @return
	 */
	@Override
	public boolean addReply(Reply reply) {
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
	public Reply findReplyById(Reply reply) {
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
	public List<Reply> findReplyList(String hql) {
		try {
			return getSession().createQuery(hql).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 查询答复中和所有答复完成待下结论的Notified
	 * @param hql
	 * @return
	 */
	@Override
	public int findReplyCount(String hql) {
		try {
			Long count = (Long) getSession().createQuery(hql).uniqueResult();
			return count.intValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
