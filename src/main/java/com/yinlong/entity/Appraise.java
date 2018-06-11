package com.yinlong.entity;

import java.io.Serializable;

/**
 * 对责任单位的考核情况
 * @author 01270059
 *
 */
@SuppressWarnings("serial")
public class Appraise implements Serializable {

	private int		appId;
	private String	appDutyName;	// 责任人
	private int		appDeduct;		// 扣分
	private int		appIsCriticism;	// 是否通报批评
	private String	appRemark;		// 备注
	
	private Department department; // 责任单位（即部门）
	
//	private 对责任单位的考核情况  a责任单位名称 b责任人   c扣分   d通报批评(勾选) e备注
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
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
		
}
