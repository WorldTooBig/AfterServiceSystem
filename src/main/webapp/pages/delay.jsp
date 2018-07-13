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
				<span>责任单位答复</span>
			</header>
			
			<div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
					<ul class="layui-tab-title">
						<li class="layui-this">确认申请</li>
						<li>责任单位答复</li>
						<li>考核通报</li>
						<li>归档处理</li>
						<li>异常反馈单</li>
					</ul>
					<div class="layui-tab-content">
						<div class="layui-tab-item layui-show">
							<form class="layui-form" action="delayAction_addDelay" method="post">
								<input type="hidden" name="process.proId" value="12">
								<input type="hidden" name="reply.repId" value="${reply.repId }">
								<s:if test="#pr17 != null">
									<div class="layui-form-item">
										<label class="layui-form-label">申请关闭</label>
										<div class="layui-input-block">
											<input type="radio" name="delay.reqIsAgree" value="1" title="同意关闭" checked="">
											<input type="radio" name="delay.reqIsAgree" value="1" title="不同意关闭">
										</div>
									</div>
								</s:if>
								<s:elseif test="#pr18 != null">
									<div class="layui-form-item">
										<label class="layui-form-label">指派其他责任单位</label>
										<div class="layui-input-block">
											<input type="radio" name="delay.reqIsAgree" value="1" title="同意申请" checked="">
											<input type="radio" name="delay.reqIsAgree" value="1" title="不同意申请">
										</div>
									</div>
								</s:elseif>
								<s:else>
									<div class="layui-form-item">
										<label class="layui-form-label">是否延期</label>
										<div class="layui-input-block">
											<input type="radio" name="delay.reqIsAgree" value="1" title="同意延期至" checked="">
											<input id="date"    name="delay.reqDate" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input" style="width: 200px; margin-right: 25px; display: inline;">
											<input type="radio" name="delay.reqIsAgree" value="0" title="不同意延期">
										</div>
									</div>
								</s:else>
								<div class="layui-form-item layui-form-text">
									<label class="layui-form-label">意见说明</label>
									<div class="layui-input-block">
										<textarea name="delay.reqOpinionNotes" placeholder="请输入" class="layui-textarea"></textarea>
									</div>
								</div>
								<div class="layui-form-item">
									<div class="layui-input-block">
										<button type="button" class="layui-btn" onclick="sub()">确认</button>
										<button type="reset" class="layui-btn layui-btn-primary">重置</button>
									</div>
								</div>
							</form>
							
						</div>
						<div class="layui-tab-item">
							<div class="layui-form-item">
								<label class="layui-form-label">责任单位</label>
								<div class="layui-input-block">
									<s:iterator value="#feePr.feedback.appSet" status="i">
										${i.count }-${department.deptName }
									</s:iterator>
								</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">原因分析</label>
								<div class="layui-input-block">
									${reply.repCauseAnalysis }
								</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">纠正预防措施</label>
								<div class="layui-input-block">
									${reply.repCorrectionMethod }
								</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">纠正落实报告</label>
								<div class="layui-input-block">
									<s:iterator value="%{reply.erList}" begin="0" end="4">
										${etrCorrectionProject },${etrDescription },${etrFileNo }<br>
									</s:iterator>
								</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">答复结果</label>
								<div class="layui-input-block">
									<s:if test="%{reply.department.deptId == #pr16.user.section.department.deptId}">${pr16.process.proName }</s:if>
									<s:if test="%{reply.department.deptId == #pr17.user.section.department.deptId}">${pr17.process.proName }</s:if>
									<s:if test="%{reply.department.deptId == #pr18.user.section.department.deptId}">${pr18.process.proName }</s:if>
								</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">答复人</label>
								<div class="layui-input-block">
									<s:if test="%{reply.department.deptId == #pr16.user.section.department.deptId}">${pr16.user.userName },${pr16.preDate }</s:if>
									<s:if test="%{reply.department.deptId == #pr17.user.section.department.deptId}">${pr17.user.userName },${pr17.preDate }</s:if>
									<s:if test="%{reply.department.deptId == #pr18.user.section.department.deptId}">${pr18.user.userName },${pr18.preDate }</s:if>
									${reply.department.deptId }, ${pr16.user.section.department.deptId }, ${pr17.user.section.department.deptId }, ${pr18.user.section.department.deptId }
								</div>
							</div>
								<div class="layui-form-item">
									<label class="layui-form-label">审核人</label>
									<div class="layui-input-block">
										<s:iterator value="#repEx1">
											<s:if test="%{reply.department.deptId == user.section.department.deptId}">${user.userName },${preDate }</s:if>
										</s:iterator>
											
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">审批人</label>
									<div class="layui-input-block">
										<s:iterator value="#repEx2">
											<s:if test="%{reply.department.deptId == user.section.department.deptId}">${user.userName },${preDate }</s:if>
										</s:iterator>
											<%-- ${repEx2.user.userName },${repEx2.preDate } --%>
									</div>
								</div>
						</div>
						<div class="layui-tab-item">
							<div class="layui-form">
								<div class="layui-form-item">
									<label class="layui-form-label">问题类别</label>
									<div class="layui-input-block" id="problemType">
											<s:iterator value="%{reply.deadline.placeFile.ptSet}" status="i">
												${i.count }${pbtName }
											</s:iterator>
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">是否引发售后</label>
									<div class="layui-input-block">
										${reply.deadline.deaIsSafeAfter == 1 ? '是' : '否' }
									</div>
								</div>
								<div class="layui-form-item layui-form-text">
									<label class="layui-form-label">原因初步分析</label>
									<div class="layui-input-block">
										${reply.deadline.deaCauseAnalysis }
									</div>
								</div>
								<div class="layui-form-item layui-form-text">
									<label class="layui-form-label">处理意见</label>
									<div class="layui-input-block">
										${reply.deadline.deaHandlingComments }
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
										<s:iterator var="app" value="%{reply.deadline.placeFile.feedback.appSet}" status="i">
											${i.count}=${app.department.deptName },${app.appDutyName },${app.appDeduct },${app.appIsCriticism == 1 ? '是' : '否' },${app.appRemark }<br>
										</s:iterator>
									</div>
								</div>
								<div class="layui-form-item">
									<div class="layui-inline">
										<label class="layui-form-label">要求整改方案下发日期</label>
										<div class="layui-input-block">
											${reply.deadline.deaIssuedDate }
										</div>
									</div>
									<div class="layui-inline">
										<label class="layui-form-label">要求整改完成日期</label>
										<div class="layui-input-block">
											${reply.deadline.deaCompleteDate }
										</div>
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">质申员</label>
									<div class="layui-input-block">
										${pr5.user.userName }, ${pr5.preDate }
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
											<s:iterator value="%{reply.deadline.placeFile.ptSet}" status="i">
												${i.count }${pbtName }
											</s:iterator>
										</div>
									</div>	
									<div class="layui-inline">
										<label class="layui-form-label">问题大类</label>
										<div class="layui-input-block">
											${reply.deadline.placeFile.plaBigCategory }
										</div>
									</div>
								</div>	
								<div class="layui-form-item">
									<div class="layui-inline">
										<label class="layui-form-label">是否试制把关失效</label>
										<div class="layui-input-inline">
											${reply.deadline.placeFile.plaIsTrialControl == 1 ? '是' : '否' }
										</div>
									</div>
									<div class="layui-inline">
										<label class="layui-form-label">是否批量</label>
										<div class="layui-input-inline">
											${reply.deadline.placeFile.feedback.docIsBatch == 1 ? '是' : '否' }
										</div>
									</div>
									<div class="layui-inline">
										<label class="layui-form-label" style="width: 160px;">是否有引发售后投诉的隐患</label>
										<div class="layui-input-inline">
											${reply.deadline.placeFile.plaIsSafeAfterRisk == 1 ? '是' : '否' }
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
											${reply.deadline.placeFile.plaAbnormalType }
									</div>
								</div>
								<div class="layui-form-item">
									<div class="layui-inline">
										<label class="layui-form-label">是否首检失效</label>
										<div class="layui-input-inline">
											${reply.deadline.placeFile.plaIsFirstCheckLose == 1 ? '是' : '否' }
										</div>
									</div>
									<div class="layui-inline">
										<label class="layui-form-label">是否重复一个月发生</label>
										<div class="layui-input-inline">
											${reply.deadline.placeFile.plaMouthLoopCount == 0 ? '否' : '是' }
										</div>
									</div>
									<div class="layui-inline">
										<label class="layui-form-label">第几次重复发生</label>
										<div class="layui-input-inline">
											${reply.deadline.placeFile.plaMouthLoopCount }
										</div>
									</div>
								</div>
								<div class="layui-form-item layui-form-text">
									<label class="layui-form-label">根本原因分析</label>
									<div class="layui-input-block">
											${reply.deadline.placeFile.plaCauseAnalysis }
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">原因大类</label>
									<div class="layui-input-block">
											${reply.deadline.placeFile.plaBigReason }
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">原因小类</label>
									<div class="layui-input-block">
											${reply.deadline.placeFile.plaSmallReason }
									</div>
								</div>
								<div class="layui-form-item">
									<div class="layui-inline">
										<label class="layui-form-label" style="width: 160px;">是否涉及厂内或外仓产品处理</label>
										<div class="layui-input-inline">
											${reply.deadline.placeFile.plaIsInvolveHandle == 1 ? '是' : '否' }
										</div>
									</div>
								</div>
								<div class="layui-form-item layui-form-text">
									<label class="layui-form-label">应急解决方案</label>
									<div class="layui-input-block">
											${reply.deadline.placeFile.plaEmergencyPlan }
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
											${reply.deadline.placeFile.feedback.docId }
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
										${reply.deadline.placeFile.feedback.docTheme }
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
											${reply.deadline.placeFile.feedback.docFindDate }
										</div>
									</div>
									<div class="layui-inline">
										<label class="layui-form-label">发现地点</label>
										<div class="layui-input-inline">
											${reply.deadline.placeFile.feedback.docFindAddr }
										</div>
									</div>	
								</div>
								<div class="layui-form-item">
									<div class="layui-inline">
										<label class="layui-form-label">客户名称</label>
										<div class="layui-input-inline">
											${reply.deadline.placeFile.feedback.docCustName }
										</div>
									</div>	
									<div class="layui-inline">
										<label class="layui-form-label">产品类别</label>
										<div class="layui-input-inline">
											${reply.deadline.placeFile.feedback.productType.pdtName }
										</div>
									</div>	
									<div class="layui-inline">
										<label class="layui-form-label">产品型号</label>
										<div class="layui-input-inline">
											${reply.deadline.placeFile.feedback.docProMode }
										</div>
									</div>	
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">订单号</label>
									<div class="layui-input-block">
											${reply.deadline.placeFile.feedback.docOrderNum }
									</div>
								</div>	
								<div class="layui-form-item">
									<div class="layui-inline">
										<label class="layui-form-label">生产单位</label>
										<div class="layui-input-inline">
											${reply.deadline.placeFile.feedback.docProDep }
										</div>
									</div>	
									<div class="layui-inline">
										<label class="layui-form-label">生产班组</label>
										<div class="layui-input-inline">
											${reply.deadline.placeFile.feedback.docProTeam }
										</div>
									</div>	
									<div class="layui-inline">
										<label class="layui-form-label">责任工序岗位</label>
										<div class="layui-input-inline">
											${reply.deadline.placeFile.feedback.docResStation }
										</div>
									</div>	
								</div>
								<div class="layui-form-item">
									<div class="layui-inline">
										<label class="layui-form-label">物料编码</label>
										<div class="layui-input-inline">
											${reply.deadline.placeFile.feedback.docItemNum }
										</div>
									</div>	
									<div class="layui-inline">
										<label class="layui-form-label">物料名称</label>
										<div class="layui-input-inline">
											${reply.deadline.placeFile.feedback.docItemName }
										</div>
									</div>	
									<div class="layui-inline">
										<label class="layui-form-label">物料类型</label>
										<div class="layui-input-inline">
											${reply.deadline.placeFile.feedback.docItemType }
										</div>
									</div>	
									<div class="layui-inline">
										<label class="layui-form-label">供应商</label>
										<div class="layui-input-inline">
											${reply.deadline.placeFile.feedback.docSupName }
										</div>
									</div>	
								</div>
								<div class="layui-form-item">
									<div class="layui-inline">
				    					<label class="layui-form-label">是否停线</label>
										<div class="layui-input-inline">
											${reply.deadline.placeFile.feedback.docIsStopLine == 1 ? '是' : '否' }
										</div>
									</div>
									<div class="layui-inline">
										<label class="layui-form-label">停线工时损失</label>
										<div class="layui-input-inline">
											${reply.deadline.placeFile.feedback.docLoss }
										</div>
									</div>
									<div class="layui-inline">
										<label class="layui-form-label">不合格等级</label>
										<div class="layui-input-inline">
											${reply.deadline.placeFile.feedback.docSeverityLevel }
										</div>	
									</div>	
								</div>
								<div class="layui-form-item">
									<div class="layui-inline">
										<label class="layui-form-label">使用数量</label>
										<div class="layui-input-inline">
											${reply.deadline.placeFile.feedback.docUsedCounts }
										</div>
									</div>
									<div class="layui-inline">
										<label class="layui-form-label">不良品数量</label>
										<div class="layui-input-inline">
											${reply.deadline.placeFile.feedback.docDefproCounts }
										</div>
									</div>
									<div class="layui-inline">
										<label class="layui-form-label">发现异常单位</label>
										<div class="layui-input-inline">
											${reply.deadline.placeFile.feedback.docFindDep }
										</div>	
									</div>
								</div>
								<div class="layui-form-item">
									<div class="layui-inline">
										<label class="layui-form-label">是否批量</label>
										<div class="layui-input-inline">
											${reply.deadline.placeFile.feedback.docIsBatch == 1 ? '是' : '否' }
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
										${reply.deadline.placeFile.feedback.docDescribe }
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
			,type: 'date'
			,calendar: true
		});
		
		
	});

	function sub() {
			$("form").submit();
	}
	</script>
</body>
</html>