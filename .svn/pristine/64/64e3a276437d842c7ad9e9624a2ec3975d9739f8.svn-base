package com.yinlong.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 角色
 * @author 01270059
 *
 */
@Entity
@Table(name = "YL_ROLE")
@SuppressWarnings("serial")
public class Role implements Serializable {

	private int roleId;			// ID
	private String roleName;	// 角色名
	private String rolePemark;	// 备注
	
	public Role() {
		super();
	}

	public Role(int roleId, String roleName, String rolePemark) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.rolePemark = rolePemark;
	}

	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_ROLE")   
    @SequenceGenerator(name="SEQ_ROLE", sequenceName="SEQ_ROLE",allocationSize = 1)  
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRolePemark() {
		return rolePemark;
	}
	public void setRolePemark(String rolePemark) {
		this.rolePemark = rolePemark;
	}
}
