package com.yinlong.service;

import java.util.List;

import com.yinlong.entity.Company;
import com.yinlong.entity.Department;
import com.yinlong.entity.Role;
import com.yinlong.entity.Section;
import com.yinlong.entity.User;

public interface IUserService {

	public List<Role> userLogin(User user);
	
	public boolean addUser(User user);

	public List<User> findUserList();
	
	public List<User> findUserList(int page, int limit);
	
	public List findUserAndRoleList();
	
	public List findUserAndRoleByUserList(User user);
	
	public User findUserById(User user);
	
	public List<User> findUserBySectId(Section section);
	
	public int findUserListCount();
	
	public List<User> findUserListLike(User user, Section section, Department department, Company company);
	
}
