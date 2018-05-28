package com.yinlong.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yinlong.dao.IRoleDao;
import com.yinlong.dao.IUserRoleDao;
import com.yinlong.entity.*;
import com.yinlong.service.IUserRoleService;

@Service("userRoleService")
@Transactional(propagation = Propagation.REQUIRED)
public class UserRoleServiceImpl implements IUserRoleService {

	@Resource(name = "userRoleDao")
	private IUserRoleDao userRoleDao;
	@Resource(name = "roleDao")
	private IRoleDao roleDao;
	
	public void setUserRoleDao(IUserRoleDao userRoleDao) {
		this.userRoleDao = userRoleDao;
	}

	public void setRoleDao(IRoleDao roleDao) {
		this.roleDao = roleDao;
	}


	/**
	 * ����IDɾ�����ݣ�����û���ɫ
	 * @param userRole
	 * @return
	 */
	public boolean deleteUserRoleById(UserRole userRole) {
		return userRoleDao.deleteUserRole(userRole);
	}

	/**
	 * ��ѯ���û�û�а󶨵Ľ�ɫ
	 * @param user
	 * @return
	 */
	public List<Role> findRoleNoBindingListByUser(User user) {
		int uno = user.getUserId();
		String hql = "select r.roleId, r.roleName from UserRole ur right join ur.role r "
				+ "where (ur.role.roleId != "+ uno + " or ur.role.roleId is null) "
						+ "and r.roleId not in(select ur.role.roleId from ur where ur.user.userId = " + uno + ")"
								+ "group by r.roleId, r.roleName order by r.roleId";
		return roleDao.queryRoleHql(hql);
	}
	/**
	 * ������ݣ����û���ɫ
	 * @param userRole
	 * @return
	 */
	public boolean addUserRole(UserRole userRole) {
		return userRoleDao.addUserRole(userRole);
	}

}
