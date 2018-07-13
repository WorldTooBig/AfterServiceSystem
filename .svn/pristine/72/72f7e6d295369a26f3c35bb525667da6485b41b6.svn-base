package com.yinlong.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.yinlong.entity.Conclusion;
import com.yinlong.entity.Deadline;
import com.yinlong.entity.Feedback;
import com.yinlong.entity.Process;
import com.yinlong.entity.ProcessRecord;
import com.yinlong.entity.Reply;
import com.yinlong.service.IConDeadlineService;
import com.yinlong.service.IDeadlineService;
import com.yinlong.service.IProcessRecordService;
import com.yinlong.service.IReplyDeadlineService;
import com.yinlong.util.AddProcessRecordUtil;
import com.yinlong.util.LayuiTableData;
import com.yinlong.util.NextProcess;
import com.yinlong.util.PrListsUtil;

@Controller("conDeadlineAction")
@Scope("prototype")
public class ConDeadlineAction {

	@Resource(name = "conDeadlineService")
	private IConDeadlineService conDeadlineService;
	@Resource(name = "replyDeadlineService")
	private IReplyDeadlineService replyDeadlineService;
	@Resource(name = "deadlineService")
	private IDeadlineService deadlineService;
	@Resource(name = "processRecordService")
	private IProcessRecordService processRecordService;
	
	private Conclusion conclusion;
	private Deadline deadline;
	private Feedback feedback;
	private Process process;
	
	private List<Conclusion> conclusionList;
	private List<ProcessRecord> prList;
	private List<Reply> replyList;
	
	private int opinion;
	
	public String addConclusion() {
		conclusion.setConHandleDate(new Date());
		conclusion.setReplyList(replyDeadlineService.findReplyByDeadline(deadline));
		conDeadlineService.addConclusion(conclusion);
		deadline = deadlineService.findDeadlineById(deadline);
		feedback = deadline.getPlaceFile().getFeedback();	
		AddProcessRecordUtil.addProcessRecord(feedback, feedback.getProcess(), "成功下考核结论");	// 保存此次操作
		NextProcess.nextProcess(feedback, process);												// 改变流程节点
		return "addConclusion";
	}
	

	/**
	 * 科室审核
	 * @return
	 */
	public String examine1() {
		feedback = deadlineService.findDeadlineById(deadline).getPlaceFile().getFeedback();
		if (opinion == 1) {
			AddProcessRecordUtil.addProcessRecord(feedback, feedback.getProcess(), "科室审核结论成功");	// 保存此次操作
		} else {
			AddProcessRecordUtil.addProcessRecord(feedback, feedback.getProcess(), "科室审核结论驳回");	// 保存此次操作
		}
		NextProcess.nextProcess(feedback, process);												// 改变流程节点
		return "examine1";
	}
	
	/**
	 * 部门审批
	 * @return
	 */
	public String examine2() {
		feedback = deadlineService.findDeadlineById(deadline).getPlaceFile().getFeedback();
		if (opinion == 1) {
			AddProcessRecordUtil.addProcessRecord(feedback, feedback.getProcess(), "部门审批结论成功");	// 保存此次操作
		} else {
			AddProcessRecordUtil.addProcessRecord(feedback, feedback.getProcess(), "部门审批结论驳回");	// 保存此次操作
		}
		NextProcess.nextProcess(feedback, process);												// 改变流程节点
		return "examine2";
	}

	/**
	 * 去到填写结论页面
	 * @return
	 */
	public String findConclusionById() {
		conclusion = conDeadlineService.findConclusionById(conclusion);
		deadline = conclusion.getReplyList().get(0).getDeadline();
		replyList = conclusion.getReplyList();
		prList = processRecordService.findProcessRecordByFeedbackId(deadline.getPlaceFile().getFeedback());
		PrListsUtil.findPrListOnConclusion(prList);
		return "findConclusionById";
	}

	/**
	 * 去到审核审批结论页面
	 * @return
	 */
	public String findConDeadlineById() {
		deadline = deadlineService.findDeadlineById(deadline);
		replyList = replyDeadlineService.findReplyByDeadline(deadline);
		prList = processRecordService.findProcessRecordByFeedbackId(deadline.getPlaceFile().getFeedback());
		PrListsUtil.findPrListOnConclusion(prList);
		return "findConDeadlineById";
	}
	
	
	/**
	 * 待审核
	 * @throws IOException
	 */
	public void findConclusion1() throws IOException {
		conclusionList = conDeadlineService.findConclusionList(10);
		// ↓ 删除conclusion相同而所属reply不同的
		int conId = 0;
		Iterator<Conclusion> it = conclusionList.iterator();
		while(it.hasNext()) {
			int temp  = it.next().getConId();
			if(temp == conId) {
				it.remove();
			}
			conId = temp;
		}
		if (conclusionList == null) {
			LayuiTableData.layuiTableUserList(0, null, 0, null);	
		} else {	 
			LayuiTableData.layuiTableUserList(0, null, conclusionList.size(), conclusionList);		 // layui表格url请求返回数据
		}
	}
	
	/**
	 * 待审批
	 * @throws IOException
	 */
	public void findConclusion2() throws IOException {
		conclusionList = conDeadlineService.findConclusionList(11);
		// ↓ 删除conclusion相同而所属reply不同的
		int conId = 0;
		Iterator<Conclusion> it = conclusionList.iterator();
		while(it.hasNext()) {
			int temp  = it.next().getConId();
			if(temp == conId) {
				it.remove();
			}
			conId = temp;
		}
		if (conclusionList == null) {
			LayuiTableData.layuiTableUserList(0, null, 0, null);	
		} else {	 
			LayuiTableData.layuiTableUserList(0, null, conclusionList.size(), conclusionList);		 // layui表格url请求返回数据
		}
	}
	
	
	
	
	
	public Conclusion getConclusion() {
		return conclusion;
	}


	public void setConclusion(Conclusion conclusion) {
		this.conclusion = conclusion;
	}


	public void setConDeadlineService(IConDeadlineService conDeadlineService) {
		this.conDeadlineService = conDeadlineService;
	}


	public Deadline getDeadline() {
		return deadline;
	}


	public void setDeadline(Deadline deadline) {
		this.deadline = deadline;
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


	public List<Conclusion> getConclusionList() {
		return conclusionList;
	}


	public void setConclusionList(List<Conclusion> conclusionList) {
		this.conclusionList = conclusionList;
	}


	public void setReplyDeadlineService(IReplyDeadlineService replyDeadlineService) {
		this.replyDeadlineService = replyDeadlineService;
	}


	public void setDeadlineService(IDeadlineService deadlineService) {
		this.deadlineService = deadlineService;
	}

	public List<ProcessRecord> getPrList() {
		return prList;
	}

	public void setPrList(List<ProcessRecord> prList) {
		this.prList = prList;
	}

	public List<Reply> getReplyList() {
		return replyList;
	}

	public void setReplyList(List<Reply> replyList) {
		this.replyList = replyList;
	}

	public void setProcessRecordService(IProcessRecordService processRecordService) {
		this.processRecordService = processRecordService;
	}


	public int getOpinion() {
		return opinion;
	}


	public void setOpinion(int opinion) {
		this.opinion = opinion;
	}
	
	
}
