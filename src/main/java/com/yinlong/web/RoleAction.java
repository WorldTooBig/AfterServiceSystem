package com.yinlong.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.json.annotations.JSON;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.yinlong.entity.Role;
import com.yinlong.service.IRoleService;

@Controller("roleAction")
@Scope("prototype")
public class RoleAction {
	
	@Resource(name = "roleService")
	private IRoleService roleService;
	
	private Role role;
	private List<Role> roleList;
	private List list;
	
	private String errorInfo;
	
	/**
	 * ��ӽ�ɫ
	 * @return
	 */
	public String addRole() {
		if(roleService.addRole(role)) {
			errorInfo =  "��ӽ�ɫ�ɹ�";
		}
		errorInfo =  "��ӽ�ɫʧ��";
		return "addRole";
	}

	/**
	 * ��ѯ���н�ɫ
	 * @return
	 */
	public String findRoleList() {
		roleList = roleService.findRoleList();
		ActionContext.getContext().put("roleList", roleList);
		return "findRoleList";
	}

	/**
	 * ��ѯ���н�ɫ����ӵ�е�Ȩ��
	 * @return
	 */
	public String findRoleAndPermission() {
		list = new ArrayList();
		roleList = roleService.findRoleList();
		for (Role r : roleList) {
			List l = new ArrayList();
			l.add(r);
			l.add(roleService.findRoleAndPermissionByRoleId(r));
			list.add(l);
		}
		return "findRoleAndPermission";
	}

	/**
	 * ���ݴ����Role��rname��ѯ��Role��ӵ�е�Ȩ��
	 * @param role
	 * @return
	 */
	public String findRoleAndPermissionByRoleName() {
		list = roleService.findRoleAndPermissionByRoleName(role);
		return "findRoleAndPermissionByRoleName";
	}
	
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}
	
	
}
