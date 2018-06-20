package com.yinlong.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yinlong.dao.INotifiedDao;
import com.yinlong.entity.Notified;
import com.yinlong.service.INotifiedService;

@Service("notifiedService")
@Transactional(propagation = Propagation.REQUIRED)
public class NotifiedServiceImpl implements INotifiedService {

	@Resource(name = "notifiedDao")
	private INotifiedDao notifiedDao;
	
	public void setNotifiedDao(INotifiedDao notifiedDao) {
		this.notifiedDao = notifiedDao;
	}

	/**
	 * 查询所有的Notified
	 * @return
	 */
	@Override
	public List<Notified> findNotifiedList() {
		String hql = "from Notified";
		return notifiedDao.findNotifiedList(hql);
	}

	/**
	 * 添加Notified
	 * @param notified
	 * @return
	 */
	@Override
	public boolean addNotified(Notified notified) {
		return notifiedDao.addNotified(notified);
	}

}
