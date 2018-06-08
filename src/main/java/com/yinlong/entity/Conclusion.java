package com.yinlong.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 质量工程师下结论填写
 * @author KA
 *
 */
@SuppressWarnings("serial")
public class Conclusion implements Serializable {

//	private 问题类别	Notified表中数据
	private String	conCorrectionMethodConfirm;	// 预防纠正措施确认
	private String	conAssessmentConclusion;	// 考核结论
//	private 责任单位	同Notified类的 责任单位考核情况
	private Date	conHandleDate;				// 处理时间(默认当前)
	
}
