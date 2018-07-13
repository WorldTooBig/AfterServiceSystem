package com.yinlong.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 产品类别表
 * @author 01270059
 *
 */
@Entity
@Table(name = "YL_ProductType")
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

	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_ProductType")   
    @SequenceGenerator(name="SEQ_ProductType", sequenceName="SEQ_ProductType",allocationSize = 1)  
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
