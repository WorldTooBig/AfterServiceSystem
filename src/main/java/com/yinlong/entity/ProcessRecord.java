package com.yinlong.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 流程记录表
 * 每个单据每走一次流程就在此记录一次
 * id:
 * data: 记录详细时间
 * reason: 操作原因
 * result: 记录操作结果
 * User: 操作人			即登陆人
 * Process: 对应流程表
 * Feedback: 对应单据
 * 
 * 当质量工程师填写单据保存时，对应流程表里的name为质量工程师填写单据，记录result：保存成功or保存失败
 * 质控部领导驳回时，对应流程表里的name质控部领导审批，记录：result==>驳回
 * @author KA
 *
 */
@SuppressWarnings("serial")
public class ProcessRecord implements Serializable {
	
	private int		preId;
	private Date	preDate;		// 操作时间
	private String	preResult;		// 操作结果
	private String	preRemark;		// 备注
	
	private User	user;			// 操作人，即登录人
	private Process	process;		// 对应流程
	private Feedback feedback;		// 对应单据
	
	public ProcessRecord() {
		super();
	}
	
	public ProcessRecord(int preId, Date preDate, String preResult, String preRemark) {
		super();
		this.preId = preId;
		this.preDate = preDate;
		this.preResult = preResult;
		this.preRemark = preRemark;
	}
	
	public int getPreId() {
		return preId;
	}
	public void setPreId(int preId) {
		this.preId = preId;
	}
	public Date getPreDate() {
		return preDate;
	}
	public void setPreDate(Date preDate) {
		this.preDate = preDate;
	}
	public String getPreResult() {
		return preResult;
	}
	public void setPreResult(String preResult) {
		this.preResult = preResult;
	}
	public String getPreRemark() {
		return preRemark;
	}
	public void setPreRemark(String preRemark) {
		this.preRemark = preRemark;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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
	
	
	
}
