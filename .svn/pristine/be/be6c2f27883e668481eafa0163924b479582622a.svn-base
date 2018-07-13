package com.yinlong.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yinlong.dao.IConDeadlineDao;
import com.yinlong.entity.Conclusion;
import com.yinlong.service.IConDeadlineService;

@Service("conDeadlineService")
@Transactional(propagation = Propagation.REQUIRED)
public class ConDeadlineServiceImpl implements IConDeadlineService {

	@Resource(name = "conDeadlineDao")
	private IConDeadlineDao conDeadlineDao;

	public void setConDeadlineDao(IConDeadlineDao conDeadlineDao) {
		this.conDeadlineDao = conDeadlineDao;
	}

	@Override
	public boolean addConclusion(Conclusion conclusion) {
		return conDeadlineDao.addConclusion(conclusion);
	}

	@Override
	public List<Conclusion> findConclusionList(int proId) {
		String hql = "select c from Conclusion c left join c.replyList r where r.deadline.placeFile.feedback.process.proId = " + proId + " "
				+ "and (select count(*) from ProcessRecord where process.proId = 15) > 0";
		return conDeadlineDao.findConclusion(hql);
	}

	@Override
	public Conclusion findConclusionById(Conclusion conclusion) {
		return conDeadlineDao.findConclusionById(conclusion);
	}

}
