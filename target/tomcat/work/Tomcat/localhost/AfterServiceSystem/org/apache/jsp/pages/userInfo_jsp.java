/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.37
 * Generated at: 2018-07-11 09:15:44 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class userInfo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">\r\n");
      out.write("\t<title>Insert title here</title>\r\n");
      out.write("\t\r\n");
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
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery-3.3.1.min.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"larry-wrapper\">\r\n");
      out.write("\t\t<div class=\"larry-personal\">\r\n");
      out.write("\t\t\t<header class=\"larry-personal-tit\">\r\n");
      out.write("\t\t\t\t<span>根据条件筛选</span>\r\n");
      out.write("\t\t\t</header>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div class=\"larry-personal-body clearfix\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<form class=\"layui-form\" action=\"userAction_findUserListLike\" method=\"post\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t\t\t<label class=\"layui-form-label\">姓名</label>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"user.userRealName\" placeholder=\"请输入\" autocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\t\t\t\r\n");
      out.write("\t\t\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t\t\t<label class=\"layui-form-label\">工号</label>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"user.userJobNum\" placeholder=\"请输入\" autocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\t\t\t\r\n");
      out.write("\t\t\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t\t\t<label class=\"layui-form-label\">职务</label>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"user.userJobName\" placeholder=\"请输入\" autocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\t\t\t\r\n");
      out.write("\t\t\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t\t\t<label class=\"layui-form-label\">电话</label>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"user.userTell\" placeholder=\"请输入\" autocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\t\t\t\r\n");
      out.write("\t\t\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t\t\t<label class=\"layui-form-label\">邮箱</label>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"user.userEmail\" placeholder=\"请输入\" autocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\t\t\t\r\n");
      out.write("\t\t\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t\t\t<label class=\"layui-form-label\">备注</label>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"user.userRemark\" placeholder=\"请输入\" autocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<div class=\"layui-inline\">\r\n");
      out.write("\t\t\t\t\t\t<label class=\"layui-form-label\">选择归属</label>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t\t\t<select name=\"company.compId\" lay-filter=\"findDepartmentList\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"\">请选择公司</option>\r\n");
      out.write("\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t\t\t<select name=\"department.deptId\" lay-filter=\"findSectionList\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"\">请选择部门</option>\r\n");
      out.write("\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"layui-input-inline\">\r\n");
      out.write("\t\t\t\t\t\t\t<select name=\"section.sectId\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"\">请选择科室</option>\r\n");
      out.write("\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<div class=\"layui-form-item\">\r\n");
      out.write("\t\t\t\t\t<div class=\"layui-input-block\">\r\n");
      out.write("\t\t\t\t\t\t<button type=\"button\" class=\"layui-btn\" onclick=\"buildTable()\">立即查询</button>\r\n");
      out.write("\t\t\t\t\t\t<button type=\"reset\" class=\"layui-btn layui-btn-primary\">重置</button>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<table class=\"layui-hide\" id=\"userTab\" lay-data=\"{id: 'idTest'}\"></table>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/layui.js\"></script>\r\n");
      out.write("\t<script>\r\n");
      out.write("\tlayui.use(['jquery', 'layer', 'form', 'element'], function(){\r\n");
      out.write("\t\tvar layer = layui.layer\r\n");
      out.write("\t\t,form = layui.form\r\n");
      out.write("\t\t,element = layui.element\r\n");
      out.write("\t\t,$ = layui.$\r\n");
      out.write("\t\t,table = layui.table\r\n");
      out.write("\r\n");
      out.write("\t\t//获取公司\r\n");
      out.write("\t\t$.post(\"companyAction_findCompanyListJson\", \"\", function(data){\r\n");
      out.write("\t\t\tvar str = \"\";\r\n");
      out.write("\t\t\t$.each(data.list, function(i, v) {\r\n");
      out.write("\t\t\t\tstr += \"<option value='\" + v.compId + \"'>\" + v.compName + \"</option>\";\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t$(\"select[name='company.compId']\").append(str);\r\n");
      out.write("\t\t\tform.render();\r\n");
      out.write("\t\t}, \"json\");\r\n");
      out.write("\r\n");
      out.write("\t\t//根据公司ID获取部门\r\n");
      out.write("\t\tform.on('select(findDepartmentList)', function(data){\r\n");
      out.write("\t\t\t$.post(\"departmentAction_findDepartmentList\", \"company.compId=\" + data.elem.value, function(data) {\r\n");
      out.write("\t\t\t\t$(\"#deptId option:not(:first)\").remove();\r\n");
      out.write("\t\t\t\tvar str = \"\";\r\n");
      out.write("\t\t\t\t$.each(data.list, function(i, v) {\r\n");
      out.write("\t\t\t\t\tstr += \"<option value='\" + v.deptId + \"'>\" + v.deptName + \"</option>\";\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t\t$(\"select[name='department.deptId']\").append(str);\r\n");
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
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\twindow.onload = buildTable();\r\n");
      out.write("\t\r\n");
      out.write("\t//生成表格\r\n");
      out.write("\tfunction buildTable() {\r\n");
      out.write("\t\tlayui.use('table', function(){\r\n");
      out.write("\t\t\t  var table = layui.table;\r\n");
      out.write("\t\t\t  \r\n");
      out.write("\t\t\t  table.render({\r\n");
      out.write("\t\t\t    elem: '#userTab'\r\n");
      out.write("\t\t\t\t,url:'userAction_findUserListLike?' + $(\"form:first\").serialize()\r\n");
      out.write("\t\t\t\t,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增\r\n");
      out.write("\t\t\t    ,cols: [[\r\n");
      out.write("\t\t\t    \t   {type:'numbers', title: '序号'}\r\n");
      out.write("\t\t\t\t      ,{field:'userId', title: 'ID', sort: true}\r\n");
      out.write("\t\t\t\t      ,{field:'userName', title: '用户名'}\r\n");
      out.write("\t\t\t\t      ,{field:'userPwd', title: '密码'}\r\n");
      out.write("\t\t\t\t      ,{field:'userRealName', title: '真实姓名'}\r\n");
      out.write("\t\t\t\t      ,{field:'userJobNum', title: '工号'}\r\n");
      out.write("\t\t\t\t      ,{field:'userJobName', title: '职务'}\r\n");
      out.write("\t\t\t\t      ,{field:'userTell', title: '电话'}\r\n");
      out.write("\t\t\t\t      ,{field:'userEmail', title: '邮箱'}\r\n");
      out.write("\t\t\t\t      ,{field:'userRemark', title: '备注'}\r\n");
      out.write("\t\t\t\t      ,{field:'section', title: 'OO' ,  templet: '<div>{{d.section.department.company.compName}}</div>'}\r\n");
      out.write("\t\t\t\t      ,{field:'section', title: 'OO' ,  templet: '<div>{{d.section.department.deptName}}</div>'}\r\n");
      out.write("\t\t\t\t      ,{field:'section', title: 'OO' ,  templet: '<div>{{d.section.sectName}}</div>'}\r\n");
      out.write("\t\t\t    ]]\r\n");
      out.write("\t\t\t    ,page: true\r\n");
      out.write("\t\t\t  });\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t</script>\r\n");
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
