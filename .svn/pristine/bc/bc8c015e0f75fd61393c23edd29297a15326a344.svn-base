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
						<li class="layui-this">考核通报</li>
						<li>归档处理</li>
						<li>异常反馈单</li>
					</ul>
					<div class="layui-tab-content">
						<div class="layui-tab-item layui-show">
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
								<s:if test="#pr6 == null">
									<div class="layui-form-item">
										<div class="layui-input-block">
											<button type="button" class="layui-btn" onclick="examine1('1',7)">同意</button>
											<button type="button" class="layui-btn" onclick="examine1('0',0)">驳回</button>
										</div>
									</div>
								</s:if>
								<s:if test="#pr6 != null">
									<div class="layui-form-item">
										<label class="layui-form-label">审核人</label>
										<div class="layui-input-block">
											${pr6.user.userName }, ${pr6.preDate }
										</div>
									</div>
									<div class="layui-form-item">
										<div class="layui-input-block">
											<button type="button" class="layui-btn" onclick="examine2('1',9)">同意</button>
											<button type="button" class="layui-btn" onclick="examine2('0',0)">驳回</button>
										</div>
									</div>
								</s:if>
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
										<div class="layui-input-block" id="problemType">
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
	</div> 

		
	<script type="text/javascript" src="${pageContext.request.contextPath}/layui.js"></script>
	<script>
	layui.use(['jquery', 'layer', 'form', 'element'], function(){
		var layer = layui.layer
		,form = layui.form
		,element = layui.element
		,$ = layui.$
		
	});

	// 科室主任审核意见  opinion 1同意 0驳回
	function examine1(opinion, proId) {
		var plaId = "${notified.placeFile.plaId }";
		location.href = "notifiedAction_examine1?opinion=" + opinion + "&process.proId=" + proId + "&placeFile.plaId=" + plaId;
	}
	
	// 部门领导审核意见  opinion 1同意 0驳回
	function examine2(opinion, proId) {
		var notId = "${notified.notId }";
		location.href = "notifiedAction_examine2?opinion=" + opinion + "&process.proId=" + proId + "&notified.notId=" + notId;
	}
	</script>
</body>
</html>