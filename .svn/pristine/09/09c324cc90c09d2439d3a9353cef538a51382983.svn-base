package com.yinlong.web;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.opensymphony.xwork2.ActionContext;
import com.yinlong.entity.ExecutiveReport;
import com.yinlong.entity.Feedback;
import com.yinlong.entity.Notified;
import com.yinlong.entity.Process;
import com.yinlong.entity.ProcessRecord;
import com.yinlong.entity.Reply;
import com.yinlong.service.INotifiedService;
import com.yinlong.service.IProcessRecordService;
import com.yinlong.service.IReplyService;
import com.yinlong.util.AddProcessRecordUtil;
import com.yinlong.util.LayuiTableData;
import com.yinlong.util.NextProcess;
import com.yinlong.util.PrListsUtil;

@Controller("replyAction")
@Scope("prototype")
public class ReplyAction {
	
	@Resource(name = "replyService")
	private IReplyService replyService;
	@Resource(name = "notifiedService")
	private INotifiedService notifiedService;
	@Resource(name = "processRecordService")
	private IProcessRecordService processRecordService;
	
	private Reply reply;
	private Notified notified;
	private Process process;
	private Feedback feedback;
	
	private List<Reply> replyList;
	private List<Notified> notifiedList;
	private List<ProcessRecord> prList;
	
	private String etr;			// 前台传入的ExecutiveReport(纠正措施预防报告)的json格式字符串
	private int opinion;		// 审核或审批结果
	

	/**
	 * 添加
	 * @return
	 */
	public String addReply() {
		notified = notifiedService.findNotifiedById(notified);
		feedback = notified.getPlaceFile().getFeedback();
		System.out.println(reply.getRepId());
		reply.setNotified(notified);
		List<ExecutiveReport> erList = JSONArray.parseArray(etr, ExecutiveReport.class);
		reply.setErList(erList);
		reply.setDepartment(replyService.findReplyById(reply).getDepartment());
		reply.setRepHandleStep(1);				// 设置答复单内部节点为1：待科室主任审核
		replyService.addReply(reply);			// 修改并保存   在dao层是saveOrUpdate
		// 答复单 n个对应一个考核单   需 改变答复单内部节点（repHandleStep） 审核审批只改变内部节点而不改变反馈单节点
		AddProcessRecordUtil.addProcessRecord(feedback, feedback.getProcess(), reply.getDepartment().getDeptName() + "答复");	
		return "addReply";
	}

	/**
	 * 科室主任审核考核通报
	 * @return
	 */
	public String examine1() {
		reply = replyService.findReplyById(reply);
		feedback = reply.getNotified().getPlaceFile().getFeedback();
		if (opinion == 1) {
			AddProcessRecordUtil.addProcessRecord(feedback, process, reply.getDepartment().getDeptName() + "科室主任审核答复成功");	// 保存此次操作
		} else {
			AddProcessRecordUtil.addProcessRecord(feedback, process, reply.getDepartment().getDeptName() + "科室主任审核答复驳回");	// 保存此次操作
		}
		reply.setRepHandleStep(2);													// 设置答复单内部节点为2：待部门领导审批
		replyService.addReply(reply);												// 修改并保存   在dao层是saveOrUpdate
		return "examine1";
	}
	
	/**
	 * 部门领导审核考核通报
	 * @return
	 */
	public String examine2() {
		reply = replyService.findReplyById(reply);
		feedback = reply.getNotified().getPlaceFile().getFeedback();
		if (opinion == 1) {
			AddProcessRecordUtil.addProcessRecord(feedback, process, reply.getDepartment().getDeptName() + "部门领导审批答复成功");	// 保存此次操作
		} else {
			AddProcessRecordUtil.addProcessRecord(feedback, process, reply.getDepartment().getDeptName() + "部门领导审批答复驳回");	// 保存此次操作
		}
		reply.setRepHandleStep(3);												// 设置答复单内部节点为3：答复完毕
		replyService.addReply(reply);											// 修改并保存   在dao层是saveOrUpdate
		//查询所有该答复单所在Notified的所有节点不为3的答复单，如果数量为0，即都答复完毕，则将该notified的流程节点改为15，即进入到下考核结论流程
		if (replyService.ReplyIsHandleEnd(reply.getNotified())) {
			process.setProId(15);												// 全部答复完毕则该反馈单进入到15流程节点
			NextProcess.nextProcess(feedback, process);							// 改变流程节点
		}
		return "examine2";
	}
	
	/**
	 * 根据ID查询Reply
	 * @return
	 */
	public String findReplyById() {
		reply = replyService.findReplyById(reply);
		prList = processRecordService.findProcessRecordByFeedbackId(reply.getNotified().getPlaceFile().getFeedback());
		PrListsUtil.findPrListOnReply(prList);
		return "findReplyById";
	}
	
	/**
	 * 根据ID查询Reply 转向到填写答复页面
	 * @return
	 */
	public String findReplyByIdToReply() {
		reply = replyService.findReplyById(reply);
		prList = processRecordService.findProcessRecordByFeedbackId(reply.getNotified().getPlaceFile().getFeedback());
		PrListsUtil.findPrListOnReply(prList);
		return "findReplyByIdToReply";
	}

	/**
	 * 查询登录人所在部门的答复单  未答复
	 */
	public void findReplyOnDepartment() throws IOException {
		replyList = replyService.findReplyOnDept(0);
		LayuiTableData.layuiTableUserList(0, null, replyList.size(), replyList);	 // layui表格url请求返回数据
	}
	
	/**
	 * 查询登录人的部门的答复单  待科室审核
	 * @throws IOException
	 */
	public void findReplyOnDept1() throws IOException {
		replyList = replyService.findReplyOnDept(1);
		LayuiTableData.layuiTableUserList(0, null, replyList.size(), replyList);	 // layui表格url请求返回数据
	}
	
	/**
	 * 查询登录人的部门的答复单  待部门审批
	 * @throws IOException
	 */
	public void findReplyOnDept2() throws IOException {
		replyList = replyService.findReplyOnDept(2);
		LayuiTableData.layuiTableUserList(0, null, replyList.size(), replyList);	 // layui表格url请求返回数据
	}
	
	/**
	 * 查询所有Reply  用于layui table
	 * @throws IOException
	 */
	public void findReplyList() throws IOException {
		replyList = replyService.findReplyList();
		LayuiTableData.layuiTableUserList(0, null, replyList.size(), replyList);	 // layui表格url请求返回数据
	}
	
	/**
	 * 查询等待下结论的考核单中的所有Reply
	 * @throws IOException
	 */
	public void findReplyListOnConclusion() throws IOException {
		replyList = replyService.findReplyList();
		LayuiTableData.layuiTableUserList(0, null, replyList.size(), replyList);	 // layui表格url请求返回数据
	}
	
	
	
	public void setReplyService(IReplyService replyService) {
		this.replyService = replyService;
	}
	public Reply getReply() {
		return reply;
	}
	public void setReply(Reply reply) {
		this.reply = reply;
	}
	public Notified getNotified() {
		return notified;
	}
	public void setNotified(Notified notified) {
		this.notified = notified;
	}
	public Process getProcess() {
		return process;
	}
	public void setProcess(Process process) {
		this.process = process;
	}
	public void setNotifiedService(INotifiedService notifiedService) {
		this.notifiedService = notifiedService;
	}
	public String getEtr() {
		return etr;
	}
	public void setEtr(String etr) {
		this.etr = etr;
	}
	public Feedback getFeedback() {
		return feedback;
	}
	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}
	public void setNotifiedList(List<Notified> notifiedList) {
		this.notifiedList = notifiedList;
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
	public List<Notified> getNotifiedList() {
		return notifiedList;
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
