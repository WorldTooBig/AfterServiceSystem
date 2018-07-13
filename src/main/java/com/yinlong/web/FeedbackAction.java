package com.yinlong.web;


import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.yinlong.entity.Appraise;
import com.yinlong.entity.Deadline;
import com.yinlong.entity.Feedback;
import com.yinlong.entity.Notified;
import com.yinlong.entity.Process;
import com.yinlong.entity.ProcessRecord;
import com.yinlong.entity.User;
import com.yinlong.service.IDeadlineService;
import com.yinlong.service.IFeedbackService;
import com.yinlong.service.INotifiedService;
import com.yinlong.service.IProcessRecordService;
import com.yinlong.service.IProcessService;
import com.yinlong.util.AddProcessRecordUtil;
import com.yinlong.util.LayuiTableData;
import com.yinlong.util.MailUtil;

@Controller("feedbackAction")
@Scope("prototype")
public class FeedbackAction {

	@Resource(name = "feedbackService")
	private IFeedbackService feedbackService;
	@Resource(name = "processService")
	private IProcessService processService;
	@Resource(name = "processRecordService")
	private IProcessRecordService processRecordService;
	@Resource(name = "notifiedService")
	private INotifiedService notifiedService;
	@Resource(name = "deadlineService")
	private IDeadlineService deadlineService;
	
	private Feedback feedback;		
	private Process process;
	private ProcessRecord processRecord;
	private Notified notified;
	private Deadline deadline;
	
	private List<Feedback> feedbackList;
	private List<Appraise> appList;
	
	private List<User> addrList;
	private List<User> copyList;
	
	private String addrEmails;
	private String copyEmails;

	/**
	 * 填写新的反馈单
	 * @return
	 */
	public String addFeedback() {
		String result = "";
		if (appList != null) {
			appList.removeAll(Collections.singleton(null));		// 清除空值
			feedback.setAppSet(new HashSet<Appraise>(appList));
		}
		if (addrList != null) {
			addrList.removeAll(Collections.singleton(null));	// 清除空值
			feedback.setAddrUsers(new HashSet<User>(addrList));
		}
		if (copyList != null) {
			copyList.removeAll(Collections.singleton(null));	// 清除空值
			feedback.setCopyUsers(new HashSet<User>(copyList));
		}
		
		try {
			User user = (User) ActionContext.getContext().getSession().get("user_login");
			String head = feedback.getDocTheme();
			String body = "质量信息跟踪处理系统中，由\"" + user.getSection().getDepartment().getDeptName() + "--" + user.getUserRealName() 
						+ "\"填写的异常信息反馈单。<br><a href='http://localhost:8080/AfterServiceSystem/index.jsp'>点击这里登录处理或查看</a>";
			
			MailUtil.sendHTMLMessage(user.getUserEmail(), addrEmails != null ? addrEmails.split(",") : null, copyEmails != null ? copyEmails.split(",") : null, head, body);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*feedback.setDocCreateDate(new Date());
		//当前反馈单是否保存成功
		if(feedbackService.addOrUpdateFeedback(feedback)) {
			result = "填写成功";			// 保存成功则在操作流程中记录成功
		} else {
			result = "填写失败";			// 保存失败则在操作流程中记录失败
		}
		feedback.getProcess().setProId(1);			// 当前操作的流程节点
		AddProcessRecordUtil.addProcessRecord(feedback, feedback.getProcess(), result);	// 保存此次操作
*/		return "addFeedback";
	}

	/**
	 * 根据Notified查询Feedback
	 * @return
	 */
	public String findFeedbackByNotified() {
		notified = notifiedService.findNotifiedById(notified);
		feedback = notified.getPlaceFile().getFeedback();
		return "findFeedbackByNotified";
	}

	/**
	 * 根据Notified查询Feedback
	 * @return
	 */
	public String findFeedbackByDeadline() {
		deadline = deadlineService.findDeadlineById(deadline);
		feedback = deadline.getPlaceFile().getFeedback();
		return "findFeedbackByDeadline";
	}
	
	/**
	 * 查询所有反馈单
	 */
	public void findFeedbackList() throws IOException {
		feedbackList = feedbackService.findfeedbackListBending();
		LayuiTableData.layuiTableUserList(0, null, feedbackList.size(), feedbackList);
	}
	
	/**
	 * 根据条件筛选
	 * @throws IOException
	 */
	public void findLikeFeedbackList() throws IOException {
		feedbackList = feedbackService.findfeedbackListLike(feedback);
		LayuiTableData.layuiTableUserList(0, null, feedbackList.size(), feedbackList);
	}
	
	
	public void setFeedbackService(IFeedbackService feedbackService) {
		this.feedbackService = feedbackService;
	}
	public Feedback getFeedback() {
		return feedback;
	}
	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}
	public Process getProcess() {
		return process;
	}
	public void setProcess(Process process) {
		this.process = process;
	}
	public ProcessRecord getProcessRecord() {
		return processRecord;
	}
	public void setProcessRecord(ProcessRecord processRecord) {
		this.processRecord = processRecord;
	}
	public void setProcessService(IProcessService processService) {
		this.processService = processService;
	}
	public void setProcessRecordService(IProcessRecordService processRecordService) {
		this.processRecordService = processRecordService;
	}

	public List<Feedback> getFeedbackList() {
		return feedbackList;
	}

	public void setFeedbackList(List<Feedback> feedbackList) {
		this.feedbackList = feedbackList;
	}

	public List<Appraise> getAppList() {
		return appList;
	}

	public void setAppList(List<Appraise> appList) {
		this.appList = appList;
	}

	public Notified getNotified() {
		return notified;
	}

	public void setNotified(Notified notified) {
		this.notified = notified;
	}

	public void setNotifiedService(INotifiedService notifiedService) {
		this.notifiedService = notifiedService;
	}

	public Deadline getDeadline() {
		return deadline;
	}

	public void setDeadline(Deadline deadline) {
		this.deadline = deadline;
	}

	public void setDeadlineService(IDeadlineService deadlineService) {
		this.deadlineService = deadlineService;
	}

	public List<User> getAddrList() {
		return addrList;
	}

	public void setAddrList(List<User> addrList) {
		this.addrList = addrList;
	}

	public List<User> getCopyList() {
		return copyList;
	}

	public void setCopyList(List<User> copyList) {
		this.copyList = copyList;
	}

	public String getAddrEmails() {
		return addrEmails;
	}

	public void setAddrEmails(String addrEmails) {
		this.addrEmails = addrEmails;
	}

	public String getCopyEmails() {
		return copyEmails;
	}

	public void setCopyEmails(String copyEmails) {
		this.copyEmails = copyEmails;
	}

}
