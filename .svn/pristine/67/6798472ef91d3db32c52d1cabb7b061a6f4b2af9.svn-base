package com.yinlong.web;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSONArray;
import com.opensymphony.xwork2.ActionContext;
import com.yinlong.entity.Deadline;
import com.yinlong.entity.ExecutiveReport;
import com.yinlong.entity.Feedback;
import com.yinlong.entity.Process;
import com.yinlong.entity.ProcessRecord;
import com.yinlong.entity.Reply;
import com.yinlong.service.IDeadlineService;
import com.yinlong.service.IProcessRecordService;
import com.yinlong.service.IReplyDeadlineService;
import com.yinlong.service.IReplyService;
import com.yinlong.util.AddProcessRecordUtil;
import com.yinlong.util.LayuiTableData;
import com.yinlong.util.NextProcess;
import com.yinlong.util.PrListsUtil;

@Controller("replyDeadlineAction")
@Scope("prototype")
public class ReplyDeadlineAction {
	
	@Resource(name = "replyDeadlineService")
	private IReplyDeadlineService replyDeadlineService;
	@Resource(name = "deadlineService")
	private IDeadlineService deadlineService;
	@Resource(name = "replyService")
	private IReplyService replyService;
	@Resource(name = "processRecordService")
	private IProcessRecordService processRecordService;
	
	private Reply reply;
	private Deadline deadline;
	private Feedback feedback;
	private Process process;
	
	private List<Reply> replyList;
	private List<ProcessRecord> prList;
	
	private String etr;
	
	private int opinion;	// 同意 or 驳回	 	
	
	/**
	 * 添加
	 * @return
	 */
	public String addReply() {
		deadline = deadlineService.findDeadlineById(deadline);	// 查询填写的答复单所属的限期整改单
		feedback = deadline.getPlaceFile().getFeedback();		// 查询所属的反馈单
		reply.setDeadline(deadline);
		List<ExecutiveReport> erList = JSONArray.parseArray(etr, ExecutiveReport.class);
		reply.setErList(erList);
		reply.setDepartment(replyService.findReplyById(reply).getDepartment());
		reply.setRepHandleStep(1);				// 设置答复单内部节点为1：待科室主任审核
		replyService.addReply(reply);			// 修改并保存   在dao层是saveOrUpdate
		// 答复单 n个对应一个考核单   需 改变答复单内部节点（repHandleStep） 审核审批只改变内部节点而不改变反馈单节点
		AddProcessRecordUtil.addProcessRecord(feedback, process, reply.getDepartment().getDeptName() + "答复" + process.getProId());	
		return "addReply";
	}
	
	/**
	 * 根据ID查询Reply
	 * @return
	 */
	public String findReplyById() {
		reply = replyService.findReplyById(reply);
		prList = processRecordService.findProcessRecordByFeedbackId(reply.getDeadline().getPlaceFile().getFeedback());
		PrListsUtil.findPrListOnDeadline(prList);
		return "findReplyById";
	}

	

	/**
	 * 科室主任审核
	 * @return
	 */
	public String examine1() {
		reply = replyService.findReplyById(reply);
		feedback = reply.getDeadline().getPlaceFile().getFeedback();
		if (opinion == 1) {
			AddProcessRecordUtil.addProcessRecord(feedback, process, reply.getDepartment().getDeptName() + "科室主任审核答复成功");	// 保存此次操作
		} else {
			AddProcessRecordUtil.addProcessRecord(feedback, process, reply.getDepartment().getDeptName() + "科室主任审核答复驳回");	// 保存此次操作
		}
		reply.setRepHandleStep(2);												// 设置答复单内部节点为2：待部门领导审批
		replyService.addReply(reply);											// 修改并保存   在dao层是saveOrUpdate
		return "examine1";
	}
	
	/**
	 * 部门领导审批
	 * @return
	 */
	public String examine2() {
		reply = replyService.findReplyById(reply);
		feedback = reply.getDeadline().getPlaceFile().getFeedback();
		if (process.getProId() == 16 || process.getProId() == 17 || process.getProId() == 18) {	// 16:申请延期   17：申请关闭 18:指定下一责任单位   都需要责任单位重新审核审批
			reply.setRepHandleStep(4);											// 设置答复单内部节点为1:待审核
			replyService.addReply(reply);			
		} else {
			reply.setRepHandleStep(3);											// 设置答复单内部节点为3：答复完毕
			replyService.addReply(reply);										// 修改并保存   在dao层是saveOrUpdate
		}
		process.setProId(14);
		if (opinion == 1) {
			AddProcessRecordUtil.addProcessRecord(feedback, process, reply.getDepartment().getDeptName() + "部门领导审批答复成功" + process.getProId());	// 保存此次操作
		} else {
			AddProcessRecordUtil.addProcessRecord(feedback, process, reply.getDepartment().getDeptName() + "部门领导审批答复驳回" + process.getProId());	// 保存此次操作
		}
		//查询所有该答复单所在deadline的所有节点不为3的答复单，如果数量为0，即都答复完毕，则将该deadline的流程节点改为15，即进入到下考核结论流程
		if (replyDeadlineService.ReplyIsHandleEnd(reply.getDeadline())) {
			process.setProId(15);												// 全部答复完毕则该反馈单进入到15流程节点
			NextProcess.nextProcess(feedback, process);							// 改变流程节点
		}
		return "examine2";
	}

	/**
	 * 待答复
	 * @throws IOException 
	 */
	public void findReplyOnDeadline() throws IOException {
		replyList = replyDeadlineService.findReplyOnDeadline(0);
		LayuiTableData.layuiTableUserList(0, null, replyList.size(), replyList);
	}
	
	/**
	 * 待审核
	 * @throws IOException 
	 */
	public void findReplyOnDeadline1() throws IOException {
		replyList = replyDeadlineService.findReplyOnDeadline(1);
		LayuiTableData.layuiTableUserList(0, null, replyList.size(), replyList);
	}
	
	/**
	 * 待审批
	 * @throws IOException 
	 */
	public void findReplyOnDeadline2() throws IOException {
		replyList = replyDeadlineService.findReplyOnDeadline(2);
		LayuiTableData.layuiTableUserList(0, null, replyList.size(), replyList);
	}
	
	/**
	 * 查询待确认申请的答复单
	 * @throws IOException
	 */
	public void findDelayList() throws IOException {
		replyList = replyDeadlineService.findReplyOnDelay(4);
		LayuiTableData.layuiTableUserList(0, null, replyList.size(), replyList);
	}
	
	
	
	public void setReplyDeadlineService(IReplyDeadlineService replyDeadlineService) {
		this.replyDeadlineService = replyDeadlineService;
	}
	public Reply getReply() {
		return reply;
	}
	public void setReply(Reply reply) {
		this.reply = reply;
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

	public List<Reply> getReplyList() {
		return replyList;
	}

	public void setReplyList(List<Reply> replyList) {
		this.replyList = replyList;
	}

	public List<ProcessRecord> getPrList() {
		return prList;
	}

	public void setPrList(List<ProcessRecord> prList) {
		this.prList = prList;
	}

	public String getEtr() {
		return etr;
	}

	public void setEtr(String etr) {
		this.etr = etr;
	}

	public int getOpinion() {
		return opinion;
	}

	public void setOpinion(int opinion) {
		this.opinion = opinion;
	}

	public void setDeadlineService(IDeadlineService deadlineService) {
		this.deadlineService = deadlineService;
	}

	public void setReplyService(IReplyService replyService) {
		this.replyService = replyService;
	}

	public void setProcessRecordService(IProcessRecordService processRecordService) {
		this.processRecordService = processRecordService;
	}
	

}
