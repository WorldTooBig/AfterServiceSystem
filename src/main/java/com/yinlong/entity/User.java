package com.yinlong.entity;

import java.io.Serializable;

import javax.persistence.*;

/**
 * 用户（员工）
 * @author 01270059
 *
 */
@Entity
@Table(name = "YL_USER")
@SuppressWarnings("serial")
public class User implements Serializable {

	private int userId;			// ID
	private String userName;	// 用户名（登录名）
	private String userPwd;		// 密码
	private String userRealName;// 真实姓名
	private String userJobNum;	// 工号
	private String userJobName; // 工种（职务）
	private String userTell;	// 电话
	private String userEmail;	// 邮箱
	private String userRemark;	// 备注
	
	private Section section;	// 科室
	
	public User() {
		super();
	}
	
	public User(int userId, String userName, String userPwd, String userRealName, String userJobNum, String userJobName,
			String userTell, String userEmail, String userRemark) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userRealName = userRealName;
		this.userJobNum = userJobNum;
		this.userJobName = userJobName;
		this.userTell = userTell;
		this.userEmail = userEmail;
		this.userRemark = userRemark;
	}

	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_USER")   
    @SequenceGenerator(name="SEQ_USER", sequenceName="SEQ_USER",allocationSize = 1)  
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserRealName() {
		return userRealName;
	}
	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}
	public String getUserJobNum() {
		return userJobNum;
	}
	public void setUserJobNum(String userJobNum) {
		this.userJobNum = userJobNum;
	}
	public String getUserJobName() {
		return userJobName;
	}
	public void setUserJobName(String userJobName) {
		this.userJobName = userJobName;
	}
	public String getUserTell() {
		return userTell;
	}
	public void setUserTell(String userTell) {
		this.userTell = userTell;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserRemark() {
		return userRemark;
	}
	public void setUserRemark(String userRemark) {
		this.userRemark = userRemark;
	}

	
	@ManyToOne(cascade=CascadeType.MERGE,fetch=FetchType.EAGER)
	@JoinColumn(name="sectId")
	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}
	
	
}
