package com.yinlong.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;
import com.yinlong.dao.*;
import com.yinlong.entity.*;
import com.yinlong.service.IUserService;

@Service("userService")
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements IUserService {

	@Resource(name = "userDao")
	private IUserDao userDao;
	@Resource(name = "roleDao")
	private IRoleDao roleDao;
	
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	public void setRoleDao(IRoleDao roleDao) {
		this.roleDao = roleDao;
	}

	/**
	 * �û���¼
	 */
	public List<Role> userLogin(User user) {
		String hql = "from User where userName = '" + user.getUserName() + "'";	// ��ѯ����
		List<User> list = userDao.queryUserHql(hql);
		for (User u : list) {
			if(user.getUserPwd().equals(u.getUserPwd())) {
				//��ȡ���û���Ϣ
				ActionContext.getContext().getSession().put("user_login", u);
				//�û���������ƥ�����ѯ�����û��µ�����Ȩ��
//				String sql = "select pname from ylzh_privilege where pno in (select pno from ylzh_roleprivilege where rno in (select rno from ylzh_userrole where uno = " + u.getUno() + "))";
//				return privilegeDao.queryPrivilegeSql(sql);
				//�û���������ƥ�����ѯ�����û������н�ɫ
				String h   = "select r.roleName from UserRole ur right join ur.role r where ur.user.userId = " + u.getUserId() + ")";
				return roleDao.queryRoleHql(h);
			}
		}
		return null;
	}

	/**
	 * ����û�
	 */
	public boolean addUser(User user) {
		return userDao.addUser(user);
	}

	public List<User> findUserList() {
		String hql = "from User";
		return userDao.queryHql(hql);
	}

	/**
	 * ��ѯ�����û���Ϣ
	 * @param page �ڼ�ҳ
	 * @param limit ������
	 */
	public List<User> findUserList(int page, int limit) {
		int min = (page-1) * 10;
		int max = min + limit;
		String sql = "select u.* from (select y.*,rownum rn from yl_user y where rownum <= " + max + ") u where rn > " + min + "";
		return userDao.queryUserSql(sql);
	}

	/**
	 * ��ѯ�����û��Լ����Ľ�ɫ
	 */
	public List findUserAndRoleList() {
		String hql = "select u.userName, r.roleName from User u left join UserRole ur on u.userId = ur.urId left ru.role r";
		return userDao.queryHql(hql);
	}

	/**
	 * ����user��ѯ���û������н�ɫ
	 */
	public List findUserAndRoleByUserList(User user) {
		String hql = "select ur.urId, r.roleName from UserRole ur left join ur.user u left join ur.role r where u.userId = " + user.getUserId() + " order by r.roleId";
		return userDao.queryHql(hql);
	}

	/**
	 * �����û�ID�����û�
	 */
	public User findUserById(User user) {
		return userDao.queryUserById(user);
	}

	/**
	 * ���ݿ���id��ѯ�ÿ��ҵ�Ա��
	 */
	public List<User> findUserBySectId(Section section) {
		String hql = "from User where section.sectId = " + section.getSectId();
		return userDao.queryUserHql(hql);
	}

	public int findUserListCount() {
		String hql = "select count(*) from User";
		return userDao.queryUserCount(hql);
	}
	
	

}
