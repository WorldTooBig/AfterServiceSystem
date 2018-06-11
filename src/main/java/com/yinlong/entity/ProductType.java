package com.yinlong.entity;

import java.io.Serializable;

/**
 * 产品类别表
 * @author 01270059
 *
 */
@SuppressWarnings("serial")
public class ProductType implements Serializable {
	
	private int		pdtId;		// 
	private String	pdtName;	// 产品类名
	
	public ProductType() {
		super();
	}

	public ProductType(int pdtId, String pdtName) {
		super();
		this.pdtId = pdtId;
		this.pdtName = pdtName;
	}

	public int getPdtId() {
		return pdtId;
	}

	public void setPdtId(int pdtId) {
		this.pdtId = pdtId;
	}

	public String getPdtName() {
		return pdtName;
	}

	public void setPdtName(String pdtName) {
		this.pdtName = pdtName;
	}
	
	
	
	
}
