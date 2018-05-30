package com.yinlong.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * ฟฦสา
 * @author 01270059
 *
 */
@Entity
@Table(name = "YL_SECTION")
@SuppressWarnings("serial")
public class Section implements Serializable {

	private int sectId;
	private String sectName;
	private String sectRemark;
	
	private Department department;

	public Section() {
		super();
	}

	public Section(int sectId, String sectName, String sectRemark) {
		super();
		this.sectId = sectId;
		this.sectName = sectName;
		this.sectRemark = sectRemark;
	}

	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_SECTION")   
    @SequenceGenerator(name="SEQ_SECTION", sequenceName="SEQ_SECTION",allocationSize = 1)  
	public int getSectId() {
		return sectId;
	}

	public void setSectId(int sectId) {
		this.sectId = sectId;
	}

	public String getSectName() {
		return sectName;
	}

	public void setSectName(String sectName) {
		this.sectName = sectName;
	}

	public String getSectRemark() {
		return sectRemark;
	}

	public void setSectRemark(String sectRemark) {
		this.sectRemark = sectRemark;
	}


	@ManyToOne(cascade=CascadeType.MERGE,fetch=FetchType.EAGER)
	@JoinColumn(name="deptId")
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
}
