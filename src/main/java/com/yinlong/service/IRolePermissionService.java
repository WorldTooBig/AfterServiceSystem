package com.yinlong.service;

import java.util.List;

import com.yinlong.entity.RolePermission;

public interface IRolePermissionService {

	/**
	 * 查询所有角色权限表信息
	 * @return
	 */
	public List<RolePermission> findRolePermission();
	
	/**
	 * 根据ID删除该角色权限信息
	 * @param rolePermission
	 * @return
	 */
	public boolean deleteRolePermissionById(RolePermission rolePermission);
	
	/**
	 * 为角色绑定权限
	 * @param rolePermission
	 * @return
	 */
	public boolean addRolePermission(RolePermission rolePermission);
}
