<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="placeFile.viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
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
				<span>考核结论</span>
			</header>
			<div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
					<ul class="layui-tab-title">
						<li class="layui-this">考核结论</li>
						<li>责任单位答复</li>
						<li>考核通报</li>
						<li>归档处理</li>
						<li>异常反馈单</li>
					</ul>
					<div class="layui-tab-content">
						<div class="layui-tab-item layui-show">
							<form class="layui-form" action="conclusionAction_addConclusion" method="post">
								<input type="hidden" name="notified.notId" value="${notified.notId }">
								<input type="hidden" name="process.proId" value="10">
								<div class="layui-form-item">
									<label class="layui-form-label">问题类别</label>
									<div class="layui-input-block" id="problemType">
									</div>
								</div>	
								<div class="layui-form-item layui-form-text">
									<label class="layui-form-label">预防措施确认</label>
									<div class="layui-input-block">
										<textarea name="conclusion.conCorrectionMethodConfirm" placeholder="请输入" class="layui-textarea"></textarea>
									</div>
								</div>
								<div class="layui-form-item layui-form-text">
									<label class="layui-form-label">考核结论</label>
									<div class="layui-input-block">
										<textarea name="conclusion.conAssessmentConclusion" placeholder="请输入" class="layui-textarea"></textarea>
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">责任单位</label>
									<div class="layui-input-block" id="appraise">
										
									</div>
								</div>
								<div class="layui-form-item">
									<div class="layui-input-block">
										<button lay-submit class="layui-btn">保存并发送</button>
										<button type="reset" class="layui-btn layui-btn-primary">重置</button>
									</div>
								</div>
							</form>
						</div>
						<div class="layui-tab-item">
						
							<div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
								<ul class="layui-tab-title">
									<s:iterator value="#feePr.feedback.appSet" status="i">
										<s:if test="#i.isFirst"><li class="layui-this">${department.deptName }</li></s:if>
										<s:else><li>${department.deptName }</li></s:else>
									</s:iterator>
								</ul>
								<div class="layui-tab-content">
									<s:iterator value="%{replyList}" status="i">
										<s:if test="#i.isFirst"><div class="layui-tab-item layui-show"></s:if>
										<s:else><div class="layui-tab-item"></s:else>
										
											<div class="layui-form-item">
												<label class="layui-form-label">责任单位</label>
												<div class="layui-input-block">
													${department.deptName }
												</div>
											</div>
											<div class="layui-form-item">
												<label class="layui-form-label">原因分析</label>
												<div class="layui-input-block">
													${repCauseAnalysis }
												</div>
											</div>
											<div class="layui-form-item">
												<label class="layui-form-label">纠正预防措施</label>
												<div class="layui-input-block">
													${repCorrectionMethod }
												</div>
											</div>
											<div class="layui-form-item">
												<label class="layui-form-label">纠正落实报告</label>
												<div class="layui-input-block">
													<s:iterator var="er" value="%{erList}" status="i">
														${er.etrCorrectionProject },${er.etrDescription },${er.etrFileNo }<br>
													</s:iterator>
												</div>
											</div>
											<div class="layui-form-item">
												<label class="layui-form-label">答复人</label>
												<div class="layui-input-block">
													<s:iterator value="#repPr">
														<s:if test="user.section.department.deptId == department.deptId">${user.userName },${preDate }</s:if>
													</s:iterator>
												</div>
											</div>
											<div class="layui-form-item">
												<label class="layui-form-label">审核人</label>
												<div class="layui-input-block">
													<s:iterator value="#repEx1">
														<s:if test="user.section.department.deptId == department.deptId">${user.userName },${preDate }</s:if>
													</s:iterator>
												</div>
											</div>
											<div class="layui-form-item">
												<label class="layui-form-label">审批人</label>
												<div class="layui-input-block">
													<s:iterator value="#repEx2">
														<s:if test="user.section.department.deptId == department.deptId">${user.userName },${preDate }</s:if>
													</s:iterator>
												</div>
											</div>
										
										</div>
									</s:iterator>
								</div>
							</div>
						
							
						</div>
						<div class="layui-tab-item">
							<div class="layui-form">
								<div class="layui-form-item">
									<label class="layui-form-label">问题类别</label>
									<div class="layui-input-block" id="problemType">
											<s:iterator value="%{notified.placeFile.ptSet}" status="i">
												${i.count }${pbtName }
											</s:iterator>
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">是否引发售后</label>
									<div class="layui-input-block">
										${notified.notIsSafeAfter == 1 ? '是' : '否' }
									</div>
								</div>
								<div class="layui-form-item layui-form-text">
									<label class="layui-form-label">原因初步分析</label>
									<div class="layui-input-block">
										${notified.notCauseAnalysis }
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
									<label class="layui-form-label">对责任单位的考核情况</label>
									<div class="layui-input-block">
										<s:iterator var="app" value="%{notified.placeFile.feedback.appSet}" status="i">
											${i.count}=${app.department.deptName },${app.appDutyName },${app.appDeduct },${app.appIsCriticism == 1 ? '是' : '否' },${app.appRemark }<br>
										</s:iterator>
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">责任单位限期整改日期</label>
									<div class="layui-input-block">
										${notified.notEndDate }
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">质申员</label>
									<div class="layui-input-block">
										${notPr.user.userName }, ${notPr.preDate }
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">审核人</label>
									<div class="layui-input-block">
										${pr6.user.userName }, ${pr6.preDate }
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">审批人</label>
									<div class="layui-input-block">
										${pr7.user.userName }, ${pr7.preDate }
									</div>
								</div>
							</div>
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
										<div class="layui-input-block">
											<s:iterator value="%{notified.placeFile.ptSet}" status="i">
												${i.count }${pbtName }
											</s:iterator>
										</div>
									</div>	
									<div class="layui-inline">
										<label class="layui-form-label">问题大类</label>
										<div class="layui-input-block">
											${notified.placeFile.plaBigCategory }
										</div>
									</div>
								</div>	
								<div class="layui-form-item">
									<div class="layui-inline">
										<label class="layui-form-label">是否试制把关失效</label>
										<div class="layui-input-inline">
											${notified.placeFile.plaIsTrialControl == 1 ? '是' : '否' }
										</div>
									</div>
									<div class="layui-inline">
										<label class="layui-form-label">是否批量</label>
										<div class="layui-input-inline">
											${notified.placeFile.feedback.docIsBatch == 1 ? '是' : '否' }
										</div>
									</div>
									<div class="layui-inline">
										<label class="layui-form-label" style="width: 160px;">是否有引发售后投诉的隐患</label>
										<div class="layui-input-inline">
											${notified.placeFile.plaIsSafeAfterRisk == 1 ? '是' : '否' }
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
											${notified.placeFile.plaAbnormalType }
									</div>
								</div>
								<div class="layui-form-item">
									<div class="layui-inline">
										<label class="layui-form-label">是否首检失效</label>
										<div class="layui-input-inline">
											${notified.placeFile.plaIsFirstCheckLose == 1 ? '是' : '否' }
										</div>
									</div>
									<div class="layui-inline">
										<label class="layui-form-label">是否重复一个月发生</label>
										<div class="layui-input-inline">
											${notified.placeFile.plaMouthLoopCount == 0 ? '否' : '是' }
										</div>
									</div>
									<div class="layui-inline">
										<label class="layui-form-label">第几次重复发生</label>
										<div class="layui-input-inline">
											${notified.placeFile.plaMouthLoopCount }
										</div>
									</div>
								</div>
								<div class="layui-form-item layui-form-text">
									<label class="layui-form-label">根本原因分析</label>
									<div class="layui-input-block">
											${notified.placeFile.plaCauseAnalysis }
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">原因大类</label>
									<div class="layui-input-block">
											${notified.placeFile.plaBigReason }
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">原因小类</label>
									<div class="layui-input-block">
											${notified.placeFile.plaSmallReason }
									</div>
								</div>
								<div class="layui-form-item">
									<div class="layui-inline">
										<label class="layui-form-label" style="width: 160px;">是否涉及厂内或外仓产品处理</label>
										<div class="layui-input-inline">
											${notified.placeFile.plaIsInvolveHandle == 1 ? '是' : '否' }
										</div>
									</div>
								</div>
								<div class="layui-form-item layui-form-text">
									<label class="layui-form-label">应急解决方案</label>
									<div class="layui-input-block">
											${notified.placeFile.plaEmergencyPlan }
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
											${notified.placeFile.feedback.docId }
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
										${notified.placeFile.feedback.docTheme }
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
											${notified.placeFile.feedback.docFindDate }
										</div>
									</div>
									<div class="layui-inline">
										<label class="layui-form-label">发现地点</label>
										<div class="layui-input-inline">
											${notified.placeFile.feedback.docFindAddr }
										</div>
									</div>	
								</div>
								<div class="layui-form-item">
									<div class="layui-inline">
										<label class="layui-form-label">客户名称</label>
										<div class="layui-input-inline">
											${notified.placeFile.feedback.docCustName }
										</div>
									</div>	
									<div class="layui-inline">
										<label class="layui-form-label">产品类别</label>
										<div class="layui-input-inline">
											${notified.placeFile.feedback.productType.pdtName }
										</div>
									</div>	
									<div class="layui-inline">
										<label class="layui-form-label">产品型号</label>
										<div class="layui-input-inline">
											${notified.placeFile.feedback.docProMode }
										</div>
									</div>	
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">订单号</label>
									<div class="layui-input-block">
											${notified.placeFile.feedback.docOrderNum }
									</div>
								</div>	
								<div class="layui-form-item">
									<div class="layui-inline">
										<label class="layui-form-label">生产单位</label>
										<div class="layui-input-inline">
											${notified.placeFile.feedback.docProDep }
										</div>
									</div>	
									<div class="layui-inline">
										<label class="layui-form-label">生产班组</label>
										<div class="layui-input-inline">
											${notified.placeFile.feedback.docProTeam }
										</div>
									</div>	
									<div class="layui-inline">
										<label class="layui-form-label">责任工序岗位</label>
										<div class="layui-input-inline">
											${notified.placeFile.feedback.docResStation }
										</div>
									</div>	
								</div>
								<div class="layui-form-item">
									<div class="layui-inline">
										<label class="layui-form-label">物料编码</label>
										<div class="layui-input-inline">
											${notified.placeFile.feedback.docItemNum }
										</div>
									</div>	
									<div class="layui-inline">
										<label class="layui-form-label">物料名称</label>
										<div class="layui-input-inline">
											${notified.placeFile.feedback.docItemName }
										</div>
									</div>	
									<div class="layui-inline">
										<label class="layui-form-label">物料类型</label>
										<div class="layui-input-inline">
											${notified.placeFile.feedback.docItemType }
										</div>
									</div>	
									<div class="layui-inline">
										<label class="layui-form-label">供应商</label>
										<div class="layui-input-inline">
											${notified.placeFile.feedback.docSupName }
										</div>
									</div>	
								</div>
								<div class="layui-form-item">
									<div class="layui-inline">
				    					<label class="layui-form-label">是否停线</label>
										<div class="layui-input-inline">
											${notified.placeFile.feedback.docIsStopLine == 1 ? '是' : '否' }
										</div>
									</div>
									<div class="layui-inline">
										<label class="layui-form-label">停线工时损失</label>
										<div class="layui-input-inline">
											${notified.placeFile.feedback.docLoss }
										</div>
									</div>
									<div class="layui-inline">
										<label class="layui-form-label">不合格等级</label>
										<div class="layui-input-inline">
											${notified.placeFile.feedback.docSeverityLevel }
										</div>	
									</div>	
								</div>
								<div class="layui-form-item">
									<div class="layui-inline">
										<label class="layui-form-label">使用数量</label>
										<div class="layui-input-inline">
											${notified.placeFile.feedback.docUsedCounts }
										</div>
									</div>
									<div class="layui-inline">
										<label class="layui-form-label">不良品数量</label>
										<div class="layui-input-inline">
											${notified.placeFile.feedback.docDefproCounts }
										</div>
									</div>
									<div class="layui-inline">
										<label class="layui-form-label">发现异常单位</label>
										<div class="layui-input-inline">
											${notified.placeFile.feedback.docFindDep }
										</div>	
									</div>
								</div>
								<div class="layui-form-item">
									<div class="layui-inline">
										<label class="layui-form-label">是否批量</label>
										<div class="layui-input-inline">
											${notified.placeFile.feedback.docIsBatch == 1 ? '是' : '否' }
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
										${notified.placeFile.feedback.docDescribe }
									</div>
								</div>
							</div>
			
						</div>
					</div>
				</div>
			
			
		</div>
	</div>

	<script type="text/javascript" src="${pageContext.request.contextPath}/layui.js"></script>
	
	<script type="text/javascript">

	layui.use(['jquery', 'laydate', 'form', 'element'], function(){
		var laydate = layui.laydate
		,form = layui.form
		,element = layui.element
		,$ = layui.$

		
		//问题类别
		$.post("problemTypeAction_findProblemTypeList", "", function(data){
			var str = ""
			$.each(data.problemTypeList, function(i, v){
				str += "<input type='checkbox' name='' lay-skin='primary' title='" + v.pbtName + "' value='" + v.pbtName + "'>";
			});
			$("#problemType").append(str);
			form.render();
		}, "json");
		

		//责任单位
		$.post("feedbackAction_findFeedbackByNotified", "notified.notId=${notified.notId }", function(data){
			var str = "";
			$.each(data.feedback.appSet, function(i, v){
				str += "责任单位：" + v.department.deptName + ",责任人：" + v.appDutyName + ",扣分：" + v.appDeduct + ",通报批评：" + (v.appIsCriticism == 1 ? '是' : '否') + ",备注：" + v.appRemark + "<br>";    
			});
			$("#appraise").append(str);
			form.render();
		}, "json");
		
		
		
		form.render();
		
	});	
	
	
	</script>
	
</body>
</html>