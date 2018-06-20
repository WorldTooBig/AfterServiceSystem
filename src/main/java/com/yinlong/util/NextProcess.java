package com.yinlong.util;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.yinlong.entity.Feedback;
import com.yinlong.entity.Process;
import com.yinlong.service.IFeedbackService;

/**
 * 修改反馈单的流程节点
 * @author 01270059
 *
 */
@Component
public class NextProcess {
	
	private static NextProcess nextprocess;

	@Resource(name = "feedbackService")
	private IFeedbackService feedbackService;

	@PostConstruct
	public void init() {
		nextprocess = this;
	}
	
	public static void nextProcess(Feedback feedback, Process process) {
		feedback.setProcess(process);
		nextprocess.doNextProcess(feedback);
	}
	
	public void doNextProcess(Feedback feedback) {
		feedbackService.addOrUpdateFeedback(feedback);
	}

	
	
	
	public void setFeedbackService(IFeedbackService feedbackService) {
		this.feedbackService = feedbackService;
	}

	
	
}
