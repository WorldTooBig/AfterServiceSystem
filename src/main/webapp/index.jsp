<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<title>Insert title here</title>
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/layui.css" media="all">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/global.css" media="all">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/adminstyle.css" media="all">
</head>
<body class="layui-layout-body">
	
<div class="layui-layout layui-layout-admin" id="layui_layout">
	<!-- 顶部区域 -->
	<div class="layui-header header header-demo">
		<div class="layui-main">
		    <!-- logo区域 -->
			<div class="admin-logo-box">
				<a class="logo" href="javascript:;" title="logo"><img src="images/yl.jpg" alt=""></a>
				<div class="larry-side-menu">
					<i class="fa fa-bars" aria-hidden="true" style="line-height: 30px"></i>
				</div>
			</div>
            <!-- 顶级菜单区域 -->
            <div class="layui-larry-menu">
                 <ul class="layui-nav clearfix">
                       <li class="layui-nav-item">
                 	   	   <a href="javascirpt:;"><i class="iconfont icon-wangzhanguanli"></i>内容管理</a>
                 	   </li>
                 	   <li class="layui-nav-item">
                 	   	   <a href="javascirpt:;"><i class="iconfont icon-weixin3"></i>微信公众</a>
                 	   </li>
                 	   <li class="layui-nav-item">
                 	   	   <a href="javascirpt:;"><i class="iconfont icon-ht_expand"></i>扩展模块</a>
                 	   </li>
                 </ul>
            </div>
            <!-- 右侧导航 -->
            <ul class="layui-nav larry-header-item">
            		<li class="layui-nav-item first">
						<a href="javascript:;">
							<img src="images/userimg.jpg" class="userimg">			
							<cite>默认站点</cite>
							<span class="layui-nav-more"></span>
						</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="">站点1</a>
							</dd>
							<dd>
								<a href="">站点2</a>
							</dd>
							
						</dl>
					</li>
					<li class="layui-nav-item">
						<a href="javascript:;" id="lock">
                        <i class="iconfont icon-diannao1"></i>
						锁屏</a>
					</li>
					<li class="layui-nav-item">
						<a href="login.html">
                        <i class="iconfont icon-exit"></i>
						退出</a>
					</li>
            </ul>
		</div>
	</div>
	<!-- 左侧侧边导航开始 -->
	<div class="layui-side layui-side-bg layui-larry-side" id="larry-side">
        <div class="layui-side-scroll" id="larry-nav-side" lay-filter="side">
		<div class="user-photo">
			<a class="img" title="我的头像" >
				<img src="images/user.png" class="userimg1"></a>
			<p>你好！admin, 欢迎登录</p>
		</div>
		<!-- 左侧菜单 -->
		<ul class="layui-nav layui-nav-tree">
			<li class="layui-nav-item layui-this">
				<a href="javascript:;" data-url="${pageContext.request.contextPath}/pages/main.jsp">
				    <i class="iconfont icon-home1" data-icon='icon-home1'></i>
					<span>后台首页</span>
				</a>
			</li>
			<!-- 质量异常反馈 -->
			<li class="layui-nav-item">
				<a href="javascript:;">
					<i class="iconfont icon-jiaoseguanli" ></i>
					<span>质量异常反馈</span>
					<em class="layui-nav-more"></em>
				</a>
				<dl class="layui-nav-child">
                    <dd>
                        <a href="javascript:;" data-url="${pageContext.request.contextPath}/pages/quas.jsp">
                            <i class="iconfont icon-geren1" data-icon='icon-geren1'></i>
                            <span>填写异常反馈单</span>
                        </a>
                    </dd>
                    <dd>
                        <a href="javascript:;" data-url="${pageContext.request.contextPath}/pages/perSystem.jsp">
                            <i class="iconfont icon-iconfuzhi01" data-icon='icon-iconfuzhi01'></i>
                            <span>编辑驳回反馈单</span>
                        </a>
                    </dd>
                    <dd>
                        <a href="javascript:;" data-url="${pageContext.request.contextPath}/pages/userManage.jsp">
                            <i class="iconfont icon-piliangicon" data-icon='icon-piliangicon'></i>
                            <span>查询异常反馈单内容</span>
                        </a>
                    </dd>
                    <dd>
                        <a href="javascript:;" data-url="${pageContext.request.contextPath}/pages/userInfo.jsp">
                            <i class="iconfont icon-piliangicon" data-icon='icon-piliangicon'></i>
                            <span>导出异常反馈单</span>
                        </a>
                    </dd>
                    <dd>
                        <a href="javascript:;" data-url="none">
                            <i class="iconfont icon-piliangicon" data-icon='icon-piliangicon'></i>
                            <span>已完成异常反馈单</span>
                        </a>
						<dl class="layui-nav-child">
		                    <dd>
		                        <a href="javascript:;" data-url="myloginfo.html">
		                            <i class="iconfont icon-piliangicon" data-icon='icon-piliangicon'></i>
		                            <span>已限期整改的异常反馈单</span>
		                        </a>
		                    </dd>
		                    <dd>
		                        <a href="javascript:;" data-url="myloginfo.html">
		                            <i class="iconfont icon-piliangicon" data-icon='icon-piliangicon'></i>
		                            <span>已考核处理的异常反馈单</span>
		                        </a>
		                    </dd>
		                    <dd>
		                        <a href="javascript:;" data-url="myloginfo.html">
		                            <i class="iconfont icon-piliangicon" data-icon='icon-piliangicon'></i>
		                            <span>已暂停处理的异常反馈单</span>
		                        </a>
		                    </dd>
	                    </dl>
                    </dd>
                </dl>
			</li>
			<!-- 归档处理 -->
			<li class="layui-nav-item">
				<a href="javascript:;">
				   <i class="iconfont icon-jiaoseguanli2" ></i>
				   <span>归档处理</span>
				   <em class="layui-nav-more"></em>
				</a>
			    <dl class="layui-nav-child">
			    	<dd>
			    		<a href="javascript:;" data-url="${pageContext.request.contextPath}/pages/selectPlaceFile.jsp">
			    		   <i class="iconfont icon-yonghu1" data-icon='icon-yonghu1'></i>
			    		   <span>质量异常反馈归档处</span>
			    		</a>
			    	</dd>
			    </dl>
		    </li>
			<!-- 质控部考核通报 -->
			<li class="layui-nav-item">
				<a href="javascript:;">
				   <i class="iconfont icon-wenzhang1" ></i>
				   <span>质控部考核通报</span>
				   <em class="layui-nav-more"></em>
				</a>
			   <dl class="layui-nav-child">
			   	   <dd>
			    		<a href="javascript:;" data-url="${pageContext.request.contextPath}/pages/selectNotified.jsp">
			    		   <i class="iconfont icon-lanmuguanli" data-icon='icon-lanmuguanli'></i>
			    		   <span>质量工程师编制考核通报</span>
			    		</a>
			    	</dd>
			    	<dd>
			    		<a href="javascript:;" data-url="${pageContext.request.contextPath}/pages/reply.jsp">
			    		   <i class="iconfont icon-wenzhang2" data-icon='icon-wenzhang2'></i>
			    		   <span>质控部审核考核通报</span>
			    		</a>
			    	</dd>
			    	<dd>
			    		<a href="javascript:;">
			    		   <i class="iconfont icon-icon1" data-icon='icon-icon1'></i>
			    		   <span>质控部领导审批考核通报</span>
			    		</a>
			    	</dd>
			    	<dd>
			    		<a href="javascript:;">
			    		   <i class="iconfont icon-word" data-icon='icon-word'></i>
			    		   <span>责任单位答复</span>
			    		</a>
			    	</dd>
			    	<dd>
			    		<a href="javascript:;">
			    		   <i class="iconfont icon-pinglun1" data-icon='icon-pinglun1'></i>
			    		   <span>责任单位领导审批答复</span>
			    		</a>
			    	</dd>
			    	<dd>
			    		<a href="javascript:;">
			    		   <i class="iconfont icon-tags1" data-icon='icon-tags1'></i>
			    		   <span>质量工程师下考核结论</span>
			    		</a>
			    	</dd>
			    	<dd>
			    		<a href="javascript:;">
			    		   <i class="iconfont icon-huishouzhan1" data-icon='icon-huishouzhan1'></i>
			    		   <span>质控部审核考核结论</span>
			    		</a>
			    	</dd>
			    	<dd>
			    		<a href="javascript:;">
			    		   <i class="iconfont icon-huishouzhan1" data-icon='icon-huishouzhan1'></i>
			    		   <span>质控部领导审批考核结论</span>
			    		</a>
			    	</dd>
			    	<dd>
			    		<a href="javascript:;">
			    		   <i class="iconfont icon-huishouzhan1" data-icon='icon-huishouzhan1'></i>
			    		   <span>查询考核通报</span>
			    		</a>
			    	</dd>
			    	<dd>
			    		<a href="javascript:;">
			    		   <i class="iconfont icon-huishouzhan1" data-icon='icon-huishouzhan1'></i>
			    		   <span>导出详细信息xls表</span>
			    		</a>
			    	</dd>
			    	<dd>
			    		<a href="javascript:;">
			    		   <i class="iconfont icon-huishouzhan1" data-icon='icon-huishouzhan1'></i>
			    		   <span>统计问题类别xls表</span>
			    		</a>
			    	</dd>
			   </dl>
		   </li>
			
            <!-- 限期整改 -->
			<li class="layui-nav-item">
				<a href="javascript:;">
				   <i class="iconfont icon-m-members" ></i>
				   <span>限期整改</span>
				   <em class="layui-nav-more"></em>
				</a>
				<dl class="layui-nav-child">
           			<dd>
           	   			<a href="javascript:;">
 							<i class="iconfont icon-zhuti"  data-icon='icon-zhuti'></i>
							<span>质量工程师编制限期整改单</span>
						</a>
 					</dd>
					<dd>
						<a href="javascript:;">
							<i class="iconfont icon-zhuti"  data-icon='icon-zhuti'></i>
							<span>质控部审核限期整改单</span>
						</a>
           			</dd>
					<dd>
						<a href="javascript:;">
							<i class="iconfont icon-zhuti"  data-icon='icon-zhuti'></i>
							<span>质控部领导审批限期整改单</span>
						</a>
           			</dd>
					<dd>
						<a href="javascript:;">
							<i class="iconfont icon-zhuti"  data-icon='icon-zhuti'></i>
							<span>责任单位答复</span>
						</a>
           			</dd>
					<dd>
						<a href="javascript:;">
							<i class="iconfont icon-zhuti"  data-icon='icon-zhuti'></i>
							<span>被驳回的答复</span>
						</a>
           			</dd>
					<dd>
						<a href="javascript:;">
							<i class="iconfont icon-zhuti"  data-icon='icon-zhuti'></i>
							<span>责任单位审核答复</span>
						</a>
           			</dd>
					<dd>
						<a href="javascript:;">
							<i class="iconfont icon-zhuti"  data-icon='icon-zhuti'></i>
							<span>责任单位领导审批答复</span>
						</a>
           			</dd>
					<dd>
						<a href="javascript:;">
							<i class="iconfont icon-zhuti"  data-icon='icon-zhuti'></i>
							<span>质量工程师确认申请</span>
						</a>
           			</dd>
					<dd>
						<a href="javascript:;">
							<i class="iconfont icon-zhuti"  data-icon='icon-zhuti'></i>
							<span>质控部审核确认申请</span>
						</a>
           			</dd>
					<dd>
						<a href="javascript:;">
							<i class="iconfont icon-zhuti"  data-icon='icon-zhuti'></i>
							<span>质控部领导审批确认申请</span>
						</a>
           			</dd>
					<dd>
						<a href="javascript:;">
							<i class="iconfont icon-zhuti"  data-icon='icon-zhuti'></i>
							<span>质量工程师关闭限期整改单</span>
						</a>
           			</dd>
					<dd>
						<a href="javascript:;">
							<i class="iconfont icon-zhuti"  data-icon='icon-zhuti'></i>
							<span>质控部审核关闭单</span>
						</a>
           			</dd>
					<dd>
						<a href="javascript:;">
							<i class="iconfont icon-zhuti"  data-icon='icon-zhuti'></i>
							<span>质控部领导审批关闭单</span>
						</a>
           			</dd>
					<dd>
						<a href="javascript:;">
							<i class="iconfont icon-zhuti"  data-icon='icon-zhuti'></i>
							<span>查询限期整改通知单</span>
						</a>
           			</dd>
					<dd>
						<a href="javascript:;">
							<i class="iconfont icon-zhuti"  data-icon='icon-zhuti'></i>
							<span>导出详细信息xls表</span>
						</a>
           			</dd>
                 </dl>
			</li>
				
				
			<!-- 授权委托 -->
			<li class="layui-nav-item">
				<a href="javascript:;">
				   <i class="iconfont icon-xitong" ></i>
				   <span>授权委托</span>
				   <em class="layui-nav-more"></em>
				</a>
				    <dl class="layui-nav-child">
				    	<dd>
				    		<a href="javascript:;">
				    		   <i class="iconfont icon-zhandianpeizhi" data-icon='icon-zhandianpeizhi'></i>
				    		   <span>基本参数设置</span>
				    		</a>
				    	</dd>
				    	<dd>
				    		<a href="javascript:;">
				    		   <i class="iconfont icon-zhandianguanli1" data-icon='icon-zhandianguanli1'></i>
				    		   <span>多站点管理</span>
				    		</a>
				    	</dd>
				    	<dd>
				    		<a href="javascript:;">
				    		   <i class="iconfont icon-anquanshezhi" data-icon='icon-anquanshezhi'></i>
				    		   <span>安全设置</span>
				    		</a>
				    	</dd>
				    	<dd>
				    		<a href="javascript:;">
				    		   <i class="iconfont icon-sms" data-icon='icon-sms'></i>
				    		   <span>短信接口设置</span>
				    		</a>
				    	</dd>
				    	<dd>
				    		<a href="javascript:;">
				    		   <i class="iconfont icon-iconfuzhi01" data-icon='icon-iconfuzhi01'></i>
				    		   <span>系统日志管理</span>
				    		</a>
				    	</dd>
				    	<dd>
				    		<a href="javascript:;">
				    			<i class='iconfont icon-SQLServershujuku' data-icon='icon-SQLServershujuku'></i>
				    			<span>SQL命令行工具</span>
				    		</a>
				    	</dd>
				    	<dd>
				    		<a href="javascript:;">
				    			<i class='iconfont icon-xinxicaiji' data-icon='icon-xinxicaiji'></i>
				    			<span>防采集管理</span>
				    		</a>
				    	</dd>
				    </dl>
				</li>
				<!-- 友链设置 -->
				<li class="layui-nav-item">
					<a href="javascript:;">
					   <i class="iconfont icon-youqinglianjie"  data-icon='icon-youqinglianjie'></i>
					   <span>友情链接</span>
					</a>
				</li>
		</ul>
	    </div>
	</div>

	<!-- 左侧侧边导航结束 -->
	<!-- 右侧主体内容 -->
	<div class="layui-body" id="larry-body" style="bottom: 0;border-left: solid 2px #1AA094;">
		<div class="layui-tab layui-tab-card larry-tab-box" id="larry-tab" lay-filter="demo" lay-allowclose="true">
			<ul class="layui-tab-title">
				<li class="layui-this" id="admin-home"><i class="iconfont icon-diannao1"></i><em>后台首页</em></li>
			</ul>
			<div class="layui-tab-content" style="min-height: 150px; ">
				<div class="layui-tab-item layui-show">
					<iframe class="larry-iframe" data-id='0' src="${pageContext.request.contextPath}/pages/main.jsp"></iframe>
				</div>
			</div>
		</div>

        
	</div>
	<!-- 底部区域 -->
	<div class="layui-footer layui-larry-foot" id="larry-footer">
		<div class="layui-mian">
			<!-- 底部固定区域 -->
	    	© layui.com - 底部固定区域
		    <!-- <div class="larry-footer-left">
		    	LarryCMS QQ群：
		    	<a href="https://jq.qq.com/?_wv=1027&k=42fC4vT"><img border="0" src="images/group.png" title="LarryCMS官方交流群"></a>
		    	 查看:<a href="http://www.qinshouwei.com" title="">作者信息</a>
		    </div>
		    <p class="p-admin">
		    	<span>2016 &copy;</span>
		    	Write by Larry,<a href="http://www.larrycms.com">LarryCMS</a>. 版权所有
		    	前端框架layui，下载地址：www.layui.com
		    </p> -->
		</div>
	</div>
	
</div>


<!-- 加载js文件-->
	<script type="text/javascript" src="${pageContext.request.contextPath}/layui.js"></script> 
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/larry.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/index.js"></script>
	
	
<!-- 锁屏 -->
<div class="lock-screen" style="display: none;">
	<div id="locker" class="lock-wrapper">
		<div id="time"></div>
		<div class="lock-box center">
			<img src="images/userimg.jpg" alt="">
			<h1>admin</h1>
			<duv class="form-group col-lg-12">
				<input type="password" placeholder='锁屏状态，请输入密码解锁' id="lock_password" class="form-control lock-input" autofocus name="lock_password">
				<button id="unlock" class="btn btn-lock">解锁</button>
			</duv>
		</div>
	</div>
</div>
<!-- 菜单控件 -->
<!-- <div class="larry-tab-menu">
	<span class="layui-btn larry-test">刷新</span>
</div> -->
<!-- iframe框架刷新操作 -->
<!-- <div id="refresh_iframe" class="layui-btn refresh_iframe">刷新</div> -->

</body>
</html>
