package com.yinlong.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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

	private String	docAddrEmail;		// 添加的收件人邮箱
	private String	docCopyEmail;		// 抄送的邮箱
	
	private PlaceFile placeFile;		// 对应的归档操作表
	
	private Set<User> addrUsers = new HashSet<User>();
	private Set<User> copyUsers = new HashSet<User>();
	
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
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_Notified")   
    @SequenceGenerator(name="SEQ_Notified", sequenceName="SEQ_Notified",allocationSize = 1) 
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
	public String getDocAddrEmail() {
		return docAddrEmail;
	}
	public void setDocAddrEmail(String docAddrEmail) {
		this.docAddrEmail = docAddrEmail;
	}
	public String getDocCopyEmail() {
		return docCopyEmail;
	}
	public void setDocCopyEmail(String docCopyEmail) {
		this.docCopyEmail = docCopyEmail;
	}

	@ManyToMany(cascade=CascadeType.REFRESH,fetch=FetchType.EAGER)
	@JoinTable(name = "YL_Notified_Addrs",
			joinColumns = {@JoinColumn(name = "not_id")},			// JoinColumns定义本方在中间表的主键映射
			inverseJoinColumns = {@JoinColumn(name = "user_id")})	// inverseJoinColumns定义另一在中间表的主键
	public Set<User> getAddrUsers() {
		return addrUsers;
	}
	public void setAddrUsers(Set<User> addrUsers) {
		this.addrUsers = addrUsers;
	}
	
	@ManyToMany(cascade=CascadeType.REFRESH,fetch=FetchType.EAGER)
	@JoinTable(name = "YL_Notified_Copys",
			joinColumns = {@JoinColumn(name = "not_id")},			// JoinColumns定义本方在中间表的主键映射
			inverseJoinColumns = {@JoinColumn(name = "user_id")})	// inverseJoinColumns定义另一在中间表的主键
	public Set<User> getCopyUsers() {
		return copyUsers;
	}
	public void setCopyUsers(Set<User> copyUsers) {
		this.copyUsers = copyUsers;
	}
}
