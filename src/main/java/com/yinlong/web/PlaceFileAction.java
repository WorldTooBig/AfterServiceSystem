package com.yinlong.web;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.yinlong.entity.Feedback;
import com.yinlong.entity.PlaceFile;
import com.yinlong.entity.Process;
import com.yinlong.service.IFeedbackService;
import com.yinlong.service.IPlaceFileService;
import com.yinlong.util.AddProcessRecordUtil;

@Controller("placeFileAction")
@Scope("prototype")
public class PlaceFileAction {

	@Resource(name = "placeFileService")
	private IPlaceFileService placeFileService;
	
	@Resource(name = "feedbackService")
	private IFeedbackService feedbackService;
	
	private PlaceFile placeFile;
	private Feedback feedback;
	private Process process;
	
	/**
	 * 保存并关闭异常归档（即可以开始下一步）
	 * @return
	 */
	public String doAddPlaceFile() {
		feedback = feedbackService.findFeedbackById(feedback);	// 获得完整的feedback
		placeFile.setFeedback(feedback);						// 将feedback与placeFile绑定
		if (placeFileService.addPlaceFile(placeFile)) {
			AddProcessRecordUtil.addProcessRecord(feedback, feedback.getProcess(), "保存并关闭异常归档成功");
			feedback.setProcess(process);						// 修改下一流程节点
			feedbackService.addOrUpdateFeedback(feedback);		// 保存修改的流程节点
		}
		return "doAddPlaceFile";
	}
	
	/**
	 * 保存异常归档（即只能编辑不可以进行下一步）
	 * @return
	 */
	public String doNoAddPlaceFile() {
		feedback = feedbackService.findFeedbackById(feedback);	// 取出完整的feedback
		placeFile.setFeedback(feedback);						// 将feedback与placeFile绑定
		if (placeFileService.addPlaceFile(placeFile)) {
			AddProcessRecordUtil.addProcessRecord(feedback, feedback.getProcess(), "保存异常归档成功");
		}
		return "";
	}
	
	/**
	 * 去到添加归档操作
	 * @return
	 */
	public String toAddPlaceFile() {
		
		return "";
	}

	
	public PlaceFile getPlaceFile() {
		return placeFile;
	}

	public void setPlaceFile(PlaceFile placeFile) {
		this.placeFile = placeFile;
	}

	public void setPlaceFileService(IPlaceFileService placeFileService) {
		this.placeFileService = placeFileService;
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
}
