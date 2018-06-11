package com.yinlong.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 责任单位答复填写
 * @author KA
 *
 */
@SuppressWarnings("serial")
public class Reply implements Serializable {
	
//	private 责任单位
//	private String	预防纠正措施落实报告    另起一表
//	private String	repProcessingPerson;	// 处理人
//	private Date	repProcessingDate;		// 处理时间
//	private String	repSectionLeader;		// 科室领导
//	private Date	repSectionDate;			// 科室领导批复时间
//	private String	repDeptLeader;			// 部门领导
//	private Date	repDeptDate;			// 部门领导批复时间
	
	private int		repId;					// 
	private String	repCauseAnalysis;		// 原因分析
	private String	repCorrectionMethod;	// 预防纠正措施
	private List<ExecutiveReport> erList;	// 预防纠正措施预防报告
	
	private Notified notified;				// 对应的考核通报单
	private Deadline deadline;				// 对应的限期整改单
	
	public Reply() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reply(int repId, String repCauseAnalysis, String repCorrectionMethod) {
		super();
		this.repId = repId;
		this.repCauseAnalysis = repCauseAnalysis;
		this.repCorrectionMethod = repCorrectionMethod;
	}
	public int getRepId() {
		return repId;
	}
	public void setRepId(int repId) {
		this.repId = repId;
	}
	public String getRepCauseAnalysis() {
		return repCauseAnalysis;
	}
	public void setRepCauseAnalysis(String repCauseAnalysis) {
		this.repCauseAnalysis = repCauseAnalysis;
	}
	public String getRepCorrectionMethod() {
		return repCorrectionMethod;
	}
	public void setRepCorrectionMethod(String repCorrectionMethod) {
		this.repCorrectionMethod = repCorrectionMethod;
	}
	public List<ExecutiveReport> getErList() {
		return erList;
	}
	public void setErList(List<ExecutiveReport> erList) {
		this.erList = erList;
	}
	public Notified getNotified() {
		return notified;
	}
	public void setNotified(Notified notified) {
		this.notified = notified;
	}
	public Deadline getDeadline() {
		return deadline;
	}
	public void setDeadline(Deadline deadline) {
		this.deadline = deadline;
	}
	
}
