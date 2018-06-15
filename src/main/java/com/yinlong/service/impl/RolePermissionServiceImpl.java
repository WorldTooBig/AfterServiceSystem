package com.yinlong.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yinlong.dao.IRolePermissionDao;
import com.yinlong.entity.RolePermission;
import com.yinlong.service.IRolePermissionService;

@Service("rolePermissionService")
@Transactional(propagation = Propagation.REQUIRED)
public class RolePermissionServiceImpl implements IRolePermissionService {

	@Resource(name = "rolePermissionDao")
	private IRolePermissionDao rolePermissionDao;

	public void setRolePermissionDao(IRolePermissionDao rolePermissionDao) {
		this.rolePermissionDao = rolePermissionDao;
	}

	
	/**
	 * 查询所有角色权限表信息
	 * @return
	 */
	public List<RolePermission> findRolePermission() {
		String hql = "from RolePermission";
		return rolePermissionDao.queryRolePermissionHql(hql);
	}

	/**
	 * 根据ID删除该角色权限信息
	 * @param rolePermission
	 * @return
	 */
	public boolean deleteRolePermissionById(RolePermission rolePermission) {
		return rolePermissionDao.deleteRolePermission(rolePermission);
	}

	/**
	 * 为角色绑定权限
	 * @param rolePermission
	 * @return
	 */
	public boolean addRolePermission(RolePermission rolePermission) {
		return rolePermissionDao.addRolePermission(rolePermission);
	}

}
