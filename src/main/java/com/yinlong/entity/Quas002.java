package com.yinlong.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "YL_QUAS002")
@SuppressWarnings("serial")
public class Quas002 implements Serializable {

	private int		docId;				// ID
	private int		docNum;				// 单号
	private Date	docCreateDate;		// 创建时间
	private String	docAbnormalType;	// 异常类型
	private String	docTheme;			// 主题
	private Date	docFindDate;		// 发现时间
	private String	docFindAddr;		// 发现地点
	private String	docCustName;		// 客户名称
	private String	docProType;			// 产品类别
	private String	docProMode;			// 产品型号
	private String	docOrderNum;		// 订单号
	private String	docProDep;			// 生产单位
	private String 	docProTeam;			// 生产班组
	private String	docResStation;		// 责任工序岗位
	private String	docItemType;		// 物料类型
	private String	docItemName;		// 物料名称
	private String	docItemNum;			// 物料编码
	private String	docSupName;			// 供应商名称
	private int		docStat1;			// 是否停线
	private	String 	docLoss;			// 停线工时损失
	private String	docSeverityLevel;	// 不合格严重等级
	private int		docUsedCounts;		// 使用数量
	private int		docDefproCounts;	// 不良品数量
	private String	docFindDep;			// 发现异常单位
	private int		docStat2;			// 是否批量
	private String	docRespDep;			// 责任单位
	private String	docDescribe;		// 异常描述
	private String	docBacker;			// 反馈人
	private String	docReceiver;		// 收件人
	
	private User user;					// 创建人

	public Quas002() {
		super();
	}

	public Quas002(int docId, int docNum, Date docCreateDate, String docAbnormalType, String docTheme, Date docFindDate,
			String docFindAddr, String docCustName, String docProType, String docProMode, String docOrderNum,
			String docProDep, String docProTeam, String docResStation, String docItemType, String docItemName,
			String docItemNum, String docSupName, int docStat1, String docLoss, String docSeverityLevel,
			int docUsedCounts, int docDefproCounts, String docFindDep, int docStat2, String docRespDep,
			String docDescribe, String docBacker, String docReceiver) {
		super();
		this.docId = docId;
		this.docNum = docNum;
		this.docCreateDate = docCreateDate;
		this.docAbnormalType = docAbnormalType;
		this.docTheme = docTheme;
		this.docFindDate = docFindDate;
		this.docFindAddr = docFindAddr;
		this.docCustName = docCustName;
		this.docProType = docProType;
		this.docProMode = docProMode;
		this.docOrderNum = docOrderNum;
		this.docProDep = docProDep;
		this.docProTeam = docProTeam;
		this.docResStation = docResStation;
		this.docItemType = docItemType;
		this.docItemName = docItemName;
		this.docItemNum = docItemNum;
		this.docSupName = docSupName;
		this.docStat1 = docStat1;
		this.docLoss = docLoss;
		this.docSeverityLevel = docSeverityLevel;
		this.docUsedCounts = docUsedCounts;
		this.docDefproCounts = docDefproCounts;
		this.docFindDep = docFindDep;
		this.docStat2 = docStat2;
		this.docRespDep = docRespDep;
		this.docDescribe = docDescribe;
		this.docBacker = docBacker;
		this.docReceiver = docReceiver;
	}

	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_QUAS002")   
    @SequenceGenerator(name="SEQ_QUAS002", sequenceName="SEQ_QUAS002",allocationSize = 1)  
	public int getDocId() {
		return docId;
	}

	public void setDocId(int docId) {
		this.docId = docId;
	}

	public int getDocNum() {
		return docNum;
	}

	public void setDocNum(int docNum) {
		this.docNum = docNum;
	}

	public Date getDocCreateDate() {
		return docCreateDate;
	}

	public void setDocCreateDate(Date docCreateDate) {
		this.docCreateDate = docCreateDate;
	}

	public String getDocAbnormalType() {
		return docAbnormalType;
	}

	public void setDocAbnormalType(String docAbnormalType) {
		this.docAbnormalType = docAbnormalType;
	}

	public String getDocTheme() {
		return docTheme;
	}

	public void setDocTheme(String docTheme) {
		this.docTheme = docTheme;
	}

	public Date getDocFindDate() {
		return docFindDate;
	}

	public void setDocFindDate(Date docFindDate) {
		this.docFindDate = docFindDate;
	}

	public String getDocFindAddr() {
		return docFindAddr;
	}

	public void setDocFindAddr(String docFindAddr) {
		this.docFindAddr = docFindAddr;
	}

	public String getDocCustName() {
		return docCustName;
	}

	public void setDocCustName(String docCustName) {
		this.docCustName = docCustName;
	}

	public String getDocProType() {
		return docProType;
	}

	public void setDocProType(String docProType) {
		this.docProType = docProType;
	}

	public String getDocProMode() {
		return docProMode;
	}

	public void setDocProMode(String docProMode) {
		this.docProMode = docProMode;
	}

	public String getDocOrderNum() {
		return docOrderNum;
	}

	public void setDocOrderNum(String docOrderNum) {
		this.docOrderNum = docOrderNum;
	}

	public String getDocProDep() {
		return docProDep;
	}

	public void setDocProDep(String docProDep) {
		this.docProDep = docProDep;
	}

	public String getDocProTeam() {
		return docProTeam;
	}

	public void setDocProTeam(String docProTeam) {
		this.docProTeam = docProTeam;
	}

	public String getDocResStation() {
		return docResStation;
	}

	public void setDocResStation(String docResStation) {
		this.docResStation = docResStation;
	}

	public String getDocItemType() {
		return docItemType;
	}

	public void setDocItemType(String docItemType) {
		this.docItemType = docItemType;
	}

	public String getDocItemName() {
		return docItemName;
	}

	public void setDocItemName(String docItemName) {
		this.docItemName = docItemName;
	}

	public String getDocItemNum() {
		return docItemNum;
	}

	public void setDocItemNum(String docItemNum) {
		this.docItemNum = docItemNum;
	}

	public String getDocSupName() {
		return docSupName;
	}

	public void setDocSupName(String docSupName) {
		this.docSupName = docSupName;
	}

	public int getDocStat1() {
		return docStat1;
	}

	public void setDocStat1(int docStat1) {
		this.docStat1 = docStat1;
	}

	public String getDocLoss() {
		return docLoss;
	}

	public void setDocLoss(String docLoss) {
		this.docLoss = docLoss;
	}

	public String getDocSeverityLevel() {
		return docSeverityLevel;
	}

	public void setDocSeverityLevel(String docSeverityLevel) {
		this.docSeverityLevel = docSeverityLevel;
	}

	public int getDocUsedCounts() {
		return docUsedCounts;
	}

	public void setDocUsedCounts(int docUsedCounts) {
		this.docUsedCounts = docUsedCounts;
	}

	public int getDocDefproCounts() {
		return docDefproCounts;
	}

	public void setDocDefproCounts(int docDefproCounts) {
		this.docDefproCounts = docDefproCounts;
	}

	public String getDocFindDep() {
		return docFindDep;
	}

	public void setDocFindDep(String docFindDep) {
		this.docFindDep = docFindDep;
	}

	public int getDocStat2() {
		return docStat2;
	}

	public void setDocStat2(int docStat2) {
		this.docStat2 = docStat2;
	}

	public String getDocRespDep() {
		return docRespDep;
	}

	public void setDocRespDep(String docRespDep) {
		this.docRespDep = docRespDep;
	}

	public String getDocDescribe() {
		return docDescribe;
	}

	public void setDocDescribe(String docDescribe) {
		this.docDescribe = docDescribe;
	}

	public String getDocBacker() {
		return docBacker;
	}

	public void setDocBacker(String docBacker) {
		this.docBacker = docBacker;
	}

	public String getDocReceiver() {
		return docReceiver;
	}

	public void setDocReceiver(String docReceiver) {
		this.docReceiver = docReceiver;
	}

	@ManyToOne(cascade=CascadeType.MERGE,fetch=FetchType.EAGER)
	@JoinColumn(name="userId")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
