package com.yinlong.entity;

import java.io.Serializable;

/**
 * 归档处理填写
 * @author KA
 *
 */
@SuppressWarnings("serial")
public class PlaceFile implements Serializable {

	private int 	plaId;
//	private String	 			 		// 问题类别，单独一个表，后续添加
	private String	plaBigCategory;		// 问题大类                                  
	private int		plaTrialControl;	// 是否试制把关
	private int		plaStopLine;		// 是否停线
//	private 							// 责任单位
	private int 	plaSafeAfterRisk;	// 是否有引发售后投诉的隐患
	private String	plaAbnormalType;	// 缺陷类别
	private int		plaFirstLose; 		// 是否首检失效
	private int 	plaMouthLoopCount;	// 是否重复一个月发生,第几次发生
	private String	plaCauseAnalysis;	// 根本原因分析
//	private //原因大类and 原因小类    2个都单独做表 给特殊权限的增删改查
	private int		plaInvolveHandle;	// 是否涉及厂内或外仓产品处理
	private String 	plaEmergencyPlan;	// 应急解决方案
//	private	//涉及异常品处理 a各地库存 b数量 c处理方案 d方案下发方式      另起一表
//	01
	
}
