package com.yinlong.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yinlong.dao.IRoleDao;
import com.yinlong.entity.Role;
import com.yinlong.service.IRoleService;

@Service("roleService")
@Transactional(propagation = Propagation.REQUIRED)
public class RoleServiceImpl implements IRoleService {

	@Resource(name = "roleDao")
	private IRoleDao roleDao;
	
	public void setRoleDao(IRoleDao roleDao) {
		this.roleDao = roleDao;
	}


	/**
	 * ��ӽ�ɫ
	 * @param role
	 * @return
	 */
	public boolean addRole(Role role) {
		
		return roleDao.addRole(role);
	}

	/**
	 * ��ѯ���н�ɫ
	 * @return
	 */
	public List<Role> findRoleList() {
		String hql = "FROM Role order by roleId";
		return roleDao.queryRoleHql(hql);
	}

	/**
	 * ��ѯ���н�ɫ����ӵ�е�Ȩ��
	 * @return
	 */
	public List findRoleAndPermission() {
		String hql = "select r.roleName, p.permName from RolePermission rp left join rp.role r left join rp.permission p order by rp.roleId";
		return roleDao.queryHql(hql);
	}

	/**
	 * ���ݴ����Role��id��ѯ��Role��ӵ�е�Ȩ��
	 * @param role
	 * @return
	 */
	public List findRoleAndPermissionByRoleId(Role role) {
		String hql = "select rp.rpId, p.permName from RolePermission rp left join rp.role r left join rp.permission p where r.roleId = " + role.getRoleId() + " order by r.roleId";
		return roleDao.queryHql(hql);
	}
	
	/**
	 * ���ݴ����Role��rname��ѯ��Role��ӵ�е�Ȩ��
	 * @param role
	 * @return
	 */
	public List findRoleAndPermissionByRoleName(Role role) {
		String hql = "select rp.rpId, p.permName from RolePermission rp left join rp.role r left join rp.permission p where r.roleName = '" + role.getRoleName() + "' order by r.roleId";
		return roleDao.queryHql(hql);
	}

}
