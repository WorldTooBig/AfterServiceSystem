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
 * 申请延期 同时用作申请关闭
 * @author 01270059
 *
 */
@Entity
@Table(name = "YL_RequestDelay")
@SuppressWarnings("serial")
public class RequestDelay implements Serializable {
	
	private int		reqId;				// 
	private Date	reqDate;			// 申请延期至日期
	private String	reqDelayExplain;	// 申请延期/关闭说明
	private int		reqIsAgree;			// 是否同意申请
	private String	reqOpinionNotes;	// 意见说明 
	
	private Reply reply;

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

	public int getReqIsAgree() {
		return reqIsAgree;
	}

	public void setReqIsAgree(int reqIsAgree) {
		this.reqIsAgree = reqIsAgree;
	}
	
	@ManyToOne(cascade=CascadeType.REFRESH,fetch=FetchType.EAGER)
	@JoinColumn(name="repId")
	public Reply getReply() {
		return reply;
	}

	public void setReply(Reply reply) {
		this.reply = reply;
	}
	
	
}
