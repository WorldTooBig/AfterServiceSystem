package com.yinlong.service;

import java.util.List;

import com.yinlong.entity.Role;

public interface IRoleService {

	/**
	 * 添加角色
	 * @param role
	 * @return
	 */
	public boolean addRole(Role role);
	
	/**
	 * 查询所有角色
	 * @return
	 */
	public List<Role> findRoleList();
	
	/**
	 * 查询所有角色及其拥有的权限
	 * @return
	 */
	public List findRoleAndPermission();

	/**
	 * 根据传入的Role的id查询该Role所拥有的权限
	 * @param role
	 * @return
	 */
	public List findRoleAndPermissionByRoleId(Role role);

	/**
	 * 根据传入的Role的rname查询该Role所拥有的权限
	 * @param role
	 * @return
	 */
	public List findRoleAndPermissionByRoleName(Role role);
	
}
