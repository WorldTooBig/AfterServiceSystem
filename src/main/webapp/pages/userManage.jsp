<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
</head>
<body>

<div style="width:100%; float:left;">
	<div style="width:33%; float:left;">
		<h2>添加公司</h2>
		<form action="companyAction_addCompany" method="post" onsubmit="return validCompany(this)">
			公司名称：<input name="company.compName" /><br />
			<button>添加</button>
		</form>
	</div>
	<div style="width:33%; float:left;">
		<h2>添加部门</h2>
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
	<div style="width:33%; float:left;">
		<h2>添加科室</h2>
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
	<br/>
	<hr />
	<ul>
	<s:iterator var="comps" value="#session.compList">
		<li>${comps.compName } --- <input type="button" value="查看部门" onclick="selectDepartmentList(${comps.compId})" /></li>
	</s:iterator>
	</ul>
	
	
	
</body>
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
			$("body").append(createDiv(str));
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
			$("body").append(createDiv(str));
		}, "json");
	}
	
	//查看员工
	function selectEmpList(sectId) {
		$.post("userAction_findUserBySectId", "section.sectId=" + sectId, function(data) {
			var str = "<table>";
			str += "<tr><th>序号</th><th>用户名</th><th>密码</th><th>真实名</th><th>工号</th><th>职务</th><th>电话</th><th>邮箱</th><th>备注</th></tr>";
			$.each(data.userList, function(i, v) {
				str += "<tr>";
				strs += "<td>" + v.userName + "</td>";
				strs += "<td>" + v.userPwd + "</td>";
				strs += "<td>" + v.userRealName + "</td>";
				strs += "<td>" + v.userJobNum + "</td>";
				strs += "<td>" + v.userJobName + "</td>";
				strs += "<td>" + v.userTell + "</td>";
				strs += "<td>" + v.userEmail + "</td>";
				strs += "<td>" + v.userRemark + "</td>";
				str += "</tr>";
			});
			str += "</table>";
			$("body").append(createDiv(str));
		}, "json");
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
	 
</script>
</html>