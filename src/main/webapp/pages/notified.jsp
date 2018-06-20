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
				<span>考核通报</span>
			</header>
			
			<div class="larry-personal-body clearfix">
				<form class="layui-form" action="" method="post">
					<input type="hidden" name="placeFile.plaId" value="">
					<div class="layui-form-item">
						<label class="layui-form-label">问题类别</label>
						<div class="layui-input-block" id="problemType">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">是否引发售后</label>
						<div class="layui-input-block">
							<input type="radio" name="" value="1" title="是" checked="">
							<input type="radio" name="" value="0" title="否">
						</div>
					</div>
					<div class="layui-form-item layui-form-text">
						<label class="layui-form-label">原因初步分析</label>
						<div class="layui-input-block">
							<textarea name="" placeholder="请输入" class="layui-textarea"></textarea>
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">责任单位</label>
						<div class="layui-input-block">
							<input type="checkbox" name="1" lay-skin="primary" title="人员管理" value="人员管理">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">对责任单位的考核情况</label>
						<div class="layui-input-block">
							<div class="layui-form-item">
								<div class="layui-inline">
									<label class="layui-form-label">责任单位</label>
									<div class="layui-input-inline">
										<input name="" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
									</div>
								</div>	
								<div class="layui-inline">
									<label class="layui-form-label">责任人</label>
									<div class="layui-input-inline">
										<input name="" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
									</div>
								</div>	
								<div class="layui-inline">
									<label class="layui-form-label">扣分</label>
									<div class="layui-input-inline">
										<input name="" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
									</div>
								</div>	
								<div class="layui-inline">
									<label class="layui-form-label">通报批评</label>
									<div class="layui-input-inline">
										<input type="checkbox" name="" lay-skin="switch" lay-text="ON|OFF" value="1">	
									</div>
								</div>	
								<div class="layui-inline">
									<label class="layui-form-label">备注</label>
									<div class="layui-input-inline">
										<input name="" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
									</div>
								</div>
							</div>
							<div class="layui-form-item">
								<div class="layui-inline">
									<label class="layui-form-label">责任单位</label>
									<div class="layui-input-inline">
										<input name="" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
									</div>
								</div>	
								<div class="layui-inline">
									<label class="layui-form-label">责任人</label>
									<div class="layui-input-inline">
										<input name="" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
									</div>
								</div>	
								<div class="layui-inline">
									<label class="layui-form-label">扣分</label>
									<div class="layui-input-inline">
										<input name="" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
									</div>
								</div>	
								<div class="layui-inline">
									<label class="layui-form-label">通报批评</label>
									<div class="layui-input-inline">
										<input type="checkbox" name="" lay-skin="switch" lay-text="ON|OFF" value="1">	
									</div>
								</div>	
								<div class="layui-inline">
									<label class="layui-form-label">备注</label>
									<div class="layui-input-inline">
										<input name="" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
									</div>
								</div>
							</div>
							<div class="layui-form-item">
								<div class="layui-inline">
									<label class="layui-form-label">责任单位</label>
									<div class="layui-input-inline">
										<input name="" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
									</div>
								</div>	
								<div class="layui-inline">
									<label class="layui-form-label">责任人</label>
									<div class="layui-input-inline">
										<input name="" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
									</div>
								</div>	
								<div class="layui-inline">
									<label class="layui-form-label">扣分</label>
									<div class="layui-input-inline">
										<input name="" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
									</div>
								</div>	
								<div class="layui-inline">
									<label class="layui-form-label">通报批评</label>
									<div class="layui-input-inline">
										<input type="checkbox" name="" lay-skin="switch" lay-text="ON|OFF" value="1">	
									</div>
								</div>	
								<div class="layui-inline">
									<label class="layui-form-label">备注</label>
									<div class="layui-input-inline">
										<input name="" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">责任单位限期整改日期</label>
						<div class="layui-input-block">
							<input id="date" name="" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<div class="layui-input-block">
							<button type="submit" class="layui-btn">保存并发送</button>
							<button type="reset" class="layui-btn layui-btn-primary">重置</button>
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

		//日期时间INPUT
		laydate.render({
		    elem: '#date' //指定元素
			,type: 'datetime'
			,calendar: true
		});
		
		//问题类别
		$.post("problemTypeAction_findProblemTypeList", "", function(data){
			var str = ""
			$.each(data.problemTypeList, function(i, v){
				str += "<input type='checkbox' name='' lay-skin='primary' title='" + v.pbtName + "' value='" + v.pbtName + "'>";
			});
			$("#problemType").append(str);
			form.render();
		}, "json");
		
	});
	
	window.onload = start();
	
	function start() {
		getFeedbackId();
	}
	
	function getFeedbackId(){
		var plaId = $.query.get("plaId");
		$("input[name='placeFile.plaId']").val(plaId);
	}
	</script>

</body>
</html>