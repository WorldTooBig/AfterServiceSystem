package com.yinlong.web;

import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.yinlong.entity.Conclusion;
import com.yinlong.entity.Feedback;
import com.yinlong.entity.Notified;
import com.yinlong.entity.Process;
import com.yinlong.entity.ProcessRecord;
import com.yinlong.entity.Reply;
import com.yinlong.service.IConclusionService;
import com.yinlong.service.INotifiedService;
import com.yinlong.service.IProcessRecordService;
import com.yinlong.service.IReplyService;
import com.yinlong.util.AddProcessRecordUtil;
import com.yinlong.util.LayuiTableData;
import com.yinlong.util.NextProcess;
import com.yinlong.util.PrListsUtil;

@Controller("conclusionAction")
@Scope("prototype")
public class ConclusionAction {

	@Resource(name = "conclusionService")
	private IConclusionService conclusionService;
	@Resource(name = "notifiedService")
	private INotifiedService notifiedService;
	@Resource(name = "processRecordService")
	private IProcessRecordService processRecordService;
	@Resource(name = "replyService")
	private IReplyService replyService;

	private Conclusion conclusion;
	private Notified notified;
	private Feedback feedback;
	private Process process;
	
	private List<Conclusion> conclusionList;
	private List<ProcessRecord> prList;
	private List<Reply> replyList;
	
	private int opinion;	// 同意 or 驳回
	
	/**
	 * 添加
	 * @return
	 */
	public String addConclusion() {
		conclusion.setConHandleDate(new Date());
		conclusion.setReplyList(replyService.findReplyByNotified(notified));
		conclusionService.addConclusion(conclusion);
		notified = notifiedService.findNotifiedById(notified);
		feedback = notified.getPlaceFile().getFeedback();	
		AddProcessRecordUtil.addProcessRecord(feedback, feedback.getProcess(), "成功下考核结论");	// 保存此次操作
		NextProcess.nextProcess(feedback, process);												// 改变流程节点
		return "addConclusion";
	}

	/**
	 * 科室审核
	 * @return
	 */
	public String examine1() {
		feedback = notifiedService.findNotifiedById(notified).getPlaceFile().getFeedback();	
		if (opinion == 1) {
			AddProcessRecordUtil.addProcessRecord(feedback, feedback.getProcess(), "科室审核成功");	// 保存此次操作
		} else {
			AddProcessRecordUtil.addProcessRecord(feedback, feedback.getProcess(), "科室审核驳回");	// 保存此次操作
		}
		NextProcess.nextProcess(feedback, process);												// 改变流程节点
		return "examine1";
	}
	
	/**
	 * 部门审批
	 * @return
	 */
	public String examine2() {
		feedback = notifiedService.findNotifiedById(notified).getPlaceFile().getFeedback();	
		if (opinion == 1) {
			AddProcessRecordUtil.addProcessRecord(feedback, feedback.getProcess(), "部门审批成功");	// 保存此次操作
		} else {
			AddProcessRecordUtil.addProcessRecord(feedback, feedback.getProcess(), "部门审批驳回");	// 保存此次操作
		}
		NextProcess.nextProcess(feedback, process);												// 改变流程节点
		return "examine2";
	}
	
	public String findConclusionById() {
		conclusion = conclusionService.findConclusionById(conclusion);
		notified = conclusion.getReplyList().get(0).getNotified();
		replyList = conclusion.getReplyList();
		Iterator<Reply> it = replyList.iterator();
		int repId = 0;
		while(it.hasNext()) {
			int temp = it.next().getRepId();
			if(temp == repId) {
				it.remove();
			}
			repId = temp;
		}
		prList = processRecordService.findProcessRecordByFeedbackId(conclusion.getReplyList().get(0).getNotified().getPlaceFile().getFeedback());
		PrListsUtil.findPrListOnConclusion(prList);
		return "findConclusionById";
	}

	/**
	 * 查询Conclusion后返回填写Conclusion页面，显示之前操作的信息
	 * @return
	 */
	public String findConclusionToConclusion() {
		notified = notifiedService.findNotifiedById(notified);
		replyList = replyService.findReplyOnConclusion(notified);
		prList = processRecordService.findProcessRecordByFeedbackId(notified.getPlaceFile().getFeedback());
		PrListsUtil.findPrListOnConclusion(prList);
		return "findConclusionToConclusion";
	}
	
	/**
	 * 查询所有Conclusion   用于layui table 数据
	 * 待科室审核
	 * @throws IOException 
	 */
	public void findConclusion1() throws IOException {
		conclusionList = conclusionService.findConclusionListOnDept(10);
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
	 * 查询所有Conclusion   用于layui table 数据
	 * 待部门领导审批
	 * @throws IOException 
	 */
	public void findConclusion2() throws IOException {
		conclusionList = conclusionService.findConclusionListOnDept(11);
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
	
	
	
	public void setConclusionService(IConclusionService conclusionService) {
		this.conclusionService = conclusionService;
	}

	public Conclusion getConclusion() {
		return conclusion;
	}

	public void setConclusion(Conclusion conclusion) {
		this.conclusion = conclusion;
	}

	public Notified getNotified() {
		return notified;
	}

	public void setNotified(Notified notified) {
		this.notified = notified;
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

	public List<ProcessRecord> getPrList() {
		return prList;
	}

	public void setPrList(List<ProcessRecord> prList) {
		this.prList = prList;
	}

	public void setNotifiedService(INotifiedService notifiedService) {
		this.notifiedService = notifiedService;
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
	public void setReplyService(IReplyService replyService) {
		this.replyService = replyService;
	}

	public List<Reply> getReplyList() {
		return replyList;
	}

	public void setReplyList(List<Reply> replyList) {
		this.replyList = replyList;
	}
}
