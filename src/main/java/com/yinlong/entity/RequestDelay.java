package com.yinlong.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
/**
 * 申请延期
 * @author 01270059
 *
 */
@Entity
@Table(name = "YL_RequestDelay")
@SuppressWarnings("serial")
public class RequestDelay implements Serializable {
	
	private int		reqId;			// 
	private Date	reqDate;		// 申请延期至日期
	private String	reqDelayExplain;// 申请延期说明
	private String	reqOpinionNotes;// 意见说明 
	
	private Deadline deadline;		// 对应的限期整改单

	public RequestDelay() {
		super();
	}

	public RequestDelay(int reqId, Date reqDate, String reqDelayExplain, String reqOpinionNotes) {
		super();
		this.reqId = reqId;
		this.reqDate = reqDate;
		this.reqDelayExplain = reqDelayExplain;
		this.reqOpinionNotes = reqOpinionNotes;
	}

	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_RequestDelay")   
    @SequenceGenerator(name="SEQ_RequestDelay", sequenceName="SEQ_RequestDelay",allocationSize = 1) 
	public int getReqId() {
		return reqId;
	}

	public void setReqId(int reqId) {
		this.reqId = reqId;
	}

	public Date getReqDate() {
		return reqDate;
	}

	public void setReqDate(Date reqDate) {
		this.reqDate = reqDate;
	}

	public String getReqDelayExplain() {
		return reqDelayExplain;
	}

	public void setReqDelayExplain(String reqDelayExplain) {
		this.reqDelayExplain = reqDelayExplain;
	}

	public String getReqOpinionNotes() {
		return reqOpinionNotes;
	}

	public void setReqOpinionNotes(String reqOpinionNotes) {
		this.reqOpinionNotes = reqOpinionNotes;
	}

	@ManyToOne(cascade=CascadeType.MERGE,fetch=FetchType.EAGER)
	@JoinColumn(name="deaId")
	public Deadline getDeadline() {
		return deadline;
	}

	public void setDeadline(Deadline deadline) {
		this.deadline = deadline;
	}
	
	
}
