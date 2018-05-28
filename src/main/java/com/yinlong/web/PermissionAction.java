package com.yinlong.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.yinlong.entity.Permission;
import com.yinlong.entity.Role;
import com.yinlong.service.IPermissionService;

@Controller("permissionAction")
@Scope("prototype")
public class PermissionAction {

	@Resource(name = "permissionService")
	private IPermissionService permissionService;

	private Role role;
	private Permission permission;
	private List<Permission> permissionList;
	private String errorInfo;
	
	/**
	 * 添加权限
	 * @return
	 */
	public String addPermission() {
		if(permissionService.addPermission(permission)) {
			errorInfo = "添加权限成功";
		}
		errorInfo = "添加权限失败";
		return "addPermission";
	}
	
	/**
	 * 获取所有权限
	 * @return
	 */
	public String findPermissionList() {
		permissionList = permissionService.findPermissionList();
//		ActionContext.getContext().put("permissionList", permissionList);
		return "findPermissionList";
	}

	/**
	 * 根据角色id查询该角色未拥有的权限
	 * @return
	 */
	public String findPermissionNoBindingListByRole() {
		permissionList = permissionService.findPermissionNoBindingListByRole(role);
		return "findPermissionNoBindingListByRole";
	}
	
	
	public void setPermissionService(IPermissionService permissionService) {
		this.permissionService = permissionService;
	}

	public Permission getPermission() {
		return permission;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	public List<Permission> getPermissionList() {
		return permissionList;
	}

	public void setPermissionList(List<Permission> permissionList) {
		this.permissionList = permissionList;
	}

	public String getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}
	
	
}
