/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.37
 * Generated at: 2018-06-14 08:05:25 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class perSystem_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">\r\n");
      out.write("\t<title>Insert title here</title>\r\n");
      out.write("\t\r\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery-3.3.1.min.js\"></script>\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/layui.css\">\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/main.css\">\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/global.css\" media=\"all\">\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/personal.css\" media=\"all\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"larry-wrapper\">\r\n");
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class=\"larry-personal\">\r\n");
      out.write("\t\t\t<header class=\"larry-personal-tit\">\r\n");
      out.write("\t\t\t\t<span>个人信息</span>\r\n");
      out.write("\t\t\t</header>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div class=\"larry-personal-body clearfix\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<!-- 内容主体区域 -->\r\n");
      out.write("\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t<fieldset class=\"layui-elem-field layui-field-title\" style=\"margin-top: 50px;\">\r\n");
      out.write("\t\t\t\t\t<legend>用户权限管理</legend>\r\n");
      out.write("\t\t\t\t</fieldset>\r\n");
      out.write(" \r\n");
      out.write("\t\t\t\t<div class=\"layui-tab layui-tab-brief\" lay-filter=\"docDemoTabBrief\">\r\n");
      out.write("\t\t\t\t\t<ul class=\"layui-tab-title\">\r\n");
      out.write("\t\t\t\t\t\t<li class=\"layui-this\">基本用户信息</li>\r\n");
      out.write("\t\t\t\t\t\t<li>添加用户</li>\r\n");
      out.write("\t\t\t\t\t\t<li>添加角色</li>\r\n");
      out.write("\t\t\t\t\t\t<li>添加权限</li>\r\n");
      out.write("\t\t\t\t\t\t<li>一二三四</li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t<div class=\"layui-tab-content\" style=\"height: 100px;\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"layui-tab-item layui-show\">\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<!-- 添加用户 -->\r\n");
      out.write("\t\t\t\t\t\t<div class=\"layui-tab-item\">\r\n");
      out.write("\t\t\t\t\t\t\t<form class=\"layui-form\" action=\"userAction_addUser\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label class=\"layui-form-label\">登录账号</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"layui-input-block\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"user.userName\" lay-verify=\"required\" autocomplete=\"off\" placeholder=\"请输入账号\" class=\"layui-input\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label class=\"layui-form-label\">登录密码</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"layui-input-block\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"user.userPwd\" lay-verify=\"required\" autocomplete=\"off\" placeholder=\"请输入密码\" class=\"layui-input\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label class=\"layui-form-label\">真实姓名</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"layui-input-block\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"user.userRealName\" lay-verify=\"required\" autocomplete=\"off\" placeholder=\"请输入姓名\" class=\"layui-input\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label class=\"layui-form-label\">工号</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"layui-input-block\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"user.userJobNum\" lay-verify=\"required\" autocomplete=\"off\" placeholder=\"请输入工号\" class=\"layui-input\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label class=\"layui-form-label\">职务</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"layui-input-block\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"user.userJobName\" lay-verify=\"required\" autocomplete=\"off\" placeholder=\"请输入职务\" class=\"layui-input\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label class=\"layui-form-label\">电话</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"layui-input-block\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"user.userTell\" lay-verify=\"phone\" autocomplete=\"off\" placeholder=\"请输入电话\" class=\"layui-input\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label class=\"layui-form-label\">邮箱</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"layui-input-block\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"user.userEmail\" lay-verify=\"email\" autocomplete=\"off\" placeholder=\"请输入邮箱\" class=\"layui-input\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label class=\"layui-form-label\">所属公司</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"layui-input-block\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<select id=\"compId\" lay-filter=\"findDepartmentList\" lay-verify=\"number\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<option value=\"\">--请选择--</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label class=\"layui-form-label\">所属部门</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"layui-input-block\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<select id=\"deptId\" lay-filter=\"findSectionList\" lay-verify=\"number\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<option value=\"\">--请选择--</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label class=\"layui-form-label\">所属科室</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"layui-input-block\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<select name=\"section.sectId\" lay-verify=\"number\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<option value=\"\">--请选择--</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"layui-form-item layui-form-text\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label class=\"layui-form-label\">备注</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"layui-input-block\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<textarea name=\"user.userRemark\" placeholder=\"请输入备注\" class=\"layui-textarea\"></textarea>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<!-- 按钮 -->\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div  class=\"layui-input-block\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div style=\"width: 216px; margin: 0;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<button lay-submit class=\"layui-btn layui-btn-fluid\">添加</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t    </div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"layui-tab-item\">\r\n");
      out.write("\t\t\t\t\t\t\t<form class=\"layui-form\" action=\"roleAction_addRole\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label class=\"layui-form-label\">添加角色</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"layui-input-block\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input name=\"role.roleName\" lay-verify=\"required\" autocomplete=\"off\" placeholder=\"请输入角色名称\" class=\"layui-input\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\t\r\n");
      out.write("\t\t\t\t\t\t\t\t<!-- 按钮 -->\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div  class=\"layui-input-block\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div style=\"width: 216px; margin: 0;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<button lay-submit class=\"layui-btn layui-btn-fluid\">添加</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"layui-tab-item\">\r\n");
      out.write("\t\t\t\t\t\t\t<form class=\"layui-form\" action=\"permissionAction_addPermission\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label class=\"layui-form-label\">添加权限</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"layui-input-block\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input name=\"permission.permName\" lay-verify=\"required\" autocomplete=\"off\" placeholder=\"请输入角色名称\" class=\"layui-input\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\t\r\n");
      out.write("\t\t\t\t\t\t\t\t<!-- 按钮 -->\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div  class=\"layui-input-block\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div style=\"width: 216px; margin: 0;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<button lay-submit class=\"layui-btn layui-btn-fluid\">添加</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"layui-tab-item\">内容5\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div> \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- \t<hr>\r\n");
      out.write("\t<div id=\"userDiv\">\r\n");
      out.write("\t\t<h2>用户信息</h2>\r\n");
      out.write("\t\t<table border=1>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th>序号</th><th>用户名</th><th>密码</th><th>真实名</th><th>工号</th><th>职务</th><th>电话</th><th>邮箱</th><th>备注</th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<div id=\"roleDiv\">\r\n");
      out.write("\t\t<h2>角色信息</h2>\r\n");
      out.write("\t\t<ul>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<br/>\r\n");
      out.write("\t\r\n");
      out.write("\t<hr>\r\n");
      out.write("\t<div id=\"perDiv\">\r\n");
      out.write("\t\t<h2>权限信息</h2>\r\n");
      out.write("\t\t<ul>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<div id=\"fixDiv\" style=\"position: fixed; top: 0; left: 0; width: 100%; height: 100%;\">\r\n");
      out.write("\t\t<div style=\"position: fixed; top: 20%; left: 35%; width: 30%; height: 50%; background-color: RGBA(0,0,0,0.5);\">\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div> -->\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<!-- <div class=\"layui-footer\">\r\n");
      out.write("\t    \t底部固定区域\r\n");
      out.write("\t    \t© layui.com - 底部固定区域\r\n");
      out.write("\t\t</div> -->\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/layui.js\"></script>\r\n");
      out.write("\t\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\r\n");
      out.write("\tlayui.use(['jquery', 'layer', 'form', 'element'], function(){\r\n");
      out.write("\t\tvar layer = layui.layer\r\n");
      out.write("\t\t,form = layui.form\r\n");
      out.write("\t\t,element = layui.element\r\n");
      out.write("\t\t,$ = layui.$\r\n");
      out.write("\r\n");
      out.write("\t\t//获取公司\r\n");
      out.write("\t\t$.post(\"companyAction_findCompanyListJson\", \"\", function(data){\r\n");
      out.write("\t\t\tvar str = \"\";\r\n");
      out.write("\t\t\t$.each(data.list, function(i, v) {\r\n");
      out.write("\t\t\t\tstr += \"<option value='\" + v.compId + \"'>\" + v.compName + \"</option>\";\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t$(\"#compId\").append(str);\r\n");
      out.write("\t\t\tform.render();\r\n");
      out.write("\t\t}, \"json\");\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//根据公司ID获取部门\r\n");
      out.write("\t\tform.on('select(findDepartmentList)', function(data){\r\n");
      out.write("\t\t\t$.post(\"departmentAction_findDepartmentList\", \"company.compId=\" + data.elem.value, function(data) {\r\n");
      out.write("\t\t\t\t$(\"#deptId option:not(:first)\").remove();\r\n");
      out.write("\t\t\t\tvar str = \"\";\r\n");
      out.write("\t\t\t\t$.each(data.list, function(i, v) {\r\n");
      out.write("\t\t\t\t\tstr += \"<option value='\" + v.deptId + \"'>\" + v.deptName + \"</option>\";\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t\t$(\"#deptId\").append(str);\r\n");
      out.write("\t\t\t\tform.render();\r\n");
      out.write("\t\t\t}, \"json\");\r\n");
      out.write("\t\t});   \r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//根据部门ID获取科室\r\n");
      out.write("\t\tform.on('select(findSectionList)', function(data){\r\n");
      out.write("\t\t\t$.post(\"sectionAction_findSectionList\", \"department.deptId=\" + data.elem.value, function(data) {\r\n");
      out.write("\t\t\t\t$(\"select[name='section.sectId'] option:not(:first)\").remove();\r\n");
      out.write("\t\t\t\tvar str = \"\";\r\n");
      out.write("\t\t\t\t$.each(data.list, function(i, v) {\r\n");
      out.write("\t\t\t\t\tstr += \"<option value='\" + v.sectId + \"'>\" + v.sectName + \"</option>\";\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t\t$(\"select[name='section.sectId']\").eq(0).append(str);\r\n");
      out.write("\t\t\t\tform.render();\r\n");
      out.write("\t\t\t}, \"json\");\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t  \r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\twindow.onload = start();\r\n");
      out.write("\r\n");
      out.write("\tfunction start() {\r\n");
      out.write("\t\tuserFind();\r\n");
      out.write("\t\troleFind();\r\n");
      out.write("\t\tperFind();\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t//获得所有用户信息\r\n");
      out.write("\tfunction userFind() {\r\n");
      out.write("\t\t$.post(\"userAction_findUserAndROleByUserList\", null, function(data){\r\n");
      out.write("\t\t\t$(\"#userDiv table tr:not(:first)\").remove();\r\n");
      out.write("\t\t\tvar strs = \"\";\r\n");
      out.write("\t\t\t$.each(data.list, function(i, val){\r\n");
      out.write("\t\t\t\tstrs += \"<tr>\";\r\n");
      out.write("\t\t\t\tstrs += \"<td>\" + (++i) + \"</td>\";\r\n");
      out.write("\t\t\t\tstrs += \"<td>\" + val[0].userName + \"</td>\";\r\n");
      out.write("\t\t\t\tstrs += \"<td>\" + val[0].userPwd + \"</td>\";\r\n");
      out.write("\t\t\t\tstrs += \"<td>\" + val[0].userRealName + \"</td>\";\r\n");
      out.write("\t\t\t\tstrs += \"<td>\" + val[0].userJobNum + \"</td>\";\r\n");
      out.write("\t\t\t\tstrs += \"<td>\" + val[0].userJobName + \"</td>\";\r\n");
      out.write("\t\t\t\tstrs += \"<td>\" + val[0].userTell + \"</td>\";\r\n");
      out.write("\t\t\t\tstrs += \"<td>\" + val[0].userEmail + \"</td>\";\r\n");
      out.write("\t\t\t\tstrs += \"<td>\" + val[0].userRemark + \"</td>\";\r\n");
      out.write("\t\t\t\tstrs += \"</tr>\";\r\n");
      out.write("\t\t\t\tstrs += \"<tr>\";\r\n");
      out.write("\t\t\t\tstrs += \"<td colspan=9 style='padding-left:20px;'>\";\r\n");
      out.write("\t\t\t\t$.each(val[1], function(j, value) {\r\n");
      out.write("\t\t\t\t\tvar v = value.toString().split(\",\");\r\n");
      out.write("\t\t\t\t\tstrs += ++j + \".\" + v[1] + \"------------------<a href='${pageContext.request.contextPath}/userRoleAction_deleteUserRole?userRole.urId=\" + v[0] + \"'>解绑</a><br />\";\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t\tstrs += \"<input type='button' value='绑定角色' onclick=bindingRole('\" + val[0].userId + \"','\" + val[0].userName + \"') />\";\r\n");
      out.write("\t\t\t\tstrs += \"\";\r\n");
      out.write("\t\t\t\tstrs += \"</td>\";\r\n");
      out.write("\t\t\t\tstrs += \"</tr>\";\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t$(\"#userDiv table\").append(strs);\r\n");
      out.write("\t\t}, \"json\");\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t//获得所有角色信息\r\n");
      out.write("\tfunction roleFind() {\r\n");
      out.write("\t\t$.post(\"roleAction_findRoleAndPermission\", null, function(data){\r\n");
      out.write("\t\t\t$(\"#roleDiv ul\").empty();\r\n");
      out.write("\t\t\tvar strs = \"\";\r\n");
      out.write("\t\t\t$.each(data.list, function(i, v){\r\n");
      out.write("\t\t\t\tstrs += \"<li>\" + v[0].roleName;\r\n");
      out.write("\t\t\t\tstrs += \"<ol>\";\r\n");
      out.write("\t\t\t\t$.each(v[1], function(j, value){\r\n");
      out.write("\t\t\t\t\tvar val = value.toString().split(\",\");\r\n");
      out.write("\t\t\t\t\tstrs += '<li>';\r\n");
      out.write("\t\t\t\t\tstrs += val[1] + '-------------------<a href=\"${pageContext.request.contextPath}/rolePermissionAction_deleteRolePermissionById?rolePermission.rpId=' + val[0] + '\\\">解绑</a>';\r\n");
      out.write("\t\t\t\t\tstrs += \"</li>\";\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t\tstrs += \"<input type='button' value='绑定权限' onclick=bindingPer('\" + v[0].roleId + \"','\" + v[0].roleName + \"') />\";\r\n");
      out.write("\t\t\t\tstrs += \"</ol>\";\r\n");
      out.write("\t\t\t\tstrs += \"</li>\";\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t$(\"#roleDiv ul\").append(strs);\r\n");
      out.write("\t\t}, \"json\");\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t//获得所有权限信息\r\n");
      out.write("\tfunction perFind() {\r\n");
      out.write("\t\t$.post(\"permissionAction_findPermissionList\", null, function(data) {\r\n");
      out.write("\t\t\t$(\"#perDiv ul\").empty();\r\n");
      out.write("\t\t\tvar strs = \"\";\r\n");
      out.write("\t\t\t$.each(data.permissionList, function(i, v){\r\n");
      out.write("\t\t\t\tstrs += \"<li>\" + v.permName + \"</li>\";\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t$(\"#perDiv ul\").append(strs);\r\n");
      out.write("\t\t}, \"json\");\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t//绑定权限\r\n");
      out.write("\tfunction bindingPer(rno, rname) {\r\n");
      out.write("\t\t$(\"#fixDiv div\").empty();\r\n");
      out.write("\t\tfixDivToggle();\r\n");
      out.write("\t\t$.post(\"permissionAction_findPermissionNoBindingListByRole\", \"role.roleId=\" + rno, function(data) {\r\n");
      out.write("\t\t\tvar strs = \"\";\r\n");
      out.write("\t\t\tstrs += \"<h2>角色名：\" + rname + \"</h2>\";\r\n");
      out.write("\t\t\tstrs += \"<form action='rolePermissionAction_addRolePermission' method='post'>\";\r\n");
      out.write("\t\t\tstrs += \"<input type='hidden' name='rolePermission.role.roleId' value='\" + rno + \"' />\";\r\n");
      out.write("\t\t\tstrs += \"<ul>\";\r\n");
      out.write("\t\t\t$.each(data.permissionList, function(i, v) {\r\n");
      out.write("\t\t\t\tstrs += \"<li><input type='checkbox' name='pno' value='\" + v[0] + \"' />\" + v[1] + \"</li>\";\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\tstrs += \"</ul>\"\r\n");
      out.write("\t\t\tstrs += \"<br /><input type='submit' value='绑定权限' />\";\r\n");
      out.write("\t\t\tstrs += \"</form><br />\";\r\n");
      out.write("\t\t\tstrs += \"<input type='button' value='关闭' onclick='fixDivToggle()' />\";\r\n");
      out.write("\t\t\t$(\"#fixDiv div\").html(strs);\r\n");
      out.write("\t\t}, \"json\");\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t//绑定角色\r\n");
      out.write("\tfunction bindingRole(uno, uname) {\r\n");
      out.write("\t\t$(\"#fixDiv div\").empty();\r\n");
      out.write("\t\tfixDivToggle();\r\n");
      out.write("\t\t$.post(\"userRoleAction_findRoleNoBindingListByUser\", \"user.userId=\" + uno, function(data) {\r\n");
      out.write("\t\t\tvar strs = \"\";\r\n");
      out.write("\t\t\tstrs += \"<h2>用户名：\" + uname + \"</h2>\";\r\n");
      out.write("\t\t\tstrs += \"<form action='userRoleAction_addUserRole' method='post'>\";\r\n");
      out.write("\t\t\tstrs += \"<input type='hidden' name='userRole.user.userId' value='\" + uno + \"' />\";\r\n");
      out.write("\t\t\tstrs += \"<ul>\";\r\n");
      out.write("\t\t\t$.each(data.roleList, function(i, v) {\r\n");
      out.write("\t\t\t\tstrs += \"<li><input type='checkbox' name='rno' value='\" + v[0] + \"' />\" + v[1] + \"</li>\";\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\tstrs += \"</ul>\";\r\n");
      out.write("\t\t\tstrs += \"<br /><input type='submit' value='绑定角色' />\";\r\n");
      out.write("\t\t\tstrs += \"</form><br />\";\r\n");
      out.write("\t\t\tstrs += \"<input type='button' value='关闭' onclick='fixDivToggle()' />\";\r\n");
      out.write("\t\t\t$(\"#fixDiv div\").html(strs);\r\n");
      out.write("\t\t}, \"json\");\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t//添加用户验证\r\n");
      out.write("\tfunction validUser(form) {\r\n");
      out.write("\t\tvar $form = $(form);\r\n");
      out.write("\t\tvar userName = $form.children(\"[name='user.userName']\").val();\r\n");
      out.write("\t\tvar userPwd = $form.children(\"[name='user.userPwd']\").val();\r\n");
      out.write("\t\tvar userRealName = $form.children(\"[name='user.userRealName']\").val();\r\n");
      out.write("\t\tvar userJobNum = $form.children(\"[name='user.userJobNum']\").val();\r\n");
      out.write("\t\tvar userJobName = $form.children(\"[name='user.userJobName']\").val();\r\n");
      out.write("\t\tvar userTell = $form.children(\"[name='user.userTell']\").val();\r\n");
      out.write("\t\tvar userEmail = $form.children(\"[name='user.userEmail']\").val();\r\n");
      out.write("\t\tvar userRemark = $form.children(\"[name='user.userRemark']\").val();\r\n");
      out.write("\t\tvar compId = $form.children(\"#compId\").val();\r\n");
      out.write("\t\tvar deptId = $form.children(\"#deptId\").val();\r\n");
      out.write("\t\tvar sectId = $form.children(\"[name='section.sectId']\").val();\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar checkEmail = /^([a-zA-Z0-9]+[_|\\_|\\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\\_|\\.]?)*[a-zA-Z0-9]+\\.[a-zA-Z]{2,3}$/;\r\n");
      out.write("\t\tvar checkTell = /^1\\d{10}$/;\r\n");
      out.write("\t\t/* alert(checkEmail.test(userEmail));\r\n");
      out.write("\t\treturn false; */\r\n");
      out.write("\t\tif(userName == \"\") {\r\n");
      out.write("\t\t\talert(\"用户名不能为空！\");\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t} else if(userName.length > 16) {\r\n");
      out.write("\t\t\talert(\"用户名太长！\");\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t} else if(userPwd.length < 6) {\r\n");
      out.write("\t\t\talert(\"密码太短\");\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t} else if(userPwd.length > 16) {\r\n");
      out.write("\t\t\talert(\"密码太长\");\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t} else if(userRealName == \"\") {\r\n");
      out.write("\t\t\talert(\"真实姓名不能为空！\");\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t} else if(userJobNum == \"\") {\r\n");
      out.write("\t\t\talert(\"工号不能为空！\");\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t} else if(userJobName == \"\") {\r\n");
      out.write("\t\t\talert(\"职务不能为空！\");\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t} else if(!checkTell.test(userTell)) {\r\n");
      out.write("\t\t\talert(\"请填写正确的手机号码！\");\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t} else if(!checkEmail.test(userEmail)) {\r\n");
      out.write("\t\t\talert(\"邮箱格式不正确！\");\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t} else if(compId == 0) {\r\n");
      out.write("\t\t\talert(\"请选择所属公司！\");\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t} else if(deptId == 0) {\r\n");
      out.write("\t\t\talert(\"请选择所属部门！\");\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t} else if(sectId == 0) {\r\n");
      out.write("\t\t\talert(\"请选择所属科室！\");\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
