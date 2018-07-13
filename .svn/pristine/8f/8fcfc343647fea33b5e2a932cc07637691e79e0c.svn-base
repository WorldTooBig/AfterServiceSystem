package com.yinlong.entity;

import java.io.Serializable;

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

/**
 * 对责任单位的考核情况
 * @author 01270059
 *
 */
@Entity
@Table(name = "YL_Appraise")
@SuppressWarnings("serial")
public class Appraise implements Serializable {

	private int		appId;
	private String	appDutyName;	// 责任人
	private int		appDeduct;		// 扣分
	private int		appIsCriticism;	// 是否通报批评
	private String	appRemark;		// 备注
	
	private Department department;	// 责任单位（即部门）
	
	public Appraise() {
		super();
	}
	public Appraise(int appId, String appDutyName, int appDeduct, int appIsCriticism, String appRemark) {
		super();
		this.appId = appId;
		this.appDutyName = appDutyName;
		this.appDeduct = appDeduct;
		this.appIsCriticism = appIsCriticism;
		this.appRemark = appRemark;
	}

	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_Appraise")   
    @SequenceGenerator(name="SEQ_Appraise", sequenceName="SEQ_Appraise",allocationSize = 1) 
	public int getAppId() {
		return appId;
	}
	public void setAppId(int appId) {
		this.appId = appId;
	}
	public String getAppDutyName() {
		return appDutyName;
	}
	public void setAppDutyName(String appDutyName) {
		this.appDutyName = appDutyName;
	}
	public int getAppDeduct() {
		return appDeduct;
	}
	public void setAppDeduct(int appDeduct) {
		this.appDeduct = appDeduct;
	}
	public int getAppIsCriticism() {
		return appIsCriticism;
	}
	public void setAppIsCriticism(int appIsCriticism) {
		this.appIsCriticism = appIsCriticism;
	}
	public String getAppRemark() {
		return appRemark;
	}
	public void setAppRemark(String appRemark) {
		this.appRemark = appRemark;
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
