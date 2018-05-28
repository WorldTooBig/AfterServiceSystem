package com.yinlong.dao.impl;

import java.util.List;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.ImplicitPrimaryKeyJoinColumnNameSource;
import org.hibernate.boot.spi.MetadataBuildingContext;
import org.springframework.stereotype.Repository;

import com.yinlong.dao.IPermissionDao;
import com.yinlong.entity.Permission;

@Repository("permissionDao")
public class PermissionDaoImpl extends BaseDao implements IPermissionDao {

	/**
	 * 添加权限
	 * @param permission
	 * @return
	 */
	public boolean addPermission(Permission permission) {
		try {
			getSession().save(permission);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 执行sql语句返回Permission泛型List
	 * @param sql
	 * @return
	 */
	public List<Permission> queryPermissionSql(String sql) {
		try {
			return getSession().createSQLQuery(sql).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 执行hql语句返回Permission泛型List
	 * @param hql
	 * @return
	 */
	public List<Permission> queryPermissionHql(String hql) {
		try {
			return getSession().createQuery(hql).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}



}
