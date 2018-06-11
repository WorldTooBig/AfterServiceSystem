package com.yinlong.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 归档处理填写
 * @author KA
 *
 */
@SuppressWarnings("serial")
public class PlaceFile implements Serializable {

	private int 	plaId;
	private String	plaBigCategory;		// 问题大类                                  
	private int		plaIsTrialControl;	// 是否试制把关
	private int 	plaIsSafeAfterRisk;	// 是否有引发售后投诉的隐患
	private String	plaAbnormalType;	// 缺陷类别
	private int		plaIsFirstCheckLose;// 是否首检失效
	private int 	plaMouthLoopCount;	// 是否重复一个月发生,第几次发生
	private String	plaCauseAnalysis;	// 根本原因分析
	private String[] plaBigReason;		// 原因大类
	private String[] plaSmallReason;	// 原因小类
	private int		plaIsInvolveHandle;	// 是否涉及厂内或外仓产品处理
	private String 	plaEmergencyPlan;	// 应急解决方案
	
	private List<ProblemType> ptList;	// 问题类别
	private List<AbnormalProcessing> apList;	// 涉及异常品处理类 列表
	private Feedback feedback;			// 反馈单
	
	public PlaceFile() {
		super();
	}
	public PlaceFile(int plaId, String plaBigCategory, int plaIsTrialControl, int plaIsSafeAfterRisk,
			String plaAbnormalType, int plaIsFirstCheckLose, int plaMouthLoopCount, String plaCauseAnalysis,
			String[] plaBigReason, String[] plaSmallReason, int plaIsInvolveHandle, String plaEmergencyPlan) {
		super();
		this.plaId = plaId;
		this.plaBigCategory = plaBigCategory;
		this.plaIsTrialControl = plaIsTrialControl;
		this.plaIsSafeAfterRisk = plaIsSafeAfterRisk;
		this.plaAbnormalType = plaAbnormalType;
		this.plaIsFirstCheckLose = plaIsFirstCheckLose;
		this.plaMouthLoopCount = plaMouthLoopCount;
		this.plaCauseAnalysis = plaCauseAnalysis;
		this.plaBigReason = plaBigReason;
		this.plaSmallReason = plaSmallReason;
		this.plaIsInvolveHandle = plaIsInvolveHandle;
		this.plaEmergencyPlan = plaEmergencyPlan;
	}
	public int getPlaId() {
		return plaId;
	}
	public void setPlaId(int plaId) {
		this.plaId = plaId;
	}
	public String getPlaBigCategory() {
		return plaBigCategory;
	}
	public void setPlaBigCategory(String plaBigCategory) {
		this.plaBigCategory = plaBigCategory;
	}
	public int getPlaIsTrialControl() {
		return plaIsTrialControl;
	}
	public void setPlaIsTrialControl(int plaIsTrialControl) {
		this.plaIsTrialControl = plaIsTrialControl;
	}
	public int getPlaIsSafeAfterRisk() {
		return plaIsSafeAfterRisk;
	}
	public void setPlaIsSafeAfterRisk(int plaIsSafeAfterRisk) {
		this.plaIsSafeAfterRisk = plaIsSafeAfterRisk;
	}
	public String getPlaAbnormalType() {
		return plaAbnormalType;
	}
	public void setPlaAbnormalType(String plaAbnormalType) {
		this.plaAbnormalType = plaAbnormalType;
	}
	public int getPlaIsFirstCheckLose() {
		return plaIsFirstCheckLose;
	}
	public void setPlaIsFirstCheckLose(int plaIsFirstCheckLose) {
		this.plaIsFirstCheckLose = plaIsFirstCheckLose;
	}
	public int getPlaMouthLoopCount() {
		return plaMouthLoopCount;
	}
	public void setPlaMouthLoopCount(int plaMouthLoopCount) {
		this.plaMouthLoopCount = plaMouthLoopCount;
	}
	public String getPlaCauseAnalysis() {
		return plaCauseAnalysis;
	}
	public void setPlaCauseAnalysis(String plaCauseAnalysis) {
		this.plaCauseAnalysis = plaCauseAnalysis;
	}
	public String[] getPlaBigReason() {
		return plaBigReason;
	}
	public void setPlaBigReason(String[] plaBigReason) {
		this.plaBigReason = plaBigReason;
	}
	public String[] getPlaSmallReason() {
		return plaSmallReason;
	}
	public void setPlaSmallReason(String[] plaSmallReason) {
		this.plaSmallReason = plaSmallReason;
	}
	public int getPlaIsInvolveHandle() {
		return plaIsInvolveHandle;
	}
	public void setPlaIsInvolveHandle(int plaIsInvolveHandle) {
		this.plaIsInvolveHandle = plaIsInvolveHandle;
	}
	public String getPlaEmergencyPlan() {
		return plaEmergencyPlan;
	}
	public void setPlaEmergencyPlan(String plaEmergencyPlan) {
		this.plaEmergencyPlan = plaEmergencyPlan;
	}
	public List<ProblemType> getPtList() {
		return ptList;
	}
	public void setPtList(List<ProblemType> ptList) {
		this.ptList = ptList;
	}
	public List<AbnormalProcessing> getApList() {
		return apList;
	}
	public void setApList(List<AbnormalProcessing> apList) {
		this.apList = apList;
	}
	public Feedback getFeedback() {
		return feedback;
	}
	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}
	
}
