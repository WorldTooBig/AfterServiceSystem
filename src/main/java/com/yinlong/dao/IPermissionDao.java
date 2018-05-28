package com.yinlong.dao;

import java.util.List;

import com.yinlong.entity.Permission;


public interface IPermissionDao {
	
	/**
	 * ���Ȩ��
	 * @param permission
	 * @return
	 */
	public boolean addPermission(Permission permission);

	/**
	 * ִ��sql��䷵��Permission����List
	 * @param sql
	 * @return
	 */
	public List<Permission> queryPermissionSql(String sql);
	
	/**
	 * ִ��hql��䷵��Permission����List
	 * @param hql
	 * @return
	 */
	public List<Permission> queryPermissionHql(String hql);
}
