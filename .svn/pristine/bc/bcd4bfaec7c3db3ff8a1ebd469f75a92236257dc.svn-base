package com.yinlong.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * ¹«Ë¾
 * @author 01270059
 *
 */
@Entity
@Table(name = "YL_COMPANY")
@SuppressWarnings("serial")
public class Company implements Serializable {

	private int compId;
	private String compName;
	private String compRemark;
	
	public Company() {
		super();
	}
	
	public Company(int compId, String compName, String compRemark) {
		super();
		this.compId = compId;
		this.compName = compName;
		this.compRemark = compRemark;
	}

	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_COMPANY")   
    @SequenceGenerator(name="SEQ_COMPANY", sequenceName="SEQ_COMPANY",allocationSize = 1)  
	public int getCompId() {
		return compId;
	}
	public void setCompId(int compId) {
		this.compId = compId;
	}
	public String getCompName() {
		return compName;
	}
	public void setCompName(String compName) {
		this.compName = compName;
	}
	public String getCompRemark() {
		return compRemark;
	}
	public void setCompRemark(String compRemark) {
		this.compRemark = compRemark;
	}
	
	
	
}
