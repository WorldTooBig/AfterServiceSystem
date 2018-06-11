package com.yinlong.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 考核通报填写
 * @author KA
 *
 */
@SuppressWarnings("serial")
public class Notified implements Serializable {
	
	private int		notId;				// 
	private int 	notIsSafeAfter;		// 是否引发售后
	private String 	notCauseAnalysis;	// 初步原因分析
	private Date	notEndDate;			// 限期整改日期
	private Date	notHandleDate;		// 处理时间(默认当前)
	
	private List<Appraise> appList;		// 对责任单位的考核情况
	
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
	public List<Appraise> getAppList() {
		return appList;
	}
	public void setAppList(List<Appraise> appList) {
		this.appList = appList;
	}
	public PlaceFile getPlaceFile() {
		return placeFile;
	}
	public void setPlaceFile(PlaceFile placeFile) {
		this.placeFile = placeFile;
	}
}
