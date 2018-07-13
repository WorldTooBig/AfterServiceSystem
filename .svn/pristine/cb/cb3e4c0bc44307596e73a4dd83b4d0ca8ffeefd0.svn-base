package com.yinlong.web;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.yinlong.entity.Appraise;
import com.yinlong.entity.Deadline;
import com.yinlong.entity.Feedback;
import com.yinlong.entity.PlaceFile;
import com.yinlong.entity.Process;
import com.yinlong.entity.ProcessRecord;
import com.yinlong.entity.Reply;
import com.yinlong.service.IDeadlineService;
import com.yinlong.service.IPlaceFileService;
import com.yinlong.service.IProcessRecordService;
import com.yinlong.service.IReplyService;
import com.yinlong.util.AddProcessRecordUtil;
import com.yinlong.util.LayuiTableData;
import com.yinlong.util.NextProcess;

@Controller("deadlineAction")
@Scope("prototype")
public class DeadlineAction {
	
	@Resource(name = "deadlineService")
	private IDeadlineService deadlineService;
	@Resource(name = "placeFileService")
	private IPlaceFileService placeFileService;
	@Resource(name = "processRecordService")
	private IProcessRecordService processRecordService;
	@Resource(name = "replyService")
	private IReplyService replyService;
	
	private Deadline deadline;
	private Feedback feedback;
	private PlaceFile placeFile;
	private Process process;
	private Reply reply;
	
	private List<Deadline> deadlineList;
	private List<Appraise> appraiseList;
	private List<ProcessRecord> prList;
	
	private int opinion;		// 同意 or 驳回
	
	/**
	 * 添加
	 * @return
	 */
	public String addDeadline() {
		placeFile = placeFileService.findPlaceFileById(placeFile);				// 查询PlaceFile
		appraiseList.removeAll(Collections.singleton(null));					// 删除空值
		placeFile.getFeedback().setAppSet(new HashSet<Appraise>(appraiseList));	// 将获取的责任单位赋予反馈单
		deadline.setPlaceFile(placeFile);										// 绑定限期单和反馈单
		deadlineService.addDeadline(deadline);
		feedback = placeFile.getFeedback();
		AddProcessRecordUtil.addProcessRecord(feedback, feedback.getProcess(), "限期整改单成功");
		NextProcess.nextProcess(feedback, process);								// 修改下一流程节点
		return "addDeadline";
	}

	/**
	 * 科室主任审核考核通报
	 * @return
	 */
	public String examine1() {
		feedback = placeFileService.findPlaceFileById(placeFile).getFeedback();	
		if (opinion == 1) {
			AddProcessRecordUtil.addProcessRecord(feedback, feedback.getProcess(), "科室主任审核成功");	// 保存此次操作
		} else {
			AddProcessRecordUtil.addProcessRecord(feedback, feedback.getProcess(), "科室主任审核驳回");	// 保存此次操作
		}
		NextProcess.nextProcess(feedback, process);													// 改变流程节点
		return "examine";
	}
	
	/**
	 * 部门领导审批考核通报
	 * 审批同意后为每一个责任单位创建一个答复单 
	 * @return
	 */
	public String examine2() {
		deadline = deadlineService.findDeadlineById(deadline);
		feedback = deadline.getPlaceFile().getFeedback();	
		if (opinion == 1) {
			AddProcessRecordUtil.addProcessRecord(feedback, feedback.getProcess(), "部门领导审批成功");	// 保存此次操作
		} else {
			AddProcessRecordUtil.addProcessRecord(feedback, feedback.getProcess(), "部门领导审批驳回");	// 保存此次操作
		}
		NextProcess.nextProcess(feedback, process);		
		//为每一个责任单位创建一个答复单
		for (Appraise appraise : feedback.getAppSet()) {
			reply = new Reply();
			reply.setDepartment(appraise.getDepartment());
			reply.setDeadline(deadline);
			replyService.addReply(reply);
		}
		return "examine";
	}
	
	/**
	 * 根据ID查询Deadline
	 * @return
	 */
	public String findDeadlineById() {
		deadline = deadlineService.findDeadlineById(deadline);              
		prList = processRecordService.findProcessRecordByFeedbackId(deadline.getPlaceFile().getFeedback());
		for (ProcessRecord processRecord : prList) {
			switch (processRecord.getProcess().getProId()) {
			case 1:	// 异常反馈单
				ActionContext.getContext().put("feePr", processRecord);
				break;
			case 2:	// 归档处理
				ActionContext.getContext().put("plaPr", processRecord);
				break;
			case 5:	// 考核通报
				ActionContext.getContext().put("deaPr", processRecord);
				break;
			case 6: // 科室主任审核
				ActionContext.getContext().put("ExaPr", processRecord);
				break;

			default:
				break;
			}
		}
		return "findDeadlineById";
	}

	/**
	 * 审核
	 * @throws IOException
	 */
	public void findDeadlineList1() throws IOException {
		deadlineList = deadlineService.findDeadlineList(6);
		LayuiTableData.layuiTableUserList(0, null, deadlineList.size(), deadlineList);	 // layui表格url请求返回数据
	}
	
	/**
	 * 审批
	 * @throws IOException 
	 */
	public void findDeadlineList2() throws IOException {
		deadlineList = deadlineService.findDeadlineList(7);
		LayuiTableData.layuiTableUserList(0, null, deadlineList.size(), deadlineList);	 // layui表格url请求返回数据
	}

	public void findDeadlineOnConclusion() throws IOException {
		deadlineList = deadlineService.findDeadlineOnConclusion();
		LayuiTableData.layuiTableUserList(0, null, deadlineList.size(), deadlineList);	 // layui表格url请求返回数据
	}
	
	public void setDeadlineService(IDeadlineService deadlineService) {
		this.deadlineService = deadlineService;
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

	public PlaceFile getPlaceFile() {
		return placeFile;
	}

	public void setPlaceFile(PlaceFile placeFile) {
		this.placeFile = placeFile;
	}

	public Process getProcess() {
		return process;
	}

	public void setProcess(Process process) {
		this.process = process;
	}

	public List<Deadline> getDeadlineList() {
		return deadlineList;
	}

	public void setDeadlineList(List<Deadline> deadlineList) {
		this.deadlineList = deadlineList;
	}

	public List<Appraise> getAppraiseList() {
		return appraiseList;
	}

	public void setAppraiseList(List<Appraise> appraiseList) {
		this.appraiseList = appraiseList;
	}

	public void setPlaceFileService(IPlaceFileService placeFileService) {
		this.placeFileService = placeFileService;
	}

	public Reply getReply() {
		return reply;
	}

	public void setReply(Reply reply) {
		this.reply = reply;
	}

	public List<ProcessRecord> getPrList() {
		return prList;
	}

	public void setPrList(List<ProcessRecord> prList) {
		this.prList = prList;
	}

	public int getOpinion() {
		return opinion;
	}

	public void setOpinion(int opinion) {
		this.opinion = opinion;
	}

	public void setProcessRecordService(IProcessRecordService processRecordService) {
		this.processRecordService = processRecordService;
	}

	public void setReplyService(IReplyService replyService) {
		this.replyService = replyService;
	}

	
	
}
