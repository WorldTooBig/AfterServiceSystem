package com.yinlong.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;
import com.yinlong.dao.IConclusionDao;
import com.yinlong.entity.Conclusion;
import com.yinlong.entity.User;
import com.yinlong.service.IConclusionService;

@Service("conclusionService")
@Transactional(propagation = Propagation.REQUIRED)
public class ConclusionServiceImpl implements IConclusionService {

	@Resource(name = "conclusionDao")
	private IConclusionDao conclusionDao;
	
	public void setConclusionDao(IConclusionDao conclusionDao) {
		this.conclusionDao = conclusionDao;
	}

	/**
	 * 添加
	 * @param conclusion
	 * @return
	 */
	@Override
	public boolean addConclusion(Conclusion conclusion) {
		return conclusionDao.addConclusion(conclusion);
	}

	/**
	 * 查询所有Conclusion
	 * @param hql
	 * @return
	 */
	@Override
	public List<Conclusion> findConclusion() {
		String hql = "from Conclusion";
		return conclusionDao.findConclusion(hql);
	}

	/**
	 * 根据ID查询Conclusion
	 * @param conclusion
	 * @return
	 */
	@Override
	public Conclusion findConclusionById(Conclusion conclusion) {
		return conclusionDao.findConclusionById(conclusion);
	}

	/**
	 * 查询本部门的待审核结论单
	 * 登录人部门=反馈单审批人部门
	 * 当前节点=10,11
	 * @return
	 */
	@Override
	public List<Conclusion> findConclusionListOnDept(int proId) {
		/*User user = (User) ActionContext.getContext().getSession().get("user_login");
		String hql = "select c from Conclusion c left join c.replyList r left join ProcessRecord p on r.notified.placeFile.feedback.docId = p.feedback.docId "
				+ "where r.notified.placeFile.feedback.process.proId = " + proId + " and p.process.proId = 7 "
						+ "and r.department.deptId = p.user.section.department.deptId "
						+ "and p.user.section.department.deptId = " + user.getSection().getDepartment().getDeptId();*/
		String hql  = "select c from Conclusion c left join c.replyList r where r.notified.placeFile.feedback.process.proId = " + proId + " "
				+ "";
		return conclusionDao.findConclusion(hql);
	}

}
