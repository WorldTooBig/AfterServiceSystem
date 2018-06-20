<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="placeFile.viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
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
				<span>异常反馈单归档操作</span>
			</header>
			
			<div class="larry-personal-body clearfix">
				<form class="layui-form" action="placeFileAction_doAddPlaceFile" method="post">
					
					<div class="layui-form-item">
						<label class="layui-form-label">问题类别</label>
						<div class="layui-input-block" id="problemType">
						</div>
					</div>	
					<div class="layui-form-item layui-form-text">
						<label class="layui-form-label">预防措施确认</label>
						<div class="layui-input-block">
							<textarea name="" placeholder="请输入" class="layui-textarea"></textarea>
						</div>
					</div>
					<div class="layui-form-item layui-form-text">
						<label class="layui-form-label">考核结论</label>
						<div class="layui-input-block">
							<textarea name="" placeholder="请输入" class="layui-textarea"></textarea>
						</div>
					</div>
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button type="button" class="layui-btn">保存并发送</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
				</form>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="${pageContext.request.contextPath}/layui.js"></script>
	
	<script type="text/javascript">

	layui.use(['jquery', 'laydate', 'form'], function(){
		var laydate = layui.laydate
		,form = layui.form
		,$ = layui.$
		
		//问题类别
		$.post("problemTypeAction_findProblemTypeList", "", function(data){
			var str = ""
			$.each(data.problemTypeList, function(i, v){
				str += "<input type='checkbox' name='' lay-skin='primary' title='" + v.pbtName + "' value='" + v.pbtName + "'>";
			});
			$("#problemType").append(str);
			form.render();
		}, "json");
		

		form.render();
		
	});	
	
	
	</script>
	
</body>
</html>