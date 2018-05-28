package com.yinlong.service;

import java.util.List;

import com.yinlong.entity.Permission;
import com.yinlong.entity.Role;

public interface IPermissionService {

	/**
	 * ���Ȩ��
	 * @param permission
	 * @return
	 */
	public boolean addPermission(Permission permission);
	
	/**
	 * ��ѯ����Ȩ��
	 * @return
	 */
	public List<Permission> findPermissionList();
	
	/**
	 * ���ݽ�ɫid��ѯ�ý�ɫδӵ�е�Ȩ��
	 * @param role
	 * @return
	 */
	public List<Permission> findPermissionNoBindingListByRole(Role role);
}
