<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			
			
			<div class="larry-personal-body clearfix">
			
 
				<div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
					<ul class="layui-tab-title">
						<li class="layui-this">确认申请</li>
						<li>责任单位答复</li>
						<li>限期整改</li>
						<li>归档处理</li>
						<li>异常反馈单</li>
					</ul>
					<div class="layui-tab-content">
						<div class="layui-tab-item layui-show">
							<s:if test="#pr17 != null">
								<div class="layui-form-item">
									<label class="layui-form-label">申请关闭说明</label>
									<div class="layui-input-block">
										${delay.reqDelayExplain }
									</div>
								</div>
							</s:if>
							<s:elseif test="#pr18 != null">
								<div class="layui-form-item">
									<label class="layui-form-label">指定下一责任单位</label>
									<div class="layui-input-block">
										${delay.reqDelayExplain }
									</div>
								</div>
							</s:elseif>
							<s:elseif test="#pr16 != null">
								<s:if test="%{delay.reqDate != null }">
									<div class="layui-form-item">
										<label class="layui-form-label">延期至：</label>
										<div class="layui-input-block">
											${delay.reqDate }
										</div>
									</div>
								</s:if>
								<s:else>
									<div class="layui-form-item">
										<label class="layui-form-label">延期至：</label>
										<div class="layui-input-block">
											延期申请被驳回
										</div>
									</div>
								</s:else>
								<div class="layui-form-item">
									<label class="layui-form-label">说明</label>
									<div class="layui-input-block">
										${delay.reqDelayExplain }
									</div>
								</div>
							</s:elseif>
							
							<div class="layui-form-item">
								<label class="layui-form-label">处理人</label>
								<div class="layui-input-block">
									${pr12.user.userName }${pr12.preDate }<%-- <s:property value="#deaEx1.size()"/> --%>
								</div>
							</div>
							<s:if test="%{reply.repHandleStep == 5}">
								<div class="layui-form-item">
									<div class="layui-input-block">
										<button type="button" class="layui-btn" onclick="examine1(1,6)">同意</button>
										<button type="button" class="layui-btn layui-btn-primary" onclick="examine1(0,6)">驳回</button>
									</div>
								</div>
							</s:if>
							<s:else>
								<div class="layui-form-item">
									<label class="layui-form-label">审核人</label>
									<div class="layui-input-block">
										${pr7d.user.userName },${pr7d.preDate }
									</div>
								</div>
								<div class="layui-form-item">
									<div class="layui-input-block">
										<button type="button" class="layui-btn" onclick="examine2(1,7)">同意</button>
										<button type="button" class="layui-btn layui-btn-primary" onclick="examine2(0,7)">驳回</button>
									</div>
								</div>
							</s:else>
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
									<s:iterator var="er" value="%{reply.erList}" begin="0" end="4">
										${er.etrCorrectionProject },${er.etrDescription },${er.etrFileNo }<br>
									</s:iterator>
								</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">答复结果</label>
								<div class="layui-input-block">
									${pr16.process.proName }${pr17.process.proName }${pr18.process.proName }
								</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">答复人</label>
								<div class="layui-input-block">
									${pr16.user.userName }${pr16.preDate }
									${pr17.user.userName }${pr17.preDate }
									${pr18.user.userName }${pr18.preDate }
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
	</div> 

		
	<script type="text/javascript" src="${pageContext.request.contextPath}/layui.js"></script>
	<script>
	layui.use(['jquery', 'layer', 'form', 'element'], function(){
		var layer = layui.layer
		,form = layui.form
		,element = layui.element
		,$ = layui.$
		
	});

	// 科室主任审核意见
	function examine1(opinion, proId) {
		var reqId = "${delay.reqId }";
		location.href = "delayAction_examine1?opinion=" + opinion + "&process.proId=" + proId + "&delay.reqId=" + reqId;
	}
	// 部门领导审批意见
	function examine2(opinion, proId) {
		var reqId = "${delay.reqId }";
		location.href = "delayAction_examine2?opinion=" + opinion + "&process.proId=" + proId + "&delay.reqId=" + reqId;
	}
	</script>
</body>
</html>