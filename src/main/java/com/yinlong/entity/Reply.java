package com.yinlong.entity;

import java.io.Serializable;

/**
 * 责任单位答复填写
 * @author KA
 *
 */
@SuppressWarnings("serial")
public class Reply implements Serializable {
	
//	private 责任单位
	private String	repCauseAnalysis;		// 原因分析
	private String	repCorrectionMethod;	// 预防纠正措施
//	private String	预防纠正措施落实报告    另起一表
	
}
