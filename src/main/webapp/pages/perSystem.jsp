<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
</head>
<body>

	<h2>${user_login.userName }</h2>


<div style="float: left; width: 100%">
	<div style="float:left; width:30%;">
		<h2>添加用户</h2>
		<s:form action="userAction_addUser" method="post" onsubmit="return validUser(this)">
			登录账号：<s:textfield name="user.userName"/><br/>
			登录密码：<s:password name="user.userPwd"/><br/>
			真实姓名：<s:textfield name="user.userRealName"/><br/>
			工号：<s:textfield name="user.userJobNum"/><br/>
			职务：<s:textfield name="user.userJobName"/><br/>
			电话：<s:textfield name="user.userTell"/><br/>
			邮箱：<s:textfield name="user.userEmail"/><br/>
			备注：<s:textfield name="user.userRemark"/><br/>
			公司：<select id="compId" onchange="findDepartmentList(event)"><option value="0">--- 请选择 ---</option></select><br/>
			部门：<select id="deptId" onchange="findSectionList(event)"><option value="0">--- 请选择 ---</option></select><br/>
			科室：<select name="section.sectId"><option value="0">--- 请选择 ---</option></select><br/>
			<s:submit value="提交"/>
		</s:form>
	</div>
	
	<div style="float:left; width:30%;">
		<p></p>
		<h2>添加角色</h2>
		<s:form action="roleAction_addRole" method="post">
			角色名：<s:textfield name="role.roleName"/><br/>
			<s:submit value="提交"/>
		</s:form>
	</div>
	
	<div style="float:left; width:30%;">
		<p></p>
		<h2>添加权限</h2>
		<s:form action="permissionAction_addPermission" method="post">
			权限名：<s:textfield name="permission.permName"/><br/>
			<s:submit value="提交"/>
		</s:form>
	</div>
</div>
	
	<hr>
	<div id="userDiv">
		<h2>用户信息</h2>
		<table border=1>
			<tr>
				<th>序号</th><th>用户名</th><th>密码</th><th>真实名</th><th>工号</th><th>职务</th><th>电话</th><th>邮箱</th><th>备注</th>
			</tr>
		</table>
	</div>
	
	<div id="roleDiv">
		<h2>角色信息</h2>
		<ul>
		</ul>
	</div>
	<br/>
	
	<hr>
	<div id="perDiv">
		<h2>权限信息</h2>
		<ul>
		</ul>
	</div>
	
	<div id="fixDiv" style="position: fixed; top: 0; left: 0; width: 100%; height: 100%;">
		<div style="position: fixed; top: 20%; left: 35%; width: 30%; height: 50%; background-color: RGBA(0,0,0,0.5);">
		</div>
	</div>
	
</body>
<script>
	
	window.onload = start();

	function start() {
		userFind();
		roleFind();
		perFind();
		findCompanyList();
		fixDivToggle();
	}
	
	//获得所有用户信息
	function userFind() {
		$.post("userAction_findUserAndROleByUserList", null, function(data){
			$("#userDiv table tr:not(:first)").remove();
			var strs = "";
			$.each(data.list, function(i, val){
				strs += "<tr>";
				strs += "<td>" + (++i) + "</td>";
				strs += "<td>" + val[0].userName + "</td>";
				strs += "<td>" + val[0].userPwd + "</td>";
				strs += "<td>" + val[0].userRealName + "</td>";
				strs += "<td>" + val[0].userJobNum + "</td>";
				strs += "<td>" + val[0].userJobName + "</td>";
				strs += "<td>" + val[0].userTell + "</td>";
				strs += "<td>" + val[0].userEmail + "</td>";
				strs += "<td>" + val[0].userRemark + "</td>";
				strs += "</tr>";
				strs += "<tr>";
				strs += "<td colspan=9 style='padding-left:20px;'>";
				$.each(val[1], function(j, value) {
					var v = value.toString().split(",");
					strs += ++j + "." + v[1] + "------------------<a href='\${pageContext.request.contextPath}/userRoleAction_deleteUserRole?userRole.urId=" + v[0] + "'>解绑</a><br />";
				});
				strs += "<input type='button' value='绑定角色' onclick=bindingRole('" + val[0].userId + "','" + val[0].userName + "') />";
				strs += "";
				strs += "</td>";
				strs += "</tr>";
			});
			$("#userDiv table").append(strs);
		}, "json");
	}
	
	//获得所有角色信息
	function roleFind() {
		$.post("roleAction_findRoleAndPermission", null, function(data){
			$("#roleDiv ul").empty();
			var strs = "";
			$.each(data.list, function(i, v){
				strs += "<li>" + v[0].roleName;
				strs += "<ol>";
				$.each(v[1], function(j, value){
					var val = value.toString().split(",");
					strs += '<li>';
					strs += val[1] + '-------------------<a href="\${pageContext.request.contextPath}/rolePermissionAction_deleteRolePermissionById?rolePermission.rpId=' + val[0] + '\">解绑</a>';
					strs += "</li>";
				});
				strs += "<input type='button' value='绑定权限' onclick=bindingPer('" + v[0].roleId + "','" + v[0].roleName + "') />";
				strs += "</ol>";
				strs += "</li>";
				
			});
			$("#roleDiv ul").append(strs);
		}, "json");
		
	}
	
	//获得所有权限信息
	function perFind() {
		$.post("permissionAction_findPermissionList", null, function(data) {
			$("#perDiv ul").empty();
			var strs = "";
			$.each(data.permissionList, function(i, v){
				strs += "<li>" + v.permName + "</li>";
			});
			$("#perDiv ul").append(strs);
		}, "json");
	}
	
	//绑定权限
	function bindingPer(rno, rname) {
		$("#fixDiv div").empty();
		fixDivToggle();
		$.post("permissionAction_findPermissionNoBindingListByRole", "role.roleId=" + rno, function(data) {
			var strs = "";
			strs += "<h2>角色名：" + rname + "</h2>";
			strs += "<form action='rolePermissionAction_addRolePermission' method='post'>";
			strs += "<input type='hidden' name='rolePermission.role.roleId' value='" + rno + "' />";
			strs += "<ul>";
			$.each(data.permissionList, function(i, v) {
				strs += "<li><input type='checkbox' name='pno' value='" + v[0] + "' />" + v[1] + "</li>";
			});
			strs += "</ul>"
			strs += "<br /><input type='submit' value='绑定权限' />";
			strs += "</form><br />";
			strs += "<input type='button' value='关闭' onclick='fixDivToggle()' />";
			$("#fixDiv div").html(strs);
		}, "json");
	}
	
	//绑定角色
	function bindingRole(uno, uname) {
		$("#fixDiv div").empty();
		fixDivToggle();
		$.post("userRoleAction_findRoleNoBindingListByUser", "user.userId=" + uno, function(data) {
			var strs = "";
			strs += "<h2>用户名：" + uname + "</h2>";
			strs += "<form action='userRoleAction_addUserRole' method='post'>";
			strs += "<input type='hidden' name='userRole.user.userId' value='" + uno + "' />";
			strs += "<ul>";
			$.each(data.roleList, function(i, v) {
				strs += "<li><input type='checkbox' name='rno' value='" + v[0] + "' />" + v[1] + "</li>";
			});
			strs += "</ul>";
			strs += "<br /><input type='submit' value='绑定角色' />";
			strs += "</form><br />";
			strs += "<input type='button' value='关闭' onclick='fixDivToggle()' />";
			$("#fixDiv div").html(strs);
		}, "json");
	}
	
	//获取所有公司
	function findCompanyList() {
		$.post("companyAction_findCompanyListJson", "", function(data){
			var str = "";
			$.each(data.list, function(i, v) {
				str += "<option value='" + v.compId + "'>" + v.compName + "</option>";
			});
			$("#compId").append(str);
		}, "json");
	}
	
	//根据公司ID查询它的所有部门
	function findDepartmentList(e) {
		$.post("departmentAction_findDepartmentList", "company.compId=" + e.target.value, function(data) {
			var str = "";
			$.each(data.list, function(i, v) {
				str += "<option value='" + v.deptId + "'>" + v.deptName + "</option>";
			}); 
			$("#deptId").append(str);
		}, "json");
	}	
	
	//根据部门ID查询它的所有科室
	function findSectionList(e) {
		$.post("sectionAction_findSectionList", "department.deptId=" + e.target.value, function(data) {
			var str = "";
			$.each(data.list, function(i, v) {
				str += "<option value='" + v.sectId + "'>" + v.sectName + "</option>";
			});
			$("select[name='section.sectId']").eq(0).append(str);
		}, "json");
	}
	
	//添加用户验证
	function validUser(form) {
		var $form = $(form);
		var userName = $form.children("[name='user.userName']").val();
		var userPwd = $form.children("[name='user.userPwd']").val();
		var userRealName = $form.children("[name='user.userRealName']").val();
		var userJobNum = $form.children("[name='user.userJobNum']").val();
		var userJobName = $form.children("[name='user.userJobName']").val();
		var userTell = $form.children("[name='user.userTell']").val();
		var userEmail = $form.children("[name='user.userEmail']").val();
		var userRemark = $form.children("[name='user.userRemark']").val();
		var compId = $form.children("#compId").val();
		var deptId = $form.children("#deptId").val();
		var sectId = $form.children("[name='section.sectId']").val();
		
		var checkEmail = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
		var checkTell = /^1\d{10}$/;
		/* alert(checkEmail.test(userEmail));
		return false; */
		if(userName == "") {
			alert("用户名不能为空！");
			return false;
		} else if(userName.length > 16) {
			alert("用户名太长！");
			return false;
		} else if(userPwd.length < 6) {
			alert("密码太短");
			return false;
		} else if(userPwd.length > 16) {
			alert("密码太长");
			return false;
		} else if(userRealName == "") {
			alert("真实姓名不能为空！");
			return false;
		} else if(userJobNum == "") {
			alert("工号不能为空！");
			return false;
		} else if(userJobName == "") {
			alert("职务不能为空！");
			return false;
		} else if(!checkTell.test(userTell)) {
			alert("请填写正确的手机号码！");
			return false;
		} else if(!checkEmail.test(userEmail)) {
			alert("邮箱格式不正确！");
			return false;
		} else if(compId == 0) {
			alert("请选择所属公司！");
			return false;
		} else if(deptId == 0) {
			alert("请选择所属部门！");
			return false;
		} else if(sectId == 0) {
			alert("请选择所属科室！");
			return false;
		}
		return true;
	}
	
	
	function fixDivToggle() {
		var $fixDiv = $("#fixDiv");
		if($fixDiv.css("display") == "none") {
			$fixDiv.css("display", "block");
		} else {
			$fixDiv.css("display", "none");
		}
	}

</script>
</html>