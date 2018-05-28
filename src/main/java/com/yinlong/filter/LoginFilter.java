package com.yinlong.filter;

import com.yinlong.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// ��ȡrequest,response,session����
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpServletResponse servletResponse = (HttpServletResponse) response;
		HttpSession session = servletRequest.getSession();

		// ��ȡ�û������URI
		String path = servletRequest.getRequestURI();

		// ��ȡsession���û�����Ϣ
		User user = (User) session.getAttribute("user_login");
		if(user!=null)
			chain.doFilter(request, response);

		// �ж��Ƿ�Ϊ��½���棬����ǵ�½��������У���������û���Ϣ���
		if(path.indexOf("/login.jsp") >-1 || path.contains("userLogin")) {
			chain.doFilter(request, response);
		}else if(!path.contains(".jsp")&&(path.contains(".css")||path.contains(".js")||path.contains(".ttf")||path.contains(".ico")||path.contains("Mobile"))) {
			chain.doFilter(request, response);
		}else {
			if(user == null) {
				servletResponse.sendRedirect("/AfterServiceSystem/pages/login.jsp");
				return;
			}
		}

	}

	public void init(FilterConfig arg0) throws ServletException {
	}

}
