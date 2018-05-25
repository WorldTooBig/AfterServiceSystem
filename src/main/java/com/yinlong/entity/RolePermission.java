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
 * 角色权限中间表
 * @author 01270059
 *
 */
@Entity
@Table(name = "YL_ROLE_PERMISSION")
@SuppressWarnings("serial")
public class RolePermission implements Serializable {
	
	private int rpId;
	
	private Role role;
	
	private Permission perm;
	
	public RolePermission() {
		super();
	}
	
	public RolePermission(int rpId) {
		super();
		this.rpId = rpId;
	}

	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_ROLE_PERMISSION")   
    @SequenceGenerator(name="SEQ_ROLE_PERMISSION", sequenceName="SEQ_ROLE_PERMISSION",allocationSize = 1) 
	public int getRpId() {
		return rpId;
	}
	public void setRpId(int rpId) {
		this.rpId = rpId;
	}

	@ManyToOne(cascade=CascadeType.REFRESH,fetch=FetchType.EAGER)
	@JoinColumn(name="roleId")
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}

	@ManyToOne(cascade=CascadeType.REFRESH,fetch=FetchType.EAGER)
	@JoinColumn(name="permId")
	public Permission getPerm() {
		return perm;
	}
	public void setPerm(Permission perm) {
		this.perm = perm;
	}
	

}
