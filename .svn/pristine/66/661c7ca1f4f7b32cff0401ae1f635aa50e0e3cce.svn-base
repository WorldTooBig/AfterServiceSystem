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
				<span>根据条件筛选</span>
			</header>
			
			
			<form class="layui-form" action="" method="post">
			
				<div class="layui-form-item">
					<label class="layui-form-label">编号</label>
					<div class="layui-input-block">
						<input name="feedback.docId" lay-verify="required" autocomplete="off" placeholder="请输入主题" class="layui-input" />
					</div>
				</div>	
				<div class="layui-form-item">
					<label class="layui-form-label">主题</label>
					<div class="layui-input-block">
						<input name="feedback.docTheme" lay-verify="required" autocomplete="off" placeholder="请输入主题" class="layui-input" />
					</div>
				</div>	
				<div class="layui-form-item">
					<!-- <div class="layui-inline">
						<label class="layui-form-label">发现时间</label>
						<div class="layui-input-inline">
							<input id="date" name="feedback.docFindDate" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
						</div>
					</div> -->
					<div class="layui-inline">
						<label class="layui-form-label">发现地点</label>
						<div class="layui-input-inline">
							<input name="feedback.docFindAddr" lay-verify="required" placeholder="车间和产线" autocomplete="off" class="layui-input">
						</div>
					</div>	
					
				</div>
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">客户名称</label>
						<div class="layui-input-inline">
							<input name="feedback.docCustName" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
						</div>
					</div>	
					<div class="layui-inline">
						<label class="layui-form-label">产品类别</label>
						<div class="layui-input-inline">
							<select name="feedback.productType.pdtId" lay-filter="productTypes">
								<option value="">请选择</option>
							</select>
						</div>
					</div>	
					<div class="layui-inline">
						<label class="layui-form-label">产品型号</label>
						<div class="layui-input-inline">
							<input name="feedback.docProMode" lay-verify="required" placeholder="如：GTQ6121VBT3 /30AH/40AH" autocomplete="off" class="layui-input">
						</div>
					</div>	
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">订单号</label>
					<div class="layui-input-block">
						<input name="feedback.docOrderNum" lay-verify="required" autocomplete="off" placeholder="请输入标题" class="layui-input" />
					</div>
				</div>	
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">生产单位</label>
						<div class="layui-input-inline">
							<input name="feedback.docProDep" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
						</div>
					</div>	
					<div class="layui-inline">
						<label class="layui-form-label">生产班组</label>
						<div class="layui-input-inline">
							<input name="feedback.docProTeam" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
						</div>
					</div>	
					<div class="layui-inline">
						<label class="layui-form-label">责任工序岗位</label>
						<div class="layui-input-inline">
							<input name="feedback.docResStation" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
						</div>
					</div>	
				</div>
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">物料编码</label>
						<div class="layui-input-inline">
							<input name="feedback.docItemNum" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
						</div>
					</div>	
					<div class="layui-inline">
						<label class="layui-form-label">物料名称</label>
						<div class="layui-input-inline">
							<input name="feedback.docItemName" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
						</div>
					</div>	
					<div class="layui-inline">
						<label class="layui-form-label">物料类型</label>
						<div class="layui-input-inline">
							<select name="feedback.docItemType">
								<option value="">请选择</option>
								<option value="外购件">外购件</option>
								<option value="自制件">自制件</option>
							</select>
						</div>
					</div>	
					<div class="layui-inline">
						<label class="layui-form-label">供应商</label>
						<div class="layui-input-inline">
							<input name="feedback.docSupName" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
						</div>
					</div>	
				</div>
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">停线工时损失</label>
						<div class="layui-input-inline">
							<input name="feedback.docLoss" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-inline">
						<label class="layui-form-label">不合格等级</label>
						<div class="layui-input-inline">
							<select name="feedback.docSeverityLevel" lay-filter="aihao">
								<option value="">请选择</option>
								<option value="A">A</option>
								<option value="B">B</option>
								<option value="C">C</option>
							</select>
						</div>	
					</div>	
				</div>
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">使用数量</label>
						<div class="layui-input-inline">
							<input name="feedback.docUsedCounts" lay-verify="number" placeholder="请输入整数" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-inline">
						<label class="layui-form-label">不良品数量</label>
						<div class="layui-input-inline">
							<input name="feedback.docDefproCounts" lay-verify="number" placeholder="请输入整数" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-inline">
						<label class="layui-form-label">发现异常单位</label>
						<div class="layui-input-inline">
							<select name="feedback.docFindDep" lay-filter="aihao">
								<option value="">请选择</option>
								<option value="生产自检发现">生产自检发现</option>
								<option value="质控部专检发现">质控部专检发现</option>
								<option value="生产和质控共同发现">生产和质控共同发现</option>
							</select>
						</div>	
					</div>
				</div>
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">是否批量</label>
						<div class="layui-input-block">
							<input type="radio" name="feedback.docIsBatch" value="1" title="是">
							<input type="radio" name="feedback.docIsBatch" value="0" title="否">
							<input type="radio" name="feedback.docIsBatch" value="3" title="全部" checked="">
						</div>
						<!-- <div class="layui-form-mid layui-word-aux">备注：整车3台、零部件5件及以上、电池日产3%以上为批量</div> -->
					</div>
				</div>
				<!-- <div class="layui-form-item">
					<label class="layui-form-label">责任单位</label>
					<div class="layui-input-block">
						<input name="" placeholder="请输入整数" autocomplete="off" class="layui-input">
					</div>
				</div>	
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">反馈人</label>
						<div class="layui-input-block">
							<input name="" placeholder="请输入整数" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-inline">
						<label class="layui-form-label">反馈时间</label>
						<div class="layui-input-block">
							<input name="" placeholder="请输入整数" autocomplete="off" class="layui-input">
						</div>
					</div>
				</div>	
				<div class="layui-form-item">
					<div class="layui-inline">
    					<label class="layui-form-label">状态</label>
						<div class="layui-input-block">
							<input type="checkbox" name="" lay-skin="primary" title="全部" value="">
							<input type="checkbox" name="" lay-skin="primary" title="无需处理" value="">
							<input type="checkbox" name="" lay-skin="primary" title="考核通报" value="">
							<input type="checkbox" name="" lay-skin="primary" title="限期整改" value="">
						</div>
					</div>
				</div> -->
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button type="button" class="layui-btn" onclick="buildTable()">立即查询</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
			</form>
			
			<div class="larry-personal-body clearfix">
				<table class="layui-hide" id="tab" lay-data="{id: 'tabId'}"></table>
			</div>
		</div>
	</div>
	
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/layui.js"></script>
	<script>
	layui.use(['jquery', 'layer', 'form', 'element', 'laydate'], function(){
		var layer = layui.layer
		,form = layui.form
		,laydate = layui.laydate
		,element = layui.element
		,$ = layui.$
		,table = layui.table

		//日期范围
		laydate.render({
		  elem: '#date'
		  ,range: true
		});
		
		//产品类别
		$.post("productTypeAction_findProductTypeList", null, function(data){
			var str = "";
			$.each(data.productTypeList, function(i, v){
				str += "<option value='" + v.pdtId + "'>" + v.pdtName + "</option>";
			});
			$("select[name='feedback.productType.pdtId']").append(str);
			form.render();
		}, "json");
	});

	
	
	//生成表格
	function buildTable() {
		//alert($("input[name='feedback.docFindDate']").val());
		layui.use('table', function(){
			  var table = layui.table;
			  
			  table.render({
			    elem: '#tab'
				,url:'feedbackAction_findLikeFeedbackList?' + $("form:first").serialize()
			    ,cols: [[
			    	   {type:'numbers', title: '序号', fixed: 'left'}
				      ,{field:'docId', title: 'ID', sort: true}
				      ,{field:'docTheme', title: '主题'}
				      ,{field:'docFindDate', title: '发现时间'}
				      ,{field:'docFindAddr', title: '发现地点'}
				      ,{field:'section', title: 'OO' ,  templet: '<div>{{d.section.department.company.compName}}</div>'}
				      ,{field:'section', title: 'OO' ,  templet: '<div>{{d.section.department.deptName}}</div>'}
				      ,{field:'section', title: 'OO' ,  templet: '<div>{{d.section.sectName}}</div>'}
			    ]]
			  });
			});
	}
	
	
	</script>
</body>
</html>