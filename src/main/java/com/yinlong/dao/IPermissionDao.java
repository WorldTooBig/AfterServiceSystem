package com.yinlong.dao;

import java.util.List;

import com.yinlong.entity.Permission;


public interface IPermissionDao {
	
	/**
	 * 添加权限
	 * @param permission
	 * @return
	 */
	public boolean addPermission(Permission permission);

	/**
	 * 执行sql语句返回Permission泛型List
	 * @param sql
	 * @return
	 */
	public List<Permission> queryPermissionSql(String sql);
	
	/**
	 * 执行hql语句返回Permission泛型List
	 * @param hql
	 * @return
	 */
	public List<Permission> queryPermissionHql(String hql);
}
