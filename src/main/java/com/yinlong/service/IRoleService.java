package com.yinlong.service;

import java.util.List;

import com.yinlong.entity.Role;

public interface IRoleService {

	/**
	 * ��ӽ�ɫ
	 * @param role
	 * @return
	 */
	public boolean addRole(Role role);
	
	/**
	 * ��ѯ���н�ɫ
	 * @return
	 */
	public List<Role> findRoleList();
	
	/**
	 * ��ѯ���н�ɫ����ӵ�е�Ȩ��
	 * @return
	 */
	public List findRoleAndPermission();

	/**
	 * ���ݴ����Role��id��ѯ��Role��ӵ�е�Ȩ��
	 * @param role
	 * @return
	 */
	public List findRoleAndPermissionByRoleId(Role role);

	/**
	 * ���ݴ����Role��rname��ѯ��Role��ӵ�е�Ȩ��
	 * @param role
	 * @return
	 */
	public List findRoleAndPermissionByRoleName(Role role);
	
}
