package com.yinlong.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 考核通报填写
 * @author KA
 *
 */
@SuppressWarnings("serial")
public class Notified implements Serializable {

//	private 问题类别		归档操作中已有数据
	private int 	notIsSafeAfter;		// 是否引发售后
	private String 	notCauseAnalysis;	// 初步原因分析
//	private 责任单位
//	private 对责任单位的考核情况  a责任单位名称 b责任人   c扣分   d通报批评（勾选）e备注
	private Date	notEndDate;			// 限期整改日期
	private Date	notHandleDate;		// 处理时间(默认当前)
	
}
