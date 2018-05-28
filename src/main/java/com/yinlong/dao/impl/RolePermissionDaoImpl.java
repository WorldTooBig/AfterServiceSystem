package com.yinlong.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yinlong.dao.IRolePermissionDao;
import com.yinlong.entity.RolePermission;

@Repository("rolePermissionDao")
public class RolePermissionDaoImpl extends BaseDao implements IRolePermissionDao {

	public boolean addRolePermission(RolePermission rolePermission) {
		try {
			getSession().save(rolePermission);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<RolePermission> queryRolePermissionHql(String hql) {
		try {
			return getSession().createQuery(hql).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean deleteRolePermission(RolePermission rolePermission) {
		try {
			getSession().delete(rolePermission);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
