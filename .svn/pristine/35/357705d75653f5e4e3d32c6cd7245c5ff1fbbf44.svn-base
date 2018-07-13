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
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.params.js"></script>
</head>
<body>
	<div class="larry-wrapper">
		
		<div class="larry-personal">
			<header class="larry-personal-tit">
				<span>责任单位答复</span>
			</header>
			
			<div class="larry-personal-body clearfix">
				<form class="layui-form" action="replyDeadlineAction_addReply" method="post">
					<input type="hidden" name="notified.notId">
					<input type="hidden" name="deadline.deaId">
					<input type="hidden" name="reply.repId">
					<input type="hidden" name="process.proId">
					<div class="layui-form-item">
						<label class="layui-form-label">责任单位</label>
						<div class="layui-input-block">
							<input name="" lay-verify="required" autocomplete="off" placeholder="请输入" class="layui-input" />
						</div>
					</div>	
					<div class="layui-form-item layui-form-text">
						<label class="layui-form-label">原因分析</label>
						<div class="layui-input-block">
							<textarea name="reply.repCauseAnalysis" placeholder="请输入" class="layui-textarea"></textarea>
						</div>
					</div>
					<div class="layui-form-item layui-form-text">
						<label class="layui-form-label">纠正预防措施</label>
						<div class="layui-input-block">
							<textarea name="reply.repCorrectionMethod" placeholder="请输入" class="layui-textarea"></textarea>
						</div>
					</div>
					<div class="layui-form-item layui-form-text">
						<label class="layui-form-label">纠正预防措施</label>
						<div class="layui-input-block">
							<table lay-filter="tab">
								<thead><tr>
								<th lay-data="{field:'etrCorrectionProject'}">措施自查确认项目</th>
								<th lay-data="{field:'etrDescription', edit: 'text'}">简要描述</th>
								<th lay-data="{field:'etrFileNo', edit: 'text'}">相关文件编号</th>
								</tr></thead>
								<tr><td>管理流程及制度修订</td><td></td><td></td></tr>
								<tr><td>技术/工艺文件修订</td><td></td><td></tr>
								<tr><td>工装/设备增添或改良</td><td></td><td></td></tr>
								<tr><td>模具改良</td><td></td><td></td></tr>
								<tr><td>人员培训</td><td></td><td></td></tr>
							</table>
						</div>
						<input type="hidden" name="etr">
					</div>
					<div class="layui-form-item">
						<div class="layui-input-block">
							<button type="button" class="layui-btn" data-proId="16">申请延期</button>
							<button type="button" class="layui-btn" data-proId="17">申请关闭</button>
							<button type="button" class="layui-btn" data-proId="18">指派下一责任单位</button>
							<button type="button" class="layui-btn layui-btn-primary" data-proId="9">答复限期整改单</button>
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

		//获取该答复所属的答复单
		var repId = $.query.get("repId");
		$("input[name='reply.repId']").val(repId);
		//获取该答复所属的限期单 
		var deaId = $.query.get("deaId");
		$("input[name='deadline.deaId']").val(deaId);
		
		//表格渲染
		table.init('tab', {});
		
		$(".layui-btn").click(function(e){
			var proId = $(e.target).attr("data-proId");
			$("input[name='process.proId']").val(proId);
			//序列化预防措施表格里的填写内容
			$("input[name='etr']").val(JSON.stringify(table.cache[1]));
			$("form").submit();
		});
	});
	
	
	function rep(proId) {
		$("input[name='process.proId']").val(proId);
		//序列化预防措施表格里的填写内容
		$("input[name='etr']").val(JSON.stringify(table.cache[1]));
		$("form").submit();
	}
	</script>
</body>
</html>