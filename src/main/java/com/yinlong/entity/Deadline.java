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


/**
 * 限期整改填写
 * @author KA
 *
 */
@Entity
@Table(name = "YL_Deadline")
@SuppressWarnings("serial")
public class Deadline implements Serializable {
	
	private int		deaId;				// 
	private int 	deaIsSafeAfter;		// 是否引发售后
	private String 	deaCauseAnalysis;	// 初步原因分析
	private String	deaHandlingComments;// 处理意见
	private Date	deaIssuedDate;		// 要求整改方案下发日期
	private Date	deaCompleteDate;	// 要求整改完成日期
	private Date	deaHandleDate;		// 处理时间(默认当前)

	private String	docAddrEmail;		// 添加的收件人邮箱
	private String	docCopyEmail;		// 抄送的邮箱
	
	private PlaceFile placeFile;		// 对应的归档操作表 

	private Set<User> addrUsers = new HashSet<User>();
	private Set<User> copyUsers = new HashSet<User>();

	
	public Deadline() {
		super();
	}

	public Deadline(int deaId, int deaIsSafeAfter, String deaCauseAnalysis, String deaHandlingComments,
			Date deaIssuedDate, Date deaCompleteDate, Date deaHandleDate) {
		super();
		this.deaId = deaId;
		this.deaIsSafeAfter = deaIsSafeAfter;
		this.deaCauseAnalysis = deaCauseAnalysis;
		this.deaHandlingComments = deaHandlingComments;
		this.deaIssuedDate = deaIssuedDate;
		this.deaCompleteDate = deaCompleteDate;
		this.deaHandleDate = deaHandleDate;
	}

	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_Deadline")   
    @SequenceGenerator(name="SEQ_Deadline", sequenceName="SEQ_Deadline",allocationSize = 1) 
	public int getDeaId() {
		return deaId;
	}

	public void setDeaId(int deaId) {
		this.deaId = deaId;
	}

	public int getDeaIsSafeAfter() {
		return deaIsSafeAfter;
	}

	public void setDeaIsSafeAfter(int deaIsSafeAfter) {
		this.deaIsSafeAfter = deaIsSafeAfter;
	}

	public String getDeaCauseAnalysis() {
		return deaCauseAnalysis;
	}

	public void setDeaCauseAnalysis(String deaCauseAnalysis) {
		this.deaCauseAnalysis = deaCauseAnalysis;
	}

	public String getDeaHandlingComments() {
		return deaHandlingComments;
	}

	public void setDeaHandlingComments(String deaHandlingComments) {
		this.deaHandlingComments = deaHandlingComments;
	}

	public Date getDeaIssuedDate() {
		return deaIssuedDate;
	}

	public void setDeaIssuedDate(Date deaIssuedDate) {
		this.deaIssuedDate = deaIssuedDate;
	}

	public Date getDeaCompleteDate() {
		return deaCompleteDate;
	}

	public void setDeaCompleteDate(Date deaCompleteDate) {
		this.deaCompleteDate = deaCompleteDate;
	}

	public Date getDeaHandleDate() {
		return deaHandleDate;
	}

	public void setDeaHandleDate(Date deaHandleDate) {
		this.deaHandleDate = deaHandleDate;
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

	@OneToOne(cascade=CascadeType.MERGE,fetch=FetchType.EAGER)
	@JoinColumn(name="plaId")
	public PlaceFile getPlaceFile() {
		return placeFile;
	}

	public void setPlaceFile(PlaceFile placeFile) {
		this.placeFile = placeFile;
	}

	@ManyToMany(cascade=CascadeType.REFRESH,fetch=FetchType.EAGER)
	@JoinTable(name = "YL_Deadline_Addrs",
			joinColumns = {@JoinColumn(name = "dea_id")},			// JoinColumns定义本方在中间表的主键映射
			inverseJoinColumns = {@JoinColumn(name = "user_id")})	// inverseJoinColumns定义另一在中间表的主键
	public Set<User> getAddrUsers() {
		return addrUsers;
	}
	public void setAddrUsers(Set<User> addrUsers) {
		this.addrUsers = addrUsers;
	}
	
	@ManyToMany(cascade=CascadeType.REFRESH,fetch=FetchType.EAGER)
	@JoinTable(name = "YL_Deadline_Copys",
			joinColumns = {@JoinColumn(name = "dea_id")},			// JoinColumns定义本方在中间表的主键映射
			inverseJoinColumns = {@JoinColumn(name = "user_id")})	// inverseJoinColumns定义另一在中间表的主键
	public Set<User> getCopyUsers() {
		return copyUsers;
	}
	public void setCopyUsers(Set<User> copyUsers) {
		this.copyUsers = copyUsers;
	}
	
	
}
