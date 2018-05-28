package com.yinlong.service;

import java.util.List;

import com.yinlong.entity.*;

public interface IUserRoleService {

	/**
	 * 根据ID删除数据，解绑用户角色
	 * @param userRole
	 * @return
	 */
	public boolean deleteUserRoleById(UserRole userRole);
	
	/**
	 * 查询该用户没有绑定的角色
	 * @param user
	 * @return
	 */
	public List<Role> findRoleNoBindingListByUser(User user);
	
	/**
	 * 添加数据，绑定用户角色
	 * @param userRole
	 * @return
	 */
	public boolean addUserRole(UserRole userRole);
}
