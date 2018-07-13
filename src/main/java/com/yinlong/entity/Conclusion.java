package com.yinlong.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 质量工程师下结论填写
 * @author KA
 *
 */
@Entity
@Table(name = "YL_Conclusion")
@SuppressWarnings("serial")
public class Conclusion implements Serializable {

	private int		conId;						// 
	private String	conCorrectionMethodConfirm;	// 预防纠正措施确认
	private String	conAssessmentConclusion;	// 考核结论
	private Date	conHandleDate;				// 处理时间(默认当前)

	private String	docAddrEmail;				// 添加的收件人邮箱
	private String	docCopyEmail;				// 抄送的邮箱
	
	private List<Reply>	replyList;				// 对应的责任单位答复

	private Set<User> addrUsers = new HashSet<User>();
	private Set<User> copyUsers = new HashSet<User>();

	public Conclusion() {
		super();
	}

	public Conclusion(int conId, String conCorrectionMethodConfirm, String conAssessmentConclusion,
			Date conHandleDate) {
		super();
		this.conId = conId;
		this.conCorrectionMethodConfirm = conCorrectionMethodConfirm;
		this.conAssessmentConclusion = conAssessmentConclusion;
		this.conHandleDate = conHandleDate;
	}

	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_Conclusion")   
    @SequenceGenerator(name="SEQ_Conclusion", sequenceName="SEQ_Conclusion",allocationSize = 1) 
	public int getConId() {
		return conId;
	}

	public void setConId(int conId) {
		this.conId = conId;
	}

	public String getConCorrectionMethodConfirm() {
		return conCorrectionMethodConfirm;
	}

	public void setConCorrectionMethodConfirm(String conCorrectionMethodConfirm) {
		this.conCorrectionMethodConfirm = conCorrectionMethodConfirm;
	}

	public String getConAssessmentConclusion() {
		return conAssessmentConclusion;
	}

	public void setConAssessmentConclusion(String conAssessmentConclusion) {
		this.conAssessmentConclusion = conAssessmentConclusion;
	}

	public Date getConHandleDate() {
		return conHandleDate;
	}

	public void setConHandleDate(Date conHandleDate) {
		this.conHandleDate = conHandleDate;
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

	@OneToMany(cascade=CascadeType.MERGE,fetch=FetchType.EAGER)
	@JoinColumn(name="conId")
	public List<Reply> getReplyList() {
		return replyList;
	}

	public void setReplyList(List<Reply> replyList) {
		this.replyList = replyList;
	}



	@ManyToMany(cascade=CascadeType.REFRESH,fetch=FetchType.EAGER)
	@JoinTable(name = "YL_Conclusion_Addrs",
			joinColumns = {@JoinColumn(name = "con_id")},			// JoinColumns定义本方在中间表的主键映射
			inverseJoinColumns = {@JoinColumn(name = "user_id")})	// inverseJoinColumns定义另一在中间表的主键
	public Set<User> getAddrUsers() {
		return addrUsers;
	}
	public void setAddrUsers(Set<User> addrUsers) {
		this.addrUsers = addrUsers;
	}
	
	@ManyToMany(cascade=CascadeType.REFRESH,fetch=FetchType.EAGER)
	@JoinTable(name = "YL_Conclusion_Copys",
			joinColumns = {@JoinColumn(name = "con_id")},			// JoinColumns定义本方在中间表的主键映射
			inverseJoinColumns = {@JoinColumn(name = "user_id")})	// inverseJoinColumns定义另一在中间表的主键
	public Set<User> getCopyUsers() {
		return copyUsers;
	}
	public void setCopyUsers(Set<User> copyUsers) {
		this.copyUsers = copyUsers;
	}
	
}
