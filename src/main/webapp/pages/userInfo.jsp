<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<title>Insert title here</title>
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/layui.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
</head>
<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">

		<%@include file="navbar.jsp" %>

		
		<div class="layui-body">
			<!-- 内容主体区域 -->
			<div style="padding: 15px;">根据条件筛选</div>
			
			<form class="layui-form" action="userAction_findUserListLike" method="post">
			
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">姓名</label>
						<div class="layui-input-inline">
							<input type="text" name="user.userRealName" placeholder="请输入" autocomplete="off" class="layui-input">
						</div>
					</div>			
					<div class="layui-inline">
						<label class="layui-form-label">工号</label>
						<div class="layui-input-inline">
							<input type="text" name="user.userJobNum" placeholder="请输入" autocomplete="off" class="layui-input">
						</div>
					</div>			
					<div class="layui-inline">
						<label class="layui-form-label">职务</label>
						<div class="layui-input-inline">
							<input type="text" name="user.userJobName" placeholder="请输入" autocomplete="off" class="layui-input">
						</div>
					</div>			
					<div class="layui-inline">
						<label class="layui-form-label">电话</label>
						<div class="layui-input-inline">
							<input type="text" name="user.userTell" placeholder="请输入" autocomplete="off" class="layui-input">
						</div>
					</div>			
					<div class="layui-inline">
						<label class="layui-form-label">邮箱</label>
						<div class="layui-input-inline">
							<input type="text" name="user.userEmail" placeholder="请输入" autocomplete="off" class="layui-input">
						</div>
					</div>			
					<div class="layui-inline">
						<label class="layui-form-label">备注</label>
						<div class="layui-input-inline">
							<input type="text" name="user.userRemark" placeholder="请输入" autocomplete="off" class="layui-input">
						</div>
					</div>		
				
					<div class="layui-inline">
						<label class="layui-form-label">选择归属</label>
						<div class="layui-input-inline">
							<select name="company.compId" lay-filter="findDepartmentList">
								<option value="0">请选择公司</option>
							</select>
						</div>
						<div class="layui-input-inline">
							<select name="department.deptId" lay-filter="findSectionList">
								<option value="0">请选择部门</option>
							</select>
						</div>
						<div class="layui-input-inline">
							<select name="section.sectId">
								<option value="0">请选择科室</option>
							</select>
						</div>
					</div>
				</div>
				
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button type="button" class="layui-btn" onclick="buildTable()">立即查询</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
				
			</form>
			
			<table class="layui-hide" id="userTab" lay-data="{id: 'idTest'}"></table>
			
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
		,table = layui.table

		//获取公司
		$.post("companyAction_findCompanyListJson", "", function(data){
			var str = "";
			$.each(data.list, function(i, v) {
				str += "<option value='" + v.compId + "'>" + v.compName + "</option>";
			});
			$("select[name='company.compId']").append(str);
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
				$("select[name='department.deptId']").append(str);
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
	
	window.onload = buildTable();
	
	//生成表格
	function buildTable() {
		layui.use('table', function(){
			  var table = layui.table;
			  
			  table.render({
			    elem: '#userTab'
				,url:'userAction_findUserListLike?' + $("form:first").serialize()
				,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
			    ,cols: [[
			    	   {type:'numbers', title: '序号'}
				      ,{field:'userId', title: 'ID', sort: true}
				      ,{field:'userName', title: '用户名'}
				      ,{field:'userPwd', title: '密码'}
				      ,{field:'userRealName', title: '真实姓名'}
				      ,{field:'userJobNum', title: '工号'}
				      ,{field:'userJobName', title: '职务'}
				      ,{field:'userTell', title: '电话'}
				      ,{field:'userEmail', title: '邮箱'}
				      ,{field:'userRemark', title: '备注'}
				      ,{field:'section', title: 'OO' ,  templet: '<div>{{d.section.department.company.compName}}</div>'}
				      ,{field:'section', title: 'OO' ,  templet: '<div>{{d.section.department.deptName}}</div>'}
				      ,{field:'section', title: 'OO' ,  templet: '<div>{{d.section.sectName}}</div>'}
			    ]]
			    ,page: true
			  });
			});
	}
	
	
	</script>
</body>
</html>
