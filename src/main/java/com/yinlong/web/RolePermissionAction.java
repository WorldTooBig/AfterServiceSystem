package com.yinlong.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.yinlong.entity.Permission;
import com.yinlong.entity.Role;
import com.yinlong.entity.RolePermission;
import com.yinlong.service.IRolePermissionService;

@Controller("rolePermissionAction")
@Scope("prototype")
public class RolePermissionAction {

	@Resource(name = "rolePermissionService")
	private IRolePermissionService rolePermissionService;
	
	private Role role;
	private Permission permission;
	private RolePermission rolePermission;
	private List<RolePermission> list;
	private int[] pno;
	
	//查询角色权限信息
	public String findRolePermissionList() {
		list = rolePermissionService.findRolePermission();
		return "findRolePermissionList";
	}
	
	//根据ID删除角色权限
	public String deleteRolePermissionById() {
		if(rolePermissionService.deleteRolePermissionById(rolePermission)) {
		}
		return "deleteRolePermissionById";
	}
	
	//为角色绑定权限
	public String addRolePermission() {
		permission = new Permission();
		for (int i = 0; i < pno.length; i++) {
			permission.setPermId(pno[i]);
			rolePermission.setPermission(permission);
			if(rolePermissionService.addRolePermission(rolePermission)) {
				
			}
		}
		return "addRolePermission";
	}

	public RolePermission getRolePermission() {
		return rolePermission;
	}

	public void setRolePermission(RolePermission rolePermission) {
		this.rolePermission = rolePermission;
	}

	public List<RolePermission> getList() {
		return list;
	}

	public void setList(List<RolePermission> list) {
		this.list = list;
	}


	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public int[] getPno() {
		return pno;
	}

	public void setPno(int[] pno) {
		this.pno = pno;
	}

	public void setRolePermissionService(IRolePermissionService rolePermissionService) {
		this.rolePermissionService = rolePermissionService;
	}
	
	
}
