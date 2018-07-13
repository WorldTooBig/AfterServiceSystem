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
				<span>结论</span>
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
			,url: 'conDeadlineAction_findConclusion1'
			,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
		    ,cols: [[
		    	   {type:'numbers', title: '序号'}
			      ,{field:'docTheme', title: '主题', templet: '<div>{{d.replyList[0].deadline.placeFile.feedback.docTheme}}</div>'}
			      ,{field:'docCreateDate', title: '创建日期', templet: '<div>{{d.replyList[0].deadline.placeFile.feedback.docCreateDate}}</div>'}
			      ,{field:'docFindDate', title: '发现日期', templet: '<div>{{d.replyList[0].deadline.placeFile.feedback.docFindDate}}</div>'}
			      ,{field:'docFindAddr', title: '发现地点', templet: '<div>{{d.replyList[0].deadline.placeFile.feedback.docFindAddr}}</div>'}
			      ,{field:'repId', title: '答复人'}
			      ,{title: '操作', toolbar:'#toobarTab'}
		    ]]
		    ,page: true
		  });

		//跳转到考核通报审核页面
		table.on('tool(tabFilter)', function(obj){
			var data = obj.data;
			var layEvent = obj.event;
			if(layEvent == "conclusion") {
				location.href = "conDeadlineAction_findConclusionById?conclusion.conId=" + data.conId;
			}
		});
		
	});
	</script>
	
	<script type="text/html" id="toobarTab">
		<a class="layui-btn layui-btn-xs" lay-event="conclusion">审批</a>
	</script>

</body>
</html>