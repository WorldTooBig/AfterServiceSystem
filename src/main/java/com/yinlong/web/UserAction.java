package com.yinlong.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.yinlong.entity.*;
import com.yinlong.service.IUserService;

@Controller("userAction")
@Scope("prototype")
public class UserAction {
	
	@Resource(name = "userService")
	private IUserService userService;
	
	private User user;
	private Section section;
	
	private List list;
	private List<User> userList;
	private List<Role> roleList;
	private String errorInfo;
	
	/**
	 * �û���¼
	 * @return
	 */
	public String userLogin() {
		roleList = userService.userLogin(user);
		if(roleList != null) {
			//�ɹ����ȡ���û�ӵ�е�Ȩ��
			ActionContext.getContext().getSession().put("user_role", roleList);
			return "index";
		}
		ActionContext.getContext().getSession().put("login_lose", "�û������������");
		return "login";
	}
	
	/**
	 * ����û�
	 * @return
	 */
	public String addUser() {
		if(userService.addUser(user)) {
			errorInfo = "����û��ɹ�";
		}
		errorInfo = "����û�ʧ��";
		return "add";
	}
	
	/**
	 * ��ѯ�����û���Ϣ
	 * @return
	 */
	public String findUserList() {
		userList = userService.findUserList();
		return "findUserList";
	}
	
	/**
	 * ��ѯ�����û������Ľ�ɫ
	 * @return
	 */
	public String findUserAndRoleList() {
		list = userService.findUserAndRoleList();
		return "findUserAndRoleList";
	}
	
	/**
	 * �����û���ѯ���û��Ľ�ɫ
	 * @return
	 */
	public String findUserAndROleByUserList() {
		list = new ArrayList();
		userList = userService.findUserList();
		for (User user : userList) {
			List l = new ArrayList();
			l.add(user);
			l.add(userService.findUserAndRoleByUserList(user));
			list.add(l);
		}
		return "findUserAndROleByUserList";
	}
	
	/**
	 * �ƾٿ���ID��ѯ�ÿ��ҵ�����Ա��
	 * @return
	 */
	public String findUserBySectId() {
		userList = userService.findUserBySectId(section);
		return "findUserBySectId";
	}

	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public String getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}
	
	
}
