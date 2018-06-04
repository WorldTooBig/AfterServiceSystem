<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<title>Insert title here</title>
	
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/layui.css">
</head>
<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">

		<%@include file="navbar.jsp" %>

		
		<div class="layui-body">
			<!-- 内容主体区域 -->
			<%-- <div style="padding: 15px;">内容主体区域</div>
				
				<h2>${user_login.userName }</h2>
				 --%>
				<fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
					<legend>用户权限管理</legend>
				</fieldset>
 
				<div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
					<ul class="layui-tab-title">
						<li class="layui-this">基本用户信息</li>
						<li>添加用户</li>
						<li>添加角色</li>
						<li>添加权限</li>
						<li>一二三四</li>
					</ul>
					<div class="layui-tab-content" style="height: 100px;">
						<div class="layui-tab-item layui-show">
						
						</div>
						<!-- 添加用户 -->
						<div class="layui-tab-item">
							<form class="layui-form" action="userAction_addUser" method="post">
								<div class="layui-form-item">
									<label class="layui-form-label">登录账号</label>
									<div class="layui-input-block">
										<input type="text" name="user.userName" lay-verify="required" autocomplete="off" placeholder="请输入账号" class="layui-input">
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">登录密码</label>
									<div class="layui-input-block">
										<input type="text" name="user.userPwd" lay-verify="required" autocomplete="off" placeholder="请输入密码" class="layui-input">
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">真实姓名</label>
									<div class="layui-input-block">
										<input type="text" name="user.userRealName" lay-verify="required" autocomplete="off" placeholder="请输入姓名" class="layui-input">
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">工号</label>
									<div class="layui-input-block">
										<input type="text" name="user.userJobNum" lay-verify="required" autocomplete="off" placeholder="请输入工号" class="layui-input">
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">职务</label>
									<div class="layui-input-block">
										<input type="text" name="user.userJobName" lay-verify="required" autocomplete="off" placeholder="请输入职务" class="layui-input">
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">电话</label>
									<div class="layui-input-block">
										<input type="text" name="user.userTell" lay-verify="phone" autocomplete="off" placeholder="请输入电话" class="layui-input">
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">邮箱</label>
									<div class="layui-input-block">
										<input type="text" name="user.userEmail" lay-verify="email" autocomplete="off" placeholder="请输入邮箱" class="layui-input">
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">所属公司</label>
									<div class="layui-input-block">
										<select id="compId" lay-filter="findDepartmentList" lay-verify="number">
											<option value="">--请选择--</option>
										</select>
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">所属部门</label>
									<div class="layui-input-block">
										<select id="deptId" lay-filter="findSectionList" lay-verify="number">
											<option value="">--请选择--</option>
										</select>
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">所属科室</label>
									<div class="layui-input-block">
										<select name="section.sectId" lay-verify="number">
											<option value="">--请选择--</option>
										</select>
									</div>
								</div>
								<div class="layui-form-item layui-form-text">
									<label class="layui-form-label">备注</label>
									<div class="layui-input-block">
										<textarea name="user.userRemark" placeholder="请输入备注" class="layui-textarea"></textarea>
									</div>
								</div>
								<!-- 按钮 -->
								<div class="layui-form-item">
									<div  class="layui-input-block">
										<div style="width: 216px; margin: 0;">
											<button lay-submit class="layui-btn layui-btn-fluid">添加</button>
										</div>
									</div>
								</div>
							</form>
					    </div>
						<div class="layui-tab-item">
							<form class="layui-form" action="roleAction_addRole" method="post">
								<div class="layui-form-item">
									<label class="layui-form-label">添加角色</label>
									<div class="layui-input-block">
										<input name="role.roleName" lay-verify="required" autocomplete="off" placeholder="请输入角色名称" class="layui-input" />
									</div>
								</div>	
								<!-- 按钮 -->
								<div class="layui-form-item">
									<div  class="layui-input-block">
										<div style="width: 216px; margin: 0;">
											<button lay-submit class="layui-btn layui-btn-fluid">添加</button>
										</div>
									</div>
								</div>
							</form>
						</div>
						<div class="layui-tab-item">
							<form class="layui-form" action="permissionAction_addPermission" method="post">
								<div class="layui-form-item">
									<label class="layui-form-label">添加权限</label>
									<div class="layui-input-block">
										<input name="permission.permName" lay-verify="required" autocomplete="off" placeholder="请输入角色名称" class="layui-input" />
									</div>
								</div>	
								<!-- 按钮 -->
								<div class="layui-form-item">
									<div  class="layui-input-block">
										<div style="width: 216px; margin: 0;">
											<button lay-submit class="layui-btn layui-btn-fluid">添加</button>
										</div>
									</div>
								</div>
							</form>
						
						</div>
						<div class="layui-tab-item">内容5
						
						</div>
					</div>
				</div> 


<!-- 	<hr>
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
	</div> -->
				
			</div>
		
		<div class="layui-footer">
	    	<!-- 底部固定区域 -->
	    	© layui.com - 底部固定区域
		</div>
	</div>
	<script type="text/javascript" src="${pageContext.request.contextPath}/layui.all.js"></script>
	
	<script>
	
	layui.use(['jquery', 'layer', 'form', 'element'], function(){
		var layer = layui.layer
		,form = layui.form
		,element = layui.element
		,$ = layui.$

		//获取公司
		$.post("companyAction_findCompanyListJson", "", function(data){
			var str = "";
			$.each(data.list, function(i, v) {
				str += "<option value='" + v.compId + "'>" + v.compName + "</option>";
			});
			$("#compId").append(str);
			form.render();
		}, "json");
		
		//根据公司ID获取部门
		form.on('select(findDepartmentList)', function(data){
			$.post("departmentAction_findDepartmentList", "company.compId=" + data.elem.value, function(data) {
				$("#deptId option:not(:first)").remove();
				var str = "";
				$.each(data.list, function(i, v) {
					str += "<option value='" + v.deptId + "'>" + v.deptName + "</option>";
				});
				$("#deptId").append(str);
				form.render();
			}, "json");
		});   
		
		//根据部门ID获取科室
		form.on('select(findSectionList)', function(data){
			$.post("sectionAction_findSectionList", "department.deptId=" + data.elem.value, function(data) {
				$("select[name='section.sectId'] option:not(:first)").remove();
				var str = "";
				$.each(data.list, function(i, v) {
					str += "<option value='" + v.sectId + "'>" + v.sectName + "</option>";
				});
				$("select[name='section.sectId']").eq(0).append(str);
				form.render();
			}, "json");
		});
		
		  
	});
	
	window.onload = start();

	function start() {
		userFind();
		roleFind();
		perFind();
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
	


</script>
</body>
</html>
