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

		<%-- <%@include file="navbar.jsp" %> --%>

		
		<div class="larry-personal">
			<header class="larry-personal-tit">
				<span>填写异常反馈单</span>
			</header>
			
			<div class="larry-personal-body clearfix">
			<form class="layui-form" action="userAction_findUserListLike" method="post">
				<div class="layui-form-item">
					<label class="layui-form-label">反馈单号</label>
					<div class="layui-input-block">
						<input name="" lay-verify="required" autocomplete="off" placeholder="请输入标题" class="layui-input" />
					</div>
				</div>	
				<div class="layui-form-item">
					<label class="layui-form-label">主题</label>
					<div class="layui-input-block">
						<input name="" lay-verify="required" autocomplete="off" placeholder="请输入标题" class="layui-input" />
					</div>
				</div>	
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">创建时间</label>
						<div class="layui-input-inline">
							<input id="date" name="" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
						</div>
					</div>		
					<div class="layui-inline">
						<label class="layui-form-label">发现时间</label>
						<div class="layui-input-inline">
							<input id="date1" name="" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-inline">
						<label class="layui-form-label">发现地点</label>
						<div class="layui-input-inline">
							<input name="" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
						</div>
					</div>	
					<div class="layui-inline">
						<label class="layui-form-label">异常类型</label>
						<div class="layui-input-inline">
							<select name="" lay-filter="aihao">
								<option value="">类型一</option>
								<option value="">类型二</option>
								<option value="">类型三</option>
								<option value="">类型四</option>
								<option value="">类型五</option>
							</select>
						</div>
					</div>	
				</div>
				<div class="layui-form-item layui-form-text">
					<label class="layui-form-label">异常描述</label>
					<div class="layui-input-block">
						<textarea name="" placeholder="请输入" class="layui-textarea"></textarea>
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">订单号</label>
					<div class="layui-input-block">
						<input name="" lay-verify="required" autocomplete="off" placeholder="请输入标题" class="layui-input" />
					</div>
				</div>	
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">客户名称</label>
						<div class="layui-input-inline">
							<input name="" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
						</div>
					</div>	
					<div class="layui-inline">
						<label class="layui-form-label">产品类别</label>
						<div class="layui-input-inline">
							<select name="" lay-filter="aihao">
								<option value="">类型一</option>
								<option value="">类型二</option>
								<option value="">类型三</option>
								<option value="">类型四</option>
								<option value="">类型五</option>
							</select>
						</div>
					</div>	
					<div class="layui-inline">
						<label class="layui-form-label">产品型号</label>
						<div class="layui-input-inline">
							<input name="" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
						</div>
					</div>	
				</div>
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">生产单位</label>
						<div class="layui-input-inline">
							<input name="" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
						</div>
					</div>	
					<div class="layui-inline">
						<label class="layui-form-label">生产班组</label>
						<div class="layui-input-inline">
							<input name="" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
						</div>
					</div>	
					<div class="layui-inline">
						<label class="layui-form-label">责任单位</label>
						<div class="layui-input-inline">
							<input name="" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
						</div>
					</div>	
					<div class="layui-inline">
						<label class="layui-form-label">责任岗位</label>
						<div class="layui-input-inline">
							<input name="" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
						</div>
					</div>	
				</div>
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">物料编码</label>
						<div class="layui-input-inline">
							<input name="" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
						</div>
					</div>	
					<div class="layui-inline">
						<label class="layui-form-label">物料名称</label>
						<div class="layui-input-inline">
							<input name="" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
						</div>
					</div>	
					<div class="layui-inline">
						<label class="layui-form-label">物料类型</label>
						<div class="layui-input-inline">
							<select name="" lay-filter="aihao">
								<option value="">类型一</option>
								<option value="">类型二</option>
								<option value="">类型三</option>
								<option value="">类型四</option>
								<option value="">类型五</option>
							</select>
						</div>
					</div>	
					<div class="layui-inline">
						<label class="layui-form-label">供应商名称</label>
						<div class="layui-input-inline">
							<input name="" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
						</div>
					</div>	
				</div>
				<div class="layui-form-item">
					<div class="layui-inline">
    					<label class="layui-form-label">是否停线</label>
						<div class="layui-input-inline">
							<input type="radio" name="aaa" value="1" title="是" checked="">
							<input type="radio" name="aaa" value="0" title="否">
						</div>
					</div>
					<div class="layui-inline">
						<label class="layui-form-label">工时损失</label>
						<div class="layui-input-inline">
							<input name="" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-inline">
						<label class="layui-form-label">不合格等级</label>
						<div class="layui-input-inline">
							<select name="" lay-filter="aihao">
								<option value="">类型一</option>
								<option value="">类型二</option>
								<option value="">类型三</option>
								<option value="">类型四</option>
								<option value="">类型五</option>
							</select>
						</div>	
					</div>	
				</div>
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">使用数量</label>
						<div class="layui-input-inline">
							<input name="" lay-verify="number" placeholder="请输入" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-inline">
						<label class="layui-form-label">不良品数量</label>
						<div class="layui-input-inline">
							<input name="" lay-verify="number" placeholder="请输入" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-inline">
						<label class="layui-form-label">发现异常单位</label>
						<div class="layui-input-inline">
							<input name="" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-inline">
						<label class="layui-form-label">是否批量</label>
						<div class="layui-input-inline">
							<input type="radio" name="bbb" value="1" title="是" checked="">
							<input type="radio" name="bbb" value="0" title="否">
						</div>
					</div>
				</div>
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">反馈人</label>
						<div class="layui-input-inline">
							<input name="" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-inline">
						<label class="layui-form-label">收件人</label>
						<div class="layui-input-inline">
							<input name="" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
						</div>
					</div>
				</div>
				
			</form>
			</div>
			<!-- 外部 -->
		</div>
		
		<!-- <div class="layui-footer">
	    	底部固定区域
	    	© layui.com - 底部固定区域
		</div> -->
	</div>
	<script type="text/javascript" src="${pageContext.request.contextPath}/layui.js"></script>
	<script>
	
	layui.use(['laydate', 'form'], function(){
		var laydate = layui.laydate
		form = layui.form
		
		//日期时间INPUT
		laydate.render({
		    elem: '#date, #date1' //指定元素
			,type: 'datetime'
			,calendar: true
		});
		
		form.render();
	});
	
	</script>
	
</body>
</html>
