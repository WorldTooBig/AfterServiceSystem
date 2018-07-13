package com.yinlong.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yinlong.dao.IDelayDao;
import com.yinlong.entity.RequestDelay;
import com.yinlong.service.IDelayService;

@Service("delayService")
@Transactional(propagation = Propagation.REQUIRED)
public class DelayServiceImpl implements IDelayService {

	@Resource(name = "delayDao")
	private IDelayDao delayDao;
	
	public void setDelayDao(IDelayDao delayDao) {
		this.delayDao = delayDao;
	}

	@Override
	public boolean addDelay(RequestDelay delay) {
		return delayDao.addDelay(delay);
	}


	/**
	 * 根据ID查询Delay
	 * @param delay
	 * @return
	 */
	@Override
	public RequestDelay findDelayById(RequestDelay delay) {
		return delayDao.findDelayById(delay);
	}

	/**
	 * 待审批的确认申请
	 */
	@Override
	public List<RequestDelay> findDelayList(int repHandleStep) {
		String hql = "from RequestDelay where reply.repHandleStep = " + repHandleStep + " and reply.deadline.placeFile.feedback.process.proId = 9 ";
		return delayDao.queryDelayList(hql);
	}

}
