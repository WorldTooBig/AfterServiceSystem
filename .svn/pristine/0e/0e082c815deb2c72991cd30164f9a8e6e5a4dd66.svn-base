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
 * 用户角色中间表
 * @author 01270059
 *
 */
@Entity
@Table(name = "YL_USER_ROLE")
@SuppressWarnings("serial")
public class UserRole implements Serializable {
	
	private int urId;
	
	private User user;
	
	private Role role;

	public UserRole() {
		super();
	}

	public UserRole(int urId) {
		super();
		this.urId = urId;
	}

	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_USER_ROLE")   
    @SequenceGenerator(name="SEQ_USER_ROLE", sequenceName="SEQ_USER_ROLE",allocationSize = 1) 
	public int getUrId() {
		return urId;
	}
	public void setUrId(int urId) {
		this.urId = urId;
	}

	@ManyToOne(cascade=CascadeType.REFRESH,fetch=FetchType.EAGER)
	@JoinColumn(name="userId")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(cascade=CascadeType.REFRESH,fetch=FetchType.EAGER)
	@JoinColumn(name="roleId")
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	

}
