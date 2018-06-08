package com.yinlong.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 反馈单信息
 * @author KA
 *
 */
@SuppressWarnings("serial")
public class Feedback implements Serializable {

	private int fbId;
	private int fbNum;	 //异常反馈单号
//	private 生产基地
	private String fbTitle;	// 主题
//	private 反馈科室
//	private 附件
	private Date fbDate;	// 发现时间
	
	////////////////////////////////////

	private int		docId;				// ID
	private int		docNum;				// 异常反馈单号	自动
	private Date	docCreateDate;		// 创建时间		隐藏
//	private String	docAbnormalType;	// 异常类型		不需要，归档里面填写
	private String	docTheme;			// 主题			
	private Date	docFindDate;		// 发现时间		自动
	private String	docFindAddr;		// 发现地点		自动
	private String	docCustName;		// 客户名称
	private String	docProType;			// 产品类别		外表
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
	private String	docBacker;			// 反馈人			默认，科数据 
	private String	docReceiver;		// 收件人
	
	private String	docStatus; 			// 状态
	private Process	docProcess;			// 流程节点		一对一
	
	
	
}
