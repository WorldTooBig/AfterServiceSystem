<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<title>Insert title here</title>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/layui.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/global.css" media="all">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/personal.css" media="all">
</head>
<body>
	<div class="larry-wrapper">
		<div class="larry-personal">
			<header class="larry-personal-tit">
				<span>公司部门管理</span>
			</header>
			
			<div class="larry-personal-body clearfix">

			<!-- 内容主体区域 -->
			<!-- <div style="padding: 15px;">内容主体区域</div> -->
				<fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
					<legend>公司部门管理</legend>
				</fieldset>
				 
				<div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
				  <ul class="layui-tab-title">
				    <li class="layui-this">查看公司</li>
				    <li>添加公司</li>
				    <li>添加部门</li>
				    <li>添加科室</li>
				  </ul>
				  <div class="layui-tab-content" style="height: 100px;">
				    <!-- 查看公司 -->
				    <div class="layui-tab-item layui-show">
				    	<ul>
						<s:iterator var="comps" value="#session.compList">
							<li>${comps.compName } --- <input type="button" value="查看部门" onclick="selectDepartmentList(${comps.compId})" /></li>
						</s:iterator>
						</ul>
				    </div>
				    <!-- 添加公司 -->
				    <div class="layui-tab-item">
						<form class="layui-form" action="companyAction_addCompany" method="post">
							<div class="layui-form-item">
								<label class="layui-form-label">公司名称</label>
								<div class="layui-input-block">
									<input name="company.compName" lay-verify="required" autocomplete="off" placeholder="请输入标题" class="layui-input" />
								</div>
							</div>	
							<!-- 按钮 -->
							<div class="layui-form-item">
								<div  class="layui-input-block">
									<div style="width: 216px; margin: 0;">
										<button lay-submit class="layui-btn layui-btn-fluid">添加</button>
									</div>
								</div>
							</div>
						</form>
				    </div>
				    <!-- 添加部门 -->
				    <div class="layui-tab-item">
						<form class="layui-form" action="departmentAction_addDepartment" method="post">
							<div class="layui-form-item">
								<label class="layui-form-label">部门名称</label>
								<div class="layui-input-block">
									<input type="text" name="department.deptName" lay-verify="required" autocomplete="off" placeholder="请输入标题" class="layui-input">
								</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">所属公司</label>
								<div class="layui-input-block">
									<select name="company.compId" lay-filter="aihao" lay-verify="number">
										<option value="">--请选择--</option>
									</select>
								</div>
							</div>
							<!-- 按钮 -->
							<div class="layui-form-item">
								<div  class="layui-input-block">
									<div style="width: 216px; margin: 0;">
										<button lay-submit class="layui-btn layui-btn-fluid">添加</button>
									</div>
								</div>
							</div>
						</form>
				    </div>
				    <!-- 添加科室 -->
				    <div class="layui-tab-item">
						<form class="layui-form" action="sectionAction_addSection" method="post">
							<div class="layui-form-item">
								<label class="layui-form-label">科室名称</label>
								<div class="layui-input-block">
									<input type="text" name="section.sectName" lay-verify="required" autocomplete="off" placeholder="请输入标题" class="layui-input">
								</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">所属公司</label>
								<div class="layui-input-block">
									<select lay-filter="findDepartmentList" lay-verify="number">
										<option value="">--请选择--</option>
									</select>
								</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">所属部门</label>
								<div class="layui-input-block">
									<select name="department.deptId" lay-filter="aihao" lay-verify="number">
										<option value="">--请选择--</option>
									</select>
								</div>
							</div>
							<!-- 按钮 -->
							<div class="layui-form-item">
								<div  class="layui-input-block">
									<div style="width: 216px; margin: 0;">
										<button lay-submit class="layui-btn layui-btn-fluid">添加</button>
									</div>
								</div>
							</div>
						</form>
				    </div>
				  </div>
				</div> 
		
	</div>
	</div>
	</div>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/layui.js"></script>
	<script>
	layui.use(['jquery', 'layer', 'form', 'element'], function(){
		var layer = layui.layer
		,form = layui.form
		,element = layui.element
		,$ = layui.$

		$.post("companyAction_findCompanyListJson", "", function(data) {
			var str = "";
			$.each(data.list, function(i, v) {
				str += "<option value='" + v.compId + "'>" + v.compName + "</option>";
			});
			$("select[name='company.compId'],select[lay-filter='findDepartmentList']").append(str);
			form.render();
		}, "json");
		
		//获取部门
		form.on('select(findDepartmentList)', function(data){
			$.post("departmentAction_findDepartmentList", "company.compId=" + data.elem.value, function(data) {
				$("select[name='department.deptId'] option:not(:first)").remove();
				var str = "";
				$.each(data.list, function(i, v) {
					str += "<option value='" + v.deptId + "'>" + v.deptName + "</option>";
				});
				$("select[name='department.deptId']").append(str);
				form.render();
			}, "json");
		});   
		
		//下拉框选择验证
		
		  
	});
	
	//查看部门 
	function selectDepartmentList(compId) {
		$.post("departmentAction_findDepartmentList", "company.compId=" + compId, function(data) {
			var str = "<ul>";
			$.each(data.list, function(i, v) {
				str += "<li>" + v.deptName + " --- <input type='button' value='查看科室' onclick='selectSectionList(" + v.deptId + ")' /></li>";
			});
			str += "</ul>";
			layerOpen(str);
			//$("body").append(createDiv(str));
		}, "json");
	}
	
	//查看科室
	function selectSectionList(deptId) {
		$.post("sectionAction_findSectionList", "department.deptId=" + deptId, function(data) {
			var str = "<ul>";
			$.each(data.list, function(i, v) {
				str += "<li>" + v.sectName + " --- <input type='button' value='查看员工 ' onclick='selectEmpList(" + v.sectId + ")'/></li>";
			});
			str += "</ul>";
			layerOpen(str);
			//$("body").append(createDiv(str));
		}, "json");
	}
	
	//查看员工
	function selectEmpList(sectId) {
		var str = '<table class="layui-hide" id="test"></table>';
			layerOpen(str);
			layuiTabel(sectId);
			//$("body").append(createDiv(str));
	}
	
	//生成DIV
	function createDiv(str) {
		var div = '<div style="position: fixed; top: 0; left: 0; width: 100%; height: 100%; background-color: white;">' + 
		'<div style="position: relative; width:2%; height:5%; left:98%; border: solid 1px black;" onclick="dropDiv(event)">X</div>' +
		'<div>' + str + '</div></div>';
		return div;
	}
	
	//点击X删除该div
	function dropDiv(e) {
		$(e.target).parent().remove();
	}
	
	 
	//tab层
	function layerTab() {
		layer.tab({
		  area: ['600px', '300px'],
		  tab: [{
		    title: 'TAB1', 
		    content: '内容1'
		  }, {
		    title: 'TAB2', 
		    content: '内容2'
		  }, {
		    title: 'TAB3', 
		    content: '内容3'
		  }]
		});
	}
	
	//页面层
	function layerOpen(str) {
		layer.open({
		  type: 1,
		  skin: 'layui-layer-rim', //加上边框
		  area: ['720px', '480px'], //宽高
		  content: str
		});
	}
	
	//分页表格
	function layuiTabel(sectId) {
	layui.use('table', function(){
		  var table = layui.table;
		  
		  table.render({
		    elem: '#test'
		    ,url:'userAction_findUserBySectIdLayui?section.sectId=' + sectId
		    ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
		    ,cols: [[
		      {field:'userId', width:80, title: 'ID', sort: true}
		      ,{field:'userName', width:80, title: '用户名'}
		      ,{field:'userPwd', width:80, title: '密码'}
		      ,{field:'userRealName', width:80, title: '真实姓名'}
		      ,{field:'userJobNum', width:80, title: '工号'}
		      ,{field:'userJobName', width:80, title: '职务'}
		      ,{field:'userTell', width:80, title: '电话'}
		      ,{field:'userEmail', width:80, title: '邮箱'}
		      ,{field:'userRemark', width:80, title: '备注'}
		    ]]
		  });
		});
	}
</script>
</body>
</html>
