package com.yinlong.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * х╗оч
 * @author 01270059
 *
 */
@Entity
@Table(name = "YL_PERMISSION")
@SuppressWarnings("serial")
public class Permission implements Serializable {
	
	private int permId;
	private String permName;
	private String permRemark;
	
	public Permission() {
		super();
	}
	
	public Permission(int permId, String permName, String permRemark) {
		super();
		this.permId = permId;
		this.permName = permName;
		this.permRemark = permRemark;
	}

	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_PERMISSION")   
    @SequenceGenerator(name="SEQ_PERMISSION", sequenceName="SEQ_PERMISSION",allocationSize = 1)  
	public int getPermId() {
		return permId;
	}
	public void setPermId(int permId) {
		this.permId = permId;
	}
	public String getPermName() {
		return permName;
	}
	public void setPermName(String permName) {
		this.permName = permName;
	}
	public String getPermRemark() {
		return permRemark;
	}
	public void setPermRemark(String permRemark) {
		this.permRemark = permRemark;
	}

	
}
