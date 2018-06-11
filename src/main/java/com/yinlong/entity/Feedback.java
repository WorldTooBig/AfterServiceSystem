package com.yinlong.entity;

import java.io.File;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 反馈单信息
 * @author KA
 *
 */
@SuppressWarnings("serial")
public class Feedback implements Serializable {

	////////////////////////////////////

	private int		docId;				// ID
	private int		docNum;				// 异常反馈单号	自动
	private Date	docCreateDate;		// 创建时间		隐藏
	private String	docTheme;			// 主题			
	private File	docFile;			// 附件
	private Date	docFindDate;		// 发现时间		自动
	private String	docFindAddr;		// 发现地点		自动
	private String	docCustName;		// 客户名称
	private String	docProMode;			// 产品型号
	private String	docOrderNum;		// 订单号
	private String	docProDep;			// 生产单位
	private String 	docProTeam;			// 生产班组
	private String	docResStation;		// 责任工序岗位
	private String	docItemType;		// 物料类型
	private String	docItemName;		// 物料名称
	private String	docItemNum;			// 物料编码
	private String	docSupName;			// 供应商名称
	private int		docIsStopLine;		// 是否停线
	private	String 	docLoss;			// 停线工时损失
	private String	docSeverityLevel;	// 不合格严重等级
	private int		docUsedCounts;		// 使用数量
	private int		docDefproCounts;	// 不良品数量
	private String	docFindDep;			// 发现异常单位
	private int		docIsBatch;			// 是否批量
	private String	docDescribe;		// 异常描述
	private String	docStatus; 			// 状态
	
	private User	user;				// 反馈人
	private ProductType productType;	// 产品类别
	private Process	process;			// 下一流程节点

	private List<Appraise> appList;		// 责任单位
	private	List<User>	andresseeList;	// 收件人
	
	
	public Feedback() {
		super();
	}
	public Feedback(int docId, int docNum, Date docCreateDate, String docTheme, File docFile, Date docFindDate,
			String docFindAddr, String docCustName, String docProMode, String docOrderNum, String docProDep,
			String docProTeam, String docResStation, String docItemType, String docItemName, String docItemNum,
			String docSupName, int docIsStopLine, String docLoss, String docSeverityLevel, int docUsedCounts,
			int docDefproCounts, String docFindDep, int docIsBatch, String docDescribe, String docStatus) {
		super();
		this.docId = docId;
		this.docNum = docNum;
		this.docCreateDate = docCreateDate;
		this.docTheme = docTheme;
		this.docFile = docFile;
		this.docFindDate = docFindDate;
		this.docFindAddr = docFindAddr;
		this.docCustName = docCustName;
		this.docProMode = docProMode;
		this.docOrderNum = docOrderNum;
		this.docProDep = docProDep;
		this.docProTeam = docProTeam;
		this.docResStation = docResStation;
		this.docItemType = docItemType;
		this.docItemName = docItemName;
		this.docItemNum = docItemNum;
		this.docSupName = docSupName;
		this.docIsStopLine = docIsStopLine;
		this.docLoss = docLoss;
		this.docSeverityLevel = docSeverityLevel;
		this.docUsedCounts = docUsedCounts;
		this.docDefproCounts = docDefproCounts;
		this.docFindDep = docFindDep;
		this.docIsBatch = docIsBatch;
		this.docDescribe = docDescribe;
		this.docStatus = docStatus;
	}
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
	public String getDocTheme() {
		return docTheme;
	}
	public void setDocTheme(String docTheme) {
		this.docTheme = docTheme;
	}
	public File getDocFile() {
		return docFile;
	}
	public void setDocFile(File docFile) {
		this.docFile = docFile;
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
	public int getDocIsStopLine() {
		return docIsStopLine;
	}
	public void setDocIsStopLine(int docIsStopLine) {
		this.docIsStopLine = docIsStopLine;
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
	public int getDocIsBatch() {
		return docIsBatch;
	}
	public void setDocIsBatch(int docIsBatch) {
		this.docIsBatch = docIsBatch;
	}
	public String getDocDescribe() {
		return docDescribe;
	}
	public void setDocDescribe(String docDescribe) {
		this.docDescribe = docDescribe;
	}
	public String getDocStatus() {
		return docStatus;
	}
	public void setDocStatus(String docStatus) {
		this.docStatus = docStatus;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public ProductType getProductType() {
		return productType;
	}
	public void setProductType(ProductType productType) {
		this.productType = productType;
	}
	public Process getProcess() {
		return process;
	}
	public void setProcess(Process process) {
		this.process = process;
	}
	public List<Appraise> getAppList() {
		return appList;
	}
	public void setAppList(List<Appraise> appList) {
		this.appList = appList;
	}
	public List<User> getAndresseeList() {
		return andresseeList;
	}
	public void setAndresseeList(List<User> andresseeList) {
		this.andresseeList = andresseeList;
	}

	
}
