<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="layui-header">
	<div class="layui-logo">layui 后台布局</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    <ul class="layui-nav layui-layout-left">
      <li class="layui-nav-item"><a href="">控制台</a></li>
      <li class="layui-nav-item"><a href="">商品管理</a></li>
      <li class="layui-nav-item"><a href="">用户</a></li>
      <li class="layui-nav-item">
        <a href="javascript:;">其它系统</a>
        <dl class="layui-nav-child">
          <dd><a href="">邮件管理</a></dd>
          <dd><a href="">消息管理</a></dd>
          <dd><a href="">授权管理</a></dd>
        </dl>
      </li>
    </ul>
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a href="javascript:;">
          <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
          贤心
        </a>
        <dl class="layui-nav-child">
          <dd><a href="">基本资料</a></dd>
          <dd><a href="">安全设置</a></dd>
        </dl>
      </li>
      <li class="layui-nav-item"><a href="">退了</a></li>
    </ul>
  </div>
    
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
      <li class="layui-nav-item layui-nav-itemed">
          <a class="" href="javascript:;">首页</a>
        </li>
        <li class="layui-nav-item layui-nav-itemed">
          <a class="" href="javascript:;">单据管理</a>
          <dl class="layui-nav-child">
            <dd><a href="javascript:;">填写异常反馈单</a></dd>
            <dd><a href="javascript:;">查询驳回反馈单</a></dd>
            <dd><a href="javascript:;">查询驳回反馈单2</a></dd>
            <dd><a href="">超链接</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item layui-nav-itemed">
          <a href="javascript:;">基本信息</a>
          <dl class="layui-nav-child">
            <dd><a href="${pageContext.request.contextPath}/pages/userInfo.jsp">用户信息</a></dd>
            <dd><a href="companyAction_findCompanyList">公司部门信息</a></dd>
            <dd><a href="${pageContext.request.contextPath}/pages/perSystem.jsp">权限管理</a></dd>
            <dd><a href="companyAction_findCompanyList">！！！</a></dd>
            <!-- <dd class="layui-this"><a href="companyAction_findCompanyList">！！！</a></dd> -->
            <dd><a href="">超链接</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item"><a href="">云市场</a></li>
        <li class="layui-nav-item"><a href="">发布商品</a></li>
      </ul>
    </div>
  </div>