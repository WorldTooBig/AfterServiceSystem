<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
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
				<span>考核通报</span>
			</header>
			<div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
					<ul class="layui-tab-title">
						<li class="layui-this">考核通报</li>
						<li>归档处理</li>
						<li>异常反馈单</li>
					</ul>
					<div class="layui-tab-content">
						<div class="layui-tab-item layui-show">
							<form class="layui-form" action="notifiedAction_addNotified" method="post">
								<input type="hidden" name="placeFile.plaId" value="${placeFile.plaId }">
								<input type="hidden" name="process.proId" value="6">
								<div class="layui-form-item">
									<label class="layui-form-label">问题类别</label>
									<div class="layui-input-block" id="problemType">
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">是否引发售后</label>
									<div class="layui-input-block">
										<input type="radio" name="notified.notIsSafeAfter" value="1" title="是" checked="">
										<input type="radio" name="notified.notIsSafeAfter" value="0" title="否">
									</div>
								</div>
								<div class="layui-form-item layui-form-text">
									<label class="layui-form-label">原因初步分析</label>
									<div class="layui-input-block">
										<textarea name="notified.notCauseAnalysis" placeholder="请输入" class="layui-textarea"></textarea>
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">责任单位</label>
									<div class="layui-input-block" id="dutyUnit">
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">对责任单位的考核情况</label>
									<div class="layui-input-block" id="appraise">
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">责任单位限期整改日期</label>
									<div class="layui-input-block">
										<input id="date" name="notified.notEndDate" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
									</div>
								</div>
								<div class="layui-form-item">
										<label class="layui-form-label">收件人</label>
										<div class="layui-input-block" style="min-height:38px;">
											<div class="layui-input-inline">
												<input id="addrUserText" placeholder="请输入outlook邮箱" autocomplete="off" class="layui-input">
											</div>
											<div class="layui-form-mid layui-word-aux">@zhyle.com</div>
											<div class="layui-input-inline">
											<button type="button" class="layui-btn layui-btn-primary" id="addrUserBtn">添加</button>
											</div>
										</div>
										<div class="layui-input-block" id="addrUser" style="font-size: 18px;">
										</div>
								</div>
								<div class="layui-form-item">
										<label class="layui-form-label">抄送</label>
										<div class="layui-input-block" style="min-height:38px;">
											<div class="layui-input-inline">
												<input id="copyUserText" placeholder="请输入outlook邮箱" autocomplete="off" class="layui-input">
											</div>
											<div class="layui-form-mid layui-word-aux">@zhyle.com</div>
											<div class="layui-input-inline">
											<button type="button" class="layui-btn layui-btn-primary" id="copyUserBtn">添加</button>
											</div>
										</div>
										<div class="layui-input-block" id="copyUser" style="font-size: 18px;">
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
						<div class="layui-tab-item">
							<div class="layui-form">
								<div class="layui-form-item">
									<label class="layui-form-label">异常处理类型</label>
									<div class="layui-input-block">
										考核通报
									</div>
								</div>	
								<div class="layui-form-item">
									<div class="layui-inline">
										<label class="layui-form-label">问题类别</label>
										<div class="layui-input-block" id="problemType">
											<s:iterator value="%{placeFile.ptSet}" status="i">
												${i.count }${pbtName }
											</s:iterator>
										</div>
									</div>	
									<div class="layui-inline">
										<label class="layui-form-label">问题大类</label>
										<div class="layui-input-block">
											${placeFile.plaBigCategory }
										</div>
									</div>
								</div>	
								<div class="layui-form-item">
									<div class="layui-inline">
										<label class="layui-form-label">是否试制把关失效</label>
										<div class="layui-input-inline">
											${placeFile.plaIsTrialControl == 1 ? '是' : '否' }
										</div>
									</div>
									<div class="layui-inline">
										<label class="layui-form-label">是否批量</label>
										<div class="layui-input-inline">
											${placeFile.feedback.docIsBatch == 1 ? '是' : '否' }
										</div>
									</div>
									<div class="layui-inline">
										<label class="layui-form-label" style="width: 160px;">是否有引发售后投诉的隐患</label>
										<div class="layui-input-inline">
											${placeFile.plaIsSafeAfterRisk == 1 ? '是' : '否' }
										</div>
									</div>
								</div>	
								<div class="layui-form-item">
									<label class="layui-form-label">责任单位</label>
									<div class="layui-input-block">
										<s:iterator value="#feePr.feedback.appSet" status="i">
											${i.count }-${department.deptName }
										</s:iterator>
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">缺陷类别</label>
									<div class="layui-input-block">
											${placeFile.plaAbnormalType }
									</div>
								</div>
								<div class="layui-form-item">
									<div class="layui-inline">
										<label class="layui-form-label">是否首检失效</label>
										<div class="layui-input-inline">
											${placeFile.plaIsFirstCheckLose == 1 ? '是' : '否' }
										</div>
									</div>
									<div class="layui-inline">
										<label class="layui-form-label">是否重复一个月发生</label>
										<div class="layui-input-inline">
											${placeFile.plaMouthLoopCount == 0 ? '否' : '是' }
										</div>
									</div>
									<div class="layui-inline">
										<label class="layui-form-label">第几次重复发生</label>
										<div class="layui-input-inline">
											${placeFile.plaMouthLoopCount }
										</div>
									</div>
								</div>
								<div class="layui-form-item layui-form-text">
									<label class="layui-form-label">根本原因分析</label>
									<div class="layui-input-block">
											${placeFile.plaCauseAnalysis }
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">原因大类</label>
									<div class="layui-input-block">
											${placeFile.plaBigReason }
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">原因小类</label>
									<div class="layui-input-block">
											${placeFile.plaSmallReason }
									</div>
								</div>
								<div class="layui-form-item">
									<div class="layui-inline">
										<label class="layui-form-label" style="width: 160px;">是否涉及厂内或外仓产品处理</label>
										<div class="layui-input-inline">
											${placeFile.plaIsInvolveHandle == 1 ? '是' : '否' }
										</div>
									</div>
								</div>
								<div class="layui-form-item layui-form-text">
									<label class="layui-form-label">应急解决方案</label>
									<div class="layui-input-block">
											${placeFile.plaEmergencyPlan }
									</div>
								</div>
							</div>
				
						</div>
						<div class="layui-tab-item">
							<div class="layui-form">
							
								<input type="hidden" name="process.proId" value="2">
								<div class="layui-form-item">
									<div class="layui-inline">
										<label class="layui-form-label">编号</label>
										<div class="layui-input-inline">
											${placeFile.feedback.docId }
										</div>
									</div>
									<div class="layui-inline">
										<label class="layui-form-label">反馈科室</label>
										<div class="layui-input-inline">
											${feePr.user.section.sectName }
										</div>
									</div>	
									<div class="layui-inline">
										<label class="layui-form-label">反馈人</label>
										<div class="layui-input-inline">
											${feePr.user.userName }
										</div>
									</div>	
									<div class="layui-inline">
										<label class="layui-form-label">反馈时间</label>
										<div class="layui-input-inline">
											${feePr.preDate }
										</div>
									</div>	
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">主题</label>
									<div class="layui-input-block">
										${placeFile.feedback.docTheme }
									</div>
								</div>	
								<div class="layui-form-item">
									<label class="layui-form-label">附件</label>
									<div class="layui-input-block">
										<input type="file" name="">
									</div>
								</div>
								<div class="layui-form-item">
									<div class="layui-inline">
										<label class="layui-form-label">发现时间</label>
										<div class="layui-input-inline">
											${placeFile.feedback.docFindDate }
										</div>
									</div>
									<div class="layui-inline">
										<label class="layui-form-label">发现地点</label>
										<div class="layui-input-inline">
											${placeFile.feedback.docFindAddr }
										</div>
									</div>	
								</div>
								<div class="layui-form-item">
									<div class="layui-inline">
										<label class="layui-form-label">客户名称</label>
										<div class="layui-input-inline">
											${placeFile.feedback.docCustName }
										</div>
									</div>	
									<div class="layui-inline">
										<label class="layui-form-label">产品类别</label>
										<div class="layui-input-inline">
											${placeFile.feedback.productType.pdtName }
										</div>
									</div>	
									<div class="layui-inline">
										<label class="layui-form-label">产品型号</label>
										<div class="layui-input-inline">
											${placeFile.feedback.docProMode }
										</div>
									</div>	
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">订单号</label>
									<div class="layui-input-block">
											${placeFile.feedback.docOrderNum }
									</div>
								</div>	
								<div class="layui-form-item">
									<div class="layui-inline">
										<label class="layui-form-label">生产单位</label>
										<div class="layui-input-inline">
											${placeFile.feedback.docProDep }
										</div>
									</div>	
									<div class="layui-inline">
										<label class="layui-form-label">生产班组</label>
										<div class="layui-input-inline">
											${placeFile.feedback.docProTeam }
										</div>
									</div>	
									<div class="layui-inline">
										<label class="layui-form-label">责任工序岗位</label>
										<div class="layui-input-inline">
											${placeFile.feedback.docResStation }
										</div>
									</div>	
								</div>
								<div class="layui-form-item">
									<div class="layui-inline">
										<label class="layui-form-label">物料编码</label>
										<div class="layui-input-inline">
											${placeFile.feedback.docItemNum }
										</div>
									</div>	
									<div class="layui-inline">
										<label class="layui-form-label">物料名称</label>
										<div class="layui-input-inline">
											${placeFile.feedback.docItemName }
										</div>
									</div>	
									<div class="layui-inline">
										<label class="layui-form-label">物料类型</label>
										<div class="layui-input-inline">
											${placeFile.feedback.docItemType }
										</div>
									</div>	
									<div class="layui-inline">
										<label class="layui-form-label">供应商</label>
										<div class="layui-input-inline">
											${placeFile.feedback.docSupName }
										</div>
									</div>	
								</div>
								<div class="layui-form-item">
									<div class="layui-inline">
				    					<label class="layui-form-label">是否停线</label>
										<div class="layui-input-inline">
											${placeFile.feedback.docIsStopLine == 1 ? '是' : '否' }
										</div>
									</div>
									<div class="layui-inline">
										<label class="layui-form-label">停线工时损失</label>
										<div class="layui-input-inline">
											${placeFile.feedback.docLoss }
										</div>
									</div>
									<div class="layui-inline">
										<label class="layui-form-label">不合格等级</label>
										<div class="layui-input-inline">
											${placeFile.feedback.docSeverityLevel }
										</div>	
									</div>	
								</div>
								<div class="layui-form-item">
									<div class="layui-inline">
										<label class="layui-form-label">使用数量</label>
										<div class="layui-input-inline">
											${placeFile.feedback.docUsedCounts }
										</div>
									</div>
									<div class="layui-inline">
										<label class="layui-form-label">不良品数量</label>
										<div class="layui-input-inline">
											${placeFile.feedback.docDefproCounts }
										</div>
									</div>
									<div class="layui-inline">
										<label class="layui-form-label">发现异常单位</label>
										<div class="layui-input-inline">
											${placeFile.feedback.docFindDep }
										</div>	
									</div>
								</div>
								<div class="layui-form-item">
									<div class="layui-inline">
										<label class="layui-form-label">是否批量</label>
										<div class="layui-input-inline">
											${placeFile.feedback.docIsBatch == 1 ? '是' : '否' }
										</div>
										<div class="layui-form-mid layui-word-aux">备注：整车3台、零部件5件及以上、电池日产3%以上为批量</div>
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">责任单位</label>
									<div class="layui-input-block">
										<s:iterator value="#feePr.feedback.appSet" status="i">
											${i.count }-${department.deptName }
										</s:iterator>
									</div>
								</div>
								<div class="layui-form-item layui-form-text">
									<label class="layui-form-label">异常描述</label>
									<div class="layui-input-block">
										${placeFile.feedback.docDescribe }
									</div>
								</div>
							</div>
			
						</div>
					</div>
				</div>
			
			
		</div>
	</div>

	
	<script type="text/javascript" src="${pageContext.request.contextPath}/layui.js"></script>
	<script>
	layui.use(['jquery', 'laydate', 'form', 'table', 'element'], function(){
		var laydate = layui.laydate
		,form = layui.form
		,table = layui.table
		,element = layui.element
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
				str += "<input type='checkbox' lay-skin='primary' title='" + v.pbtName + "' value='" + v.pbtName + "'>";
			});
			$("#problemType").append(str);
			form.render();
		}, "json");
		
		//责任单位
		$.post("placeFileAction_findPlacefileById", "placeFile.plaId=${placeFile.plaId }", function(data){
			var str1 = "";
			var str2 = "";
			$.each(data.placeFile.feedback.appSet, function(i, v){
				str1 += '<input type="checkbox" title="' + v.department.deptName + '" value="' + v.department.deptId + '" checked>';
				str2 += appraiseHtml(i, v.department.deptId, v.department.deptName);
			});
			$("#dutyUnit").append(str1);
			$("#appraise").append(str2);
			form.render();
			$("#appraise label").css("width", "auto");
		}, "json");
		
		//对责任单位的考核情况
		function appraiseHtml(i,id,name) {
			return '<div class="layui-form-item"><input type="hidden" name="appraiseList[' + i + '].department.deptId" value="' + id + '"><div class="layui-inline"><label class="layui-form-label">责任单位</label><div class="layui-input-inline">' + 
			'<input value="' + name + '" disabled lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input"></div></div><div class="layui-inline"><label class="layui-form-label">责任人</label><div class="layui-input-inline">' + 
			'<input name="appraiseList[' + i + '].appDutyName" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input"></div></div><div class="layui-inline"><label class="layui-form-label">扣分</label><div class="layui-input-inline">' + 
			'<input name="appraiseList[' + i + '].appDeduct" value="0" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input"></div></div><div class="layui-inline"><label class="layui-form-label">通报批评</label><div class="layui-input-inline" style="width:60px">' + 
			'<input name="appraiseList[' + i + '].appIsCriticism" type="checkbox" lay-skin="switch" lay-text="ON|OFF" value="1"></div></div><div class="layui-inline"><label class="layui-form-label">备注</label><div class="layui-input-inline">' +
			'<input name="appraiseList[' + i + '].appRemark" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input"></div></div></div>';
		}
		

		// 收件人与抄送 人员列表
		$.post("userAction_findUserByDepartment", "", function(data) {
			var str1 = "";
			var str2 = "";
			$.each(data.userList, function(i, v) {
				str1 += '<input type="checkbox" name="addrList[' + i + '].userId" title="' + v.userRealName + '" value="' + v.userId + '" data-email="' + v.userEmail + '">'; 
				str2 += '<input type="checkbox" name="copyList[' + i + '].userId" title="' + v.userRealName + '" value="' + v.userId + '" data-email="' + v.userEmail + '">';  
			});
			$("#addrUser").append(str1);
			$("#copyUser").append(str2);
			form.render();
		}, "json");
		

		// 添加收件人邮箱
		$("#addrUserBtn").click(function() {
			var $addrs = $("#addrUser input:checkbox");	// 获取收件人列表中的所有复选框
			var email = $("#addrUserText").val();		// 获得输入框中的值，即邮箱头
			if (email == "") 							// 如果输入框中的值为空则结束
				return;
			email += "@zhyle.com";					// 获得完整邮箱名
			var isHave = false;							// 用来判断该邮箱是否已经在收件人列表
			for (var i = 0; i < $addrs.length; i++) {	// 遍历所有复选框
				var $addr = $addrs.eq(i);				// 单独获取每一个复选框
				if($addr.attr("data-email") == email || $addr.attr("title") == email) {		// 如果该复选框的邮箱==输入框中的邮箱
					$addr.prop("checked", true);		// 则让该复选框为选中状态
					isHave = true;						// 改变改值
					break;								// 跳出循环
				}
			}
			if(isHave == false) {						// 如果所有复选框中的邮箱都!=输入框中的邮箱，则添加一个该邮箱的复选框，且为选中状态
				var str = "<input type='checkbox' name='feedback.docAddrEmail' title='" + email + "' value='" + email + "' data-email='" + email + "' checked=true>";
				$("#addrUser").append(str);
			}
			form.render();
			$("#addrUserText").val("");					// 清空输入框
		});
		
		
		// 添加抄送邮箱
		$("#copyUserBtn").click(function() {
			var $addrs = $("#copyUser input:checkbox");
			var email = $("#copyUserText").val();
			if (email == "") 
				return;
			email += "@zhyle.com";
			var isHave = false;
			for (var i = 0; i < $addrs.length; i++) {
				var $addr = $addrs.eq(i);
				if($addr.attr("data-email") == email || $addr.attr("title") == email) {
					$addr.prop("checked", true);
					isHave = true;
					break;
				}
			}
			if(isHave == false) {
				var str = "<input type='checkbox' name='feedback.docCopyEmail' title='" + email + "' value='" + email + "' data-email='" + email + "' checked=true>";
				$("#copyUser").append(str);
			}
			form.render();
			$("#copyUserText").val("");
		});
		
		
		
		
		form.render();
		
	});
		
	function sub() {
		var $addrEmails = $("#addrUser :checkbox:checked");
		var $copyEmails = $("#copyUser :checkbox:checked");
		var str1 = "<input type='hidden' name='' value='' >";
		var str = "";
		for (var i = 0; i < $addrEmails.length; i++) {
			str += "<input type='hidden' name='addrEmails' value='" + $addrEmails.eq(i).attr("data-email") + "'>";
		}
		for (var i = 0; i < $copyEmails.length; i++) {
			str += "<input type='hidden' name='copyEmails' value='" + $copyEmails.eq(i).attr("data-email") + "'>";
		}
		$("form").append(str);
		//alert($("form input[name='addrEmails']").serialize() + $("form input[name='copyEmails']").serialize());
		//$("form").submit();
		return true;
	}
	</script>

</body>
</html>