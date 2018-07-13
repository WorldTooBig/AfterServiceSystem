package com.yinlong.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 责任单位答复 填写
 * @author KA
 * 
 */
@Entity
@Table(name = "YL_Reply")
@SuppressWarnings("serial")
public class Reply implements Serializable {
	
	private int		repId;					// 
	private String	repCauseAnalysis;		// 原因分析
	private String	repCorrectionMethod;	// 预防纠正措施
	private int		repHandleStep;			// 处理答复步骤  1：待科室主任审核 2：待部门领导审批 3:答复完成 4:待确认申请 5:确认申请待审核 6:确认申请待审批
	
	private List<ExecutiveReport> erList;	// 预防纠正措施预防报告
	private Department department;			// 责任单位部门
	
	private Notified notified;				// 对应的考核通报单
	private	Deadline deadline;				// 对应的限期整改
	
	public Reply() {
		super();
	}
	public Reply(int repId, String repCauseAnalysis, String repCorrectionMethod) {
		super();
		this.repId = repId;
		this.repCauseAnalysis = repCauseAnalysis;
		this.repCorrectionMethod = repCorrectionMethod;
	}
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_Reply")   
    @SequenceGenerator(name="SEQ_Reply", sequenceName="SEQ_Reply",allocationSize = 1) 
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
	public int getRepHandleStep() {
		return repHandleStep;
	}
	public void setRepHandleStep(int repHandleStep) {
		this.repHandleStep = repHandleStep;
	}
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="repId")
	public List<ExecutiveReport> getErList() {
		return erList;
	}
	public void setErList(List<ExecutiveReport> erList) {
		this.erList = erList;
	}
	@ManyToOne(cascade=CascadeType.MERGE ,fetch=FetchType.EAGER)
	@JoinColumn(name="notId")
	public Notified getNotified() {
		return notified;
	}
	public void setNotified(Notified notified) {
		this.notified = notified;
	}
	@ManyToOne(cascade=CascadeType.MERGE,fetch=FetchType.EAGER)
	@JoinColumn(name="deaId")
	public Deadline getDeadline() {
		return deadline;
	}
	public void setDeadline(Deadline deadline) {
		this.deadline = deadline;
	}
	@OneToOne(cascade=CascadeType.MERGE,fetch=FetchType.EAGER)
	@JoinColumn(name="deptId")
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
}
