package com.yinlong.dao;

import java.util.List;

import com.yinlong.entity.RolePermission;

public interface IRolePermissionDao {

	public boolean addRolePermission(RolePermission rolePermission);
	
	public boolean deleteRolePermission(RolePermission rolePermission);
	
	public List<RolePermission> queryRolePermissionHql(String hql);
}
