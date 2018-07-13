package com.yinlong.service;

import java.util.List;

import com.yinlong.entity.Permission;
import com.yinlong.entity.Role;

public interface IPermissionService {

	/**
	 * 添加权限
	 * @param permission
	 * @return
	 */
	public boolean addPermission(Permission permission);
	
	/**
	 * 查询所有权限
	 * @return
	 */
	public List<Permission> findPermissionList();
	
	/**
	 * 根据角色id查询该角色未拥有的权限
	 * @param role
	 * @return
	 */
	public List<Permission> findPermissionNoBindingListByRole(Role role);
}
