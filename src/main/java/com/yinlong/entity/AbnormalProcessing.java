package com.yinlong.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 涉及异常品处理类
 * a) 园区
 * b) 数量
 * c) 处理方案
 * d) 方案下发方式
 * @author 01270059
//	private	//涉及异常品处理 a各地库存 b数量 c处理方案 d方案下发方式      另起一表
 *
 */
@Entity
@Table(name = "YL_AbnormalProcessing")
@SuppressWarnings("serial")
public class AbnormalProcessing implements Serializable {

	private int 	ampId;
	private String	ampAdd;			// 有库存地点
	private int		ampNum;			// 库存数量
	private String	ampMethod;		// 处理方案
	private String	ampDownWay;		// 方案下发方式
	

	public AbnormalProcessing() {
		super();
	}

	public AbnormalProcessing(int ampId, String ampAdd, int ampNum, String ampMethod, String ampDownWay) {
		super();
		this.ampId = ampId;
		this.ampAdd = ampAdd;
		this.ampNum = ampNum;
		this.ampMethod = ampMethod;
		this.ampDownWay = ampDownWay;
	}

	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_AbnormalProcessing")   
    @SequenceGenerator(name="SEQ_AbnormalProcessing", sequenceName="SEQ_AbnormalProcessing",allocationSize = 1) 
	public int getAmpId() {
		return ampId;
	}

	public void setAmpId(int ampId) {
		this.ampId = ampId;
	}

	public String getAmpAdd() {
		return ampAdd;
	}

	public void setAmpAdd(String ampAdd) {
		this.ampAdd = ampAdd;
	}

	public int getAmpNum() {
		return ampNum;
	}

	public void setAmpNum(int ampNum) {
		this.ampNum = ampNum;
	}

	public String getAmpMethod() {
		return ampMethod;
	}

	public void setAmpMethod(String ampMethod) {
		this.ampMethod = ampMethod;
	}

	public String getAmpDownWay() {
		return ampDownWay;
	}

	public void setAmpDownWay(String ampDownWay) {
		this.ampDownWay = ampDownWay;
	}
	
	
	
}
