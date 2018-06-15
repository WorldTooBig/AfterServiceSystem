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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 考核通报填写
 * @author KA
 *
 */
@Entity
@Table(name = "YL_Notified")
@SuppressWarnings("serial")
public class Notified implements Serializable {
	
	private int		notId;				// 
	private int 	notIsSafeAfter;		// 是否引发售后
	private String 	notCauseAnalysis;	// 初步原因分析
	private Date	notEndDate;			// 限期整改日期
	private Date	notHandleDate;		// 处理时间(默认当前)
	
	private PlaceFile placeFile;		// 对应的归档操作表
	
	public Notified() {
		super();
	}
	public Notified(int notId, int notIsSafeAfter, String notCauseAnalysis, Date notEndDate, Date notHandleDate) {
		super();
		this.notId = notId;
		this.notIsSafeAfter = notIsSafeAfter;
		this.notCauseAnalysis = notCauseAnalysis;
		this.notEndDate = notEndDate;
		this.notHandleDate = notHandleDate;
	}
	
	@Id
	@GeneratedValue(generator = "notified")    
	@GenericGenerator(name = "notified", strategy = "uuid")   
	public int getNotId() {
		return notId;
	}
	public void setNotId(int notId) {
		this.notId = notId;
	}
	public int getNotIsSafeAfter() {
		return notIsSafeAfter;
	}
	public void setNotIsSafeAfter(int notIsSafeAfter) {
		this.notIsSafeAfter = notIsSafeAfter;
	}
	public String getNotCauseAnalysis() {
		return notCauseAnalysis;
	}
	public void setNotCauseAnalysis(String notCauseAnalysis) {
		this.notCauseAnalysis = notCauseAnalysis;
	}
	public Date getNotEndDate() {
		return notEndDate;
	}
	public void setNotEndDate(Date notEndDate) {
		this.notEndDate = notEndDate;
	}
	public Date getNotHandleDate() {
		return notHandleDate;
	}
	public void setNotHandleDate(Date notHandleDate) {
		this.notHandleDate = notHandleDate;
	}
	@OneToOne(cascade=CascadeType.MERGE,fetch=FetchType.EAGER)
	@JoinColumn(name="plaId")
	public PlaceFile getPlaceFile() {
		return placeFile;
	}
	public void setPlaceFile(PlaceFile placeFile) {
		this.placeFile = placeFile;
	}
}
