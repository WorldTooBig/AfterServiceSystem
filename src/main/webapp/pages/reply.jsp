<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<title>Insert title here</title>
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/layui.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/global.css" media="all">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/personal.css" media="all">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
</head>
<body>
	<div class="larry-wrapper">
		
		<div class="larry-personal">
			<header class="larry-personal-tit">
				<span>责任单位答复</span>
			</header>
			
			<div class="larry-personal-body clearfix">
				<form class="layui-form" action="" method="post">
					
					<div class="layui-form-item">
						<label class="layui-form-label">责任单位</label>
						<div class="layui-input-block">
							<input name="" lay-verify="required" autocomplete="off" placeholder="请输入" class="layui-input" />
						</div>
					</div>	
					<div class="layui-form-item layui-form-text">
						<label class="layui-form-label">原因分析</label>
						<div class="layui-input-block">
							<textarea name="" placeholder="请输入" class="layui-textarea"></textarea>
						</div>
					</div>
					<div class="layui-form-item layui-form-text">
						<label class="layui-form-label">纠正预防措施</label>
						<div class="layui-input-block">
							<textarea name="" placeholder="请输入" class="layui-textarea"></textarea>
						</div>
					</div>
					<div class="layui-form-item layui-form-text">
						<label class="layui-form-label">纠正预防措施</label>
						<div class="layui-input-block">
							<table lay-filter="tab">
								<thead><tr><th lay-data="{field:'name'}">措施自查确认项目</th><th lay-data="{edit: 'text'}">简要描述</th><th lay-data="{edit: 'text'}">相关文件编号</th></tr></thead>
								<tr><td>管理流程及制度修订</td><td></td><td></td></tr>
								<tr><td>技术/工艺文件修订</td><td></td><td></tr>
								<tr><td>工装/设备增添或改良</td><td></td><td></td></tr>
								<tr><td>模具改良</td><td></td><td></td></tr>
								<tr><td>人员培训</td><td></td><td></td></tr>
							</table>
						</div>
					</div>
					<div class="layui-form-item">
						<div class="layui-input-block">
							<button type="button" class="layui-btn">申请延期</button>
							<button lay-submit class="layui-btn">申请关闭</button>
							<button type="button" class="layui-btn layui-btn-primary">答复限期整改单</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>


	<script type="text/javascript" src="${pageContext.request.contextPath}/layui.js"></script>
	
	<script>
	layui.use(['jquery', 'laydate', 'form', 'table'], function(){
		var laydate = layui.laydate
		,form = layui.form
		,table = layui.table
		,$ = layui.$

		table.init('tab', {});
	});
	</script>
</body>
</html>