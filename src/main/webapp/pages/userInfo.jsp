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
			
			<form class="layui-form" action="">
			
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">姓名</label>
						<div class="layui-input-inline">
							<input type="text" name="username" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
						</div>
					</div>			
					<div class="layui-inline">
						<label class="layui-form-label">工号</label>
						<div class="layui-input-inline">
							<input type="text" name="username" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
						</div>
					</div>			
					<div class="layui-inline">
						<label class="layui-form-label">职务</label>
						<div class="layui-input-inline">
							<input type="text" name="username" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
						</div>
					</div>			
					<div class="layui-inline">
						<label class="layui-form-label">电话</label>
						<div class="layui-input-inline">
							<input type="text" name="username" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
						</div>
					</div>			
					<div class="layui-inline">
						<label class="layui-form-label">邮箱</label>
						<div class="layui-input-inline">
							<input type="text" name="username" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
						</div>
					</div>			
					<div class="layui-inline">
						<label class="layui-form-label">备注</label>
						<div class="layui-input-inline">
							<input type="text" name="username" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
						</div>
					</div>		
				
					<div class="layui-inline">
						<label class="layui-form-label">行内选择框</label>
						<div class="layui-input-inline">
							<select name="quiz1">
								<option value="">请选择省</option>
								<option value="浙江" selected="">浙江省</option>
								<option value="你的工号">江西省</option>
								<option value="你最喜欢的老师">福建省</option>
							</select>
						</div>
						<div class="layui-input-inline">
							<select name="quiz2">
								<option value="">请选择市</option>
								<option value="杭州">杭州</option>
								<option value="宁波" disabled="">宁波</option>
								<option value="温州">温州</option>
								<option value="温州">台州</option>
								<option value="温州">绍兴</option>
							</select>
						</div>
						<div class="layui-input-inline">
							<select name="quiz3">
								<option value="">请选择县/区</option>
								<option value="西湖区">西湖区</option>
								<option value="余杭区">余杭区</option>
								<option value="拱墅区">临安市</option>
							</select>
						</div>
					</div>
				</div>
				
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn" lay-submit="" lay-filter="demo1">立即查询</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
				
			</form>
			
			<table class="layui-hide" id="userTab"></table>
			
		</div>
		
		<div class="layui-footer">
	    	<!-- 底部固定区域 -->
	    	© layui.com - 底部固定区域
		</div>
	</div>
	<script type="text/javascript" src="${pageContext.request.contextPath}/layui.all.js"></script>
	<script>
		layui.use('table', function(){
			  var table = layui.table;
			  
			  table.render({
			    elem: '#userTab'
				,url:'userAction_findUseListLayui' 
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
			    ]]
			    ,page: true
			  });
			});
	</script>
</body>
</html>
