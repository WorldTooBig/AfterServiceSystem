package com.yinlong.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.yinlong.entity.Feedback;
import com.yinlong.entity.Process;
import com.yinlong.entity.ProcessRecord;
import com.yinlong.entity.Reply;
import com.yinlong.entity.RequestDelay;
import com.yinlong.service.IDelayService;
import com.yinlong.service.IProcessRecordService;
import com.yinlong.service.IReplyDeadlineService;
import com.yinlong.service.IReplyService;
import com.yinlong.util.AddProcessRecordUtil;
import com.yinlong.util.LayuiTableData;
import com.yinlong.util.NextProcess;
import com.yinlong.util.PrListsUtil;

@Controller("delayAction")
@Scope("prototype")
public class DelayAction {

	@Resource(name = "delayService")
	private IDelayService delayService;
	@Resource(name = "replyService")
	private IReplyService replyService;
	@Resource(name = "processRecordService")
	private IProcessRecordService processRecordService;
	@Resource(name = "replyDeadlineService")
	private IReplyDeadlineService replyDeadlineService;
	
	private RequestDelay delay;
	private Reply reply;
	private Process process;
	private Feedback feedback;
	
	private List<RequestDelay> delayList;
	private List<Reply> replyList;
	private List<ProcessRecord> prList;
	
	private int opinion;	// 同意 or 驳回
	
	public String addDelay() {
		reply = replyService.findReplyById(reply);
		reply.setRepHandleStep(5);
		replyService.addReply(reply);
		delay.setReply(reply);
		delayService.addDelay(delay);
		AddProcessRecordUtil.addProcessRecord(reply.getDeadline().getPlaceFile().getFeedback(), process, "确认申请" + process.getProId());	
		return "addDelay";
	}

	
	public String examine1() {
		delay = delayService.findDelayById(delay);
		reply = delay.getReply();
		reply.setRepHandleStep(6);
		replyService.addReply(reply);
		feedback = reply.getDeadline().getPlaceFile().getFeedback();
		if (opinion == 1) {                                                                
			AddProcessRecordUtil.addProcessRecord(feedback, process, "质控部科室主任审核确认申请成功");	// 保存此次操作
		} else {
			AddProcessRecordUtil.addProcessRecord(feedback, process, "质控部科室主任审核确认申请驳回");	// 保存此次操作
		}
		return "examine1";
	}

	
	public String examine2() {
		delay = delayService.findDelayById(delay);
		reply = delay.getReply();
		reply.setRepHandleStep(3);
		replyService.addReply(reply);
		feedback = reply.getDeadline().getPlaceFile().getFeedback();
		if (opinion == 1) {
			AddProcessRecordUtil.addProcessRecord(feedback, process, "质控部部门领导审批确认申请成功");	// 保存此次操作
		} else {
			AddProcessRecordUtil.addProcessRecord(feedback, process, "质控部部门领导审批确认申请驳回");	// 保存此次操作
		}				
		//查询所有该答复单所在deadline的所有节点不为3的答复单，如果数量为0，即都答复完毕，则将该deadline的流程节点改为15，即进入到下考核结论流程
		if (replyDeadlineService.ReplyIsHandleEnd(reply.getDeadline())) {
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
		delay = delayService.findDelayById(delay);
		reply = delay.getReply();
		prList = processRecordService.findProcessRecordByFeedbackId(reply.getDeadline().getPlaceFile().getFeedback());
		PrListsUtil.findPrListOnDelay(prList, reply);
		return "findReplyById";
	}

	/**
	 * 
	 * @return
	 */
	public String findReplyByIdOnDelay() {
		reply = replyDeadlineService.findReplyById(reply);
		prList = processRecordService.findProcessRecordByFeedbackId(reply.getDeadline().getPlaceFile().getFeedback());
		PrListsUtil.findPrListOnDelay(prList, reply);
		return "findReplyByIdOnDelay";
	}

	public void findDelayList1() throws IOException {
		delayList = delayService.findDelayList(5);
		LayuiTableData.layuiTableUserList(0, null, delayList.size(), delayList);	 // layui表格url请求返回数据
	}

	public void findDelayList2() throws IOException {
		delayList = delayService.findDelayList(6);
		LayuiTableData.layuiTableUserList(0, null, delayList.size(), delayList);	 // layui表格url请求返回数据
	}
	
	
	
	public RequestDelay getDelay() {
		return delay;
	}

	public void setDelay(RequestDelay delay) {
		this.delay = delay;
	}

	public Reply getReply() {
		return reply;
	}

	public void setReply(Reply reply) {
		this.reply = reply;
	}

	public Process getProcess() {
		return process;
	}

	public void setProcess(Process process) {
		this.process = process;
	}

	public Feedback getFeedback() {
		return feedback;
	}

	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}

	public List<RequestDelay> getDelayList() {
		return delayList;
	}

	public void setDelayList(List<RequestDelay> delayList) {
		this.delayList = delayList;
	}

	public List<Reply> getReplyList() {
		return replyList;
	}

	public void setReplyList(List<Reply> replyList) {
		this.replyList = replyList;
	}

	public void setDelayService(IDelayService delayService) {
		this.delayService = delayService;
	}

	public void setReplyService(IReplyService replyService) {
		this.replyService = replyService;
	}

	public List<ProcessRecord> getPrList() {
		return prList;
	}

	public void setPrList(List<ProcessRecord> prList) {
		this.prList = prList;
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


	public void setReplyDeadlineService(IReplyDeadlineService replyDeadlineService) {
		this.replyDeadlineService = replyDeadlineService;
	}
	
	
}
