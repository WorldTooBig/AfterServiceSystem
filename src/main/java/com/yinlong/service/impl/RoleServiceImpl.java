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
	 * 添加角色
	 * @param role
	 * @return
	 */
	public boolean addRole(Role role) {
		
		return roleDao.addRole(role);
	}

	/**
	 * 查询所有角色
	 * @return
	 */
	public List<Role> findRoleList() {
		String hql = "FROM Role order by roleId";
		return roleDao.queryRoleHql(hql);
	}

	/**
	 * 查询所有角色及其拥有的权限
	 * @return
	 */
	public List findRoleAndPermission() {
		String hql = "select r.roleName, p.permName from RolePermission rp left join rp.role r left join rp.permission p order by rp.roleId";
		return roleDao.queryHql(hql);
	}

	/**
	 * 根据传入的Role的id查询该Role所拥有的权限
	 * @param role
	 * @return
	 */
	public List findRoleAndPermissionByRoleId(Role role) {
		String hql = "select rp.rpId, p.permName from RolePermission rp left join rp.role r left join rp.permission p where r.roleId = " + role.getRoleId() + " order by r.roleId";
		return roleDao.queryHql(hql);
	}
	
	/**
	 * 根据传入的Role的rname查询该Role所拥有的权限
	 * @param role
	 * @return
	 */
	public List findRoleAndPermissionByRoleName(Role role) {
		String hql = "select rp.rpId, p.permName from RolePermission rp left join rp.role r left join rp.permission p where r.roleName = '" + role.getRoleName() + "' order by r.roleId";
		return roleDao.queryHql(hql);
	}

}
