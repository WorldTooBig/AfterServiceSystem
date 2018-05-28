package com.yinlong.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yinlong.dao.IRoleDao;
import com.yinlong.entity.Role;

@Repository("roleDao")
public class RoleDaoImpl extends BaseDao implements IRoleDao {

	/**
	 * ��ӽ�ɫ
	 */
	public boolean addRole(Role role) {
		try {
			getSession().save(role);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * ִ��hql����ҷ���Role����List
	 * @return
	 */
	public List<Role> queryRoleHql(String hql) {
		try {
			return getSession().createQuery(hql).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ִ��hql����ҷ��طǷ���List
	 * @return
	 */
	public List queryHql(String hql) {
		try {
			return getSession().createQuery(hql).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Role> queryRoleSql(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

}
