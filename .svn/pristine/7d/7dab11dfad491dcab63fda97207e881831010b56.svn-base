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
import com.yinlong.util.AddProcessRecordUtil;

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
	 * 用户登录
	 */
	public List<Role> userLogin(User user) {
		String hql = "from User where userName = '" + user.getUserName() + "'";	// 查询工号
		List<User> list = userDao.queryUserHql(hql);
		for (User u : list) {
			if(user.getUserPwd().equals(u.getUserPwd())) {
				//获取到用户信息
				ActionContext.getContext().getSession().put("user_login", u);
				//用户名和密码匹配则查询出该用户下的所有权限
//				String sql = "select pname from ylzh_privilege where pno in (select pno from ylzh_roleprivilege where rno in (select rno from ylzh_userrole where uno = " + u.getUno() + "))";
//				return privilegeDao.queryPrivilegeSql(sql);
				//用户名和密码匹配则查询出该用户的所有角色
				String h   = "select r.roleName from UserRole ur right join ur.role r where ur.user.userId = " + u.getUserId() + ")";
				return roleDao.queryRoleHql(h);
			}
		}
		return null;
	}

	/**
	 * 添加用户
	 */
	public boolean addUser(User user) {
		return userDao.addUser(user);
	}

	public List<User> findUserList() {
		String hql = "from User";
		return userDao.queryHql(hql);
	}

	/**
	 * 查询所有用户信息
	 * @param page 第几页
	 * @param limit 多少条
	 */
	public List<User> findUserList(int page, int limit) {
		int min = (page-1) * 10;
		int max = min + limit;
		String sql = "select u.* from (select y.*,rownum rn from yl_user y where rownum <= " + max + ") u where rn > " + min + "";
		return userDao.queryUserSql(sql);
	}

	/**
	 * 查询所有用户以及它的角色
	 */
	public List findUserAndRoleList() {
		String hql = "select u.userName, r.roleName from User u left join UserRole ur on u.userId = ur.urId left ru.role r";
		return userDao.queryHql(hql);
	}

	/**
	 * 根据user查询该用户的所有角色
	 */
	public List findUserAndRoleByUserList(User user) {
		String hql = "select ur.urId, r.roleName from UserRole ur left join ur.user u left join ur.role r where u.userId = " + user.getUserId() + " order by r.roleId";
		return userDao.queryHql(hql);
	}

	/**
	 * 根据用户ID查找用户
	 */
	public User findUserById(User user) {
		return userDao.queryUserById(user);
	}

	/**
	 * 根据科室id查询该科室的员工
	 */
	public List<User> findUserBySectId(Section section) {
		String hql = "from User where section.sectId = " + section.getSectId();
		return userDao.queryUserHql(hql);
	}

	public int findUserListCount() {
		String hql = "select count(*) from User";
		return userDao.queryUserCount(hql);
	}

	@Override
	public List findUserListLike(User user, Section section, Department department, Company company) {
		String hql = "select u from User u left join u.section s left join s.department d left join d.company c where 1 = 1";
		if(user.getUserRealName() != null && !user.getUserRealName().equals(""))
			hql += " and u.userName like '%" + user.getUserRealName() + "%'";
		if(user.getUserJobNum() != null && !user.getUserJobNum().equals(""))
			hql += " and u.userJobNum like '%" + user.getUserJobNum() + "%'";
		if(user.getUserJobName() != null && !user.getUserJobName().equals(""))
			hql += " and u.userJobName like '%" + user.getUserJobName() + "%'";
		if(user.getUserTell() != null && !user.getUserTell().equals(""))
			hql += " and u.userTell like '%" + user.getUserTell() + "%'";
		if(user.getUserEmail() != null && !user.getUserEmail().equals(""))
			hql += " and u.userEmail like '%" + user.getUserEmail() + "%'";
		if(user.getUserRemark() != null && !user.getUserRemark().equals(""))
			hql += " and u.userRemark like '%" + user.getUserRemark() + "%'";
		if(company.getCompId() != 0)
			hql += " and c.compId = " + company.getCompId();
		if(department.getDeptId() != 0)
			hql += " and d.deptId = " + department.getDeptId();
		if(section.getSectId() != 0)
			hql += " and s.sectId = " + section.getSectId();
		return userDao.queryUserHql(hql);
	}
	
	

}
