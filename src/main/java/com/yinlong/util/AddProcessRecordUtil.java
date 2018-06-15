package com.yinlong.util;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.yinlong.entity.Feedback;
import com.yinlong.entity.Process;
import com.yinlong.entity.ProcessRecord;
import com.yinlong.entity.User;
import com.yinlong.service.IProcessRecordService;

@Component
public class AddProcessRecordUtil {
	
	@Resource(name = "processRecordService")
	private IProcessRecordService processRecordService;
	
	private ProcessRecord processRecord;

	private static AddProcessRecordUtil addProcessRecordUtil;
	
	@PostConstruct
	public void init() {
		addProcessRecordUtil = this;
	}
	
	public static void addProcessRecord(Feedback feedback, Process process, String result) {
		ProcessRecord processRecord = new ProcessRecord();
		User user = (User)ActionContext.getContext().getSession().get("user_login");	// 从会话中取出登录人
		processRecord.setPreDate(new Date());	
		processRecord.setPreResult(result);			
		processRecord.setFeedback(feedback);
		processRecord.setProcess(process);
		processRecord.setUser(user);
		addProcessRecordUtil.add(processRecord);
	}
	
	public boolean add(ProcessRecord processRecord) {
		return processRecordService.addProcessRecord(processRecord);
	}

	public ProcessRecord getProcessRecord() {
		return processRecord;
	}

	public void setProcessRecord(ProcessRecord processRecord) {
		this.processRecord = processRecord;
	}

	public void setProcessRecordService(IProcessRecordService processRecordService) {
		this.processRecordService = processRecordService;
	}
	

}
