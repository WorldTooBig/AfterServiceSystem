package com.yinlong.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yinlong.dao.IPermissionDao;
import com.yinlong.entity.Permission;
import com.yinlong.entity.Role;
import com.yinlong.service.IPermissionService;

@Service("permissionService")
@Transactional(propagation = Propagation.REQUIRED)
public class PermissionServiceImpl implements IPermissionService {

	@Resource(name = "permissionDao")
	private IPermissionDao permissionDao;

	public void setPermissionDao(IPermissionDao permissionDao) {
		this.permissionDao = permissionDao;
	}

	
	/**
	 * ���Ȩ��
	 * @param permission
	 * @return
	 */
	public boolean addPermission(Permission permission) {
		return permissionDao.addPermission(permission);
	}

	/**
	 * ��ѯ����Ȩ��
	 * @return
	 */
	public List<Permission> findPermissionList() {
		String hql = "FROM Permission";
		return permissionDao.queryPermissionHql(hql);
	}

	/**
	 * ���ݽ�ɫid��ѯ�ý�ɫδӵ�е�Ȩ��
	 * @param role
	 * @return
	 */
	public List<Permission> findPermissionNoBindingListByRole(Role role) {
		int rno = role.getRoleId();
		String hql = "select p.permId, p.permName from RolePermission rp right join rp.permission p"
				+ " where (rp.role.roleId != " + rno + " or rp.role.roleId is null) and p.permId not in(select rp.permission.permId from rp where rp.role.roleId = " + rno + ")"
				+ " group by p.permId, p.permName order by p.permId";
		return permissionDao.queryPermissionHql(hql);
	}

}
