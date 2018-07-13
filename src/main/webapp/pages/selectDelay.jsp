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
				<span>选择申请延期单</span>
			</header>
			
			<div class="larry-personal-body clearfix">
			<table class="layui-hide" id="tab" lay-filter="tabFilter"></table>
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
		
		
		//表格生成
		table.render({
		    elem: '#tab'
			,url: 'replyDeadlineAction_findDelayList'
			,cellMinWidth: 80 //全局定义常规单元格的最小宽度
		    ,cols: [[
		    	   {type:'numbers', title: '序号'}
			      ,{field:'docTheme', title: '主题', templet: '<div>{{d.deadline.placeFile.feedback.docTheme}}</div>'}
			      ,{field:'docCreateDate', title: '创建日期'}
			      ,{field:'docFindDate', title: '发现日期'}
			      ,{field:'docFindAddr', title: '发现地点'}
			      ,{field:'userJobNum', title: '反馈人'}
			      ,{title: '操作', toolbar:'#toobarTab'}
		    ]]
		    ,page: true
		  });

		//跳转到填写归档页面
		table.on('tool(tabFilter)', function(obj){
			var data = obj.data;
			var layEvent = obj.event;
			if(layEvent == "edit") {
				location.href = "delayAction_findReplyByIdOnDelay?reply.repId=" + data.repId;
			} else if(layEvent == 'detail'){
				location.href = "${pageContext.request.contextPath}/pages/delay.jsp?repId=" + data.repId;
			}
		});
		
	});
	</script>
	
	<script type="text/html" id="toobarTab">
		<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="edit">处理</a>
		<a class="layui-btn layui-btn-xs" lay-event="detail">查看</a>
	</script>

</body>
</html>