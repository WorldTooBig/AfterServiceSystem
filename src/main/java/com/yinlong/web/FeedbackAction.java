package com.yinlong.web;


import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.yinlong.entity.Appraise;
import com.yinlong.entity.Department;
import com.yinlong.entity.Feedback;
import com.yinlong.entity.Process;
import com.yinlong.entity.ProcessRecord;
import com.yinlong.service.IFeedbackService;
import com.yinlong.service.IProcessRecordService;
import com.yinlong.service.IProcessService;
import com.yinlong.util.AddProcessRecordUtil;
import com.yinlong.util.LayuiTableData;

@Controller("feedbackAction")
@Scope("prototype")
public class FeedbackAction {

	@Resource(name = "feedbackService")
	private IFeedbackService feedbackService;
	@Resource(name = "processService")
	private IProcessService processService;
	@Resource(name = "processRecordService")
	private IProcessRecordService processRecordService;
	
	private Feedback feedback;		
	private Process process;
	private ProcessRecord processRecord;
	private Appraise appraise;
	
	private String[] deptId;
	
	private List<Feedback> feedbackList;
	private List<Appraise> appList;
	
	
	/**
	 * 填写新的反馈单
	 * @return
	 */
	public String addFeedback() {
		String result = "";
		process = new Process();		// 流程节点表
		process.setProId(2);			// 设置下一操作流程节点
		process = processService.findProcessById(process);
		feedback.setProcess(process);	// 将下一个操作的流程节点保存到反馈单中
		feedback.setDocCreateDate(new Date());	// 设置创建时间
		
		feedback.setAppList(appList);
		
		//当前反馈单是否保存成功
		if(feedbackService.addOrUpdateFeedback(feedback)) {
			result = "填写成功";			// 保存成功则在操作流程中记录成功
		} else {
			result = "填写失败";			// 保存失败则在操作流程中记录失败
		}
		process.setProId(1);			// 当前操作的流程节点
//		process = processService.findProcessById(process);
		AddProcessRecordUtil.addProcessRecord(feedback, process, result);	// 保存此次操作
		return "addFeedback";
	}
	
	/**
	 * 查询所有反馈单
	 */
	public void findFeedbackList() throws IOException {
		feedbackList = feedbackService.findfeedbackList();
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
	
}
