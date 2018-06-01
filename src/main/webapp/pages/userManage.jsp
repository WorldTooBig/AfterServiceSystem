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
</head>
<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">

		<%@include file="navbar.jsp" %>

		
		<div class="layui-body">
			<!-- 内容主体区域 -->
			<div style="padding: 15px;">内容主体区域</div>
				<fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
					<legend>简洁风格的Tab</legend>
				</fieldset>
				 
				<div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
				  <ul class="layui-tab-title">
				    <li class="layui-this">查看公司</li>
				    <li>添加公司</li>
				    <li>添加部门</li>
				    <li>添加科室</li>
				  </ul>
				  <div class="layui-tab-content" style="height: 100px;">
				    <div class="layui-tab-item layui-show">
				    	<ul>
						<s:iterator var="comps" value="#session.compList">
							<li>${comps.compName } --- <input type="button" value="查看部门" onclick="selectDepartmentList(${comps.compId})" /></li>
						</s:iterator>
						</ul>
				    </div>
				    <div class="layui-tab-item">
						<form action="companyAction_addCompany" method="post" onsubmit="return validCompany(this)">
							公司名称：<input name="company.compName" /><br />
							<button>添加</button>
						</form>
				    </div>
				    <div class="layui-tab-item">
						<form action="departmentAction_addDepartment" method="post" onsubmit="return validDepartment(this)">
							部门名称: <input name="department.deptName" /><br />
							所属公司:
							<select name="company.compId">
								<option value="0">--请选择--</option>
							<s:iterator var="comp" value="#session.compList">
								<option value="${comp.compId }">${comp.compName }</option>
							</s:iterator>
							</select><br />
							<button>添加</button>
						</form>
				    </div>
				    <div class="layui-tab-item">
						<form action="sectionAction_addSection" method="post" onsubmit="return validSection(this)">
							科室名称: <input name="section.sectName" /><br />
							所属公司:
							<select onchange="findDepartmentList(event)">
								<option value="0">--请选择--</option>
							<s:iterator var="comp" value="#session.compList">
								<option value="${comp.compId }">${comp.compName }</option>
							</s:iterator>
							</select><br />
							所属部门: 
							<select name="department.deptId">
								<option value="0">--请选择--</option>
							</select><br />
							<button>添加</button>
						</form>
				    </div>
				  </div>
				</div> 
		
		</div>
		
		<div class="layui-footer">
	    	<!-- 底部固定区域 -->
	    	© layui.com - 底部固定区域
		</div>
	</div>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/layui.all.js"></script>
	<script>
	
	//获取部门
	function findDepartmentList(e) {
		$.post("departmentAction_findDepartmentList", "company.compId=" + e.target.value, function(data) {
			var str = "";
			$.each(data.list, function(i, v) {
				str += "<option value='" + v.deptId + "'>" + v.deptName + "</option>";
			});
			$("select[name='department.deptId']").eq(0).append(str);
		}, "json");
	}
	
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
	
	//验证
	/**
	 *  添加公司
	          添加部门
	          添加科室
	 * 
	 */
	 function validCompany(form) {
		var compName = $(form).children("input[name='company.compName']").val();
		if (compName == "") {
			alert("公司名称不能为空！");
			return false;
		} else if (compName.length  > 16) {
			alert("公司名称太长！");
			return false;
		}
		return true;
	}
	
	function validDepartment(form) {
		var deptName = $(form).children("input[name='department.deptName']").val();
		var compId = $(form).children("select[name='company.compId']").val();
		if (deptName == "") {
			alert("部门名称不能为空！");
			return false;
		} else if (deptName.length > 16) {
			alert("部门名称太长！");
			return false;
		} else if (compId == 0) {
			alert("请选择所属公司!");
			return false;
		}
		return true;
	}
	
	function validSection(form) {
		var sectName = $(from).children("input[name='department.deptName']").val();
		var compId = $(form).children("select:first").val();
		var deptId = $(form).children("select[name='department.deptId']").val();
		if (sectName == "") {
			alert("科室名称不能为空！");
			return false;
		} else if (sectName.length > 16) {
			alert("科室名称太长!");
			return false;
		} else if (compId == 0) {
			alert("请选择所属公司！");
			return false;
		} else if (deptId == 0) {
			alert("请选择所属部门！");
			return false;
		}
		return true;
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
