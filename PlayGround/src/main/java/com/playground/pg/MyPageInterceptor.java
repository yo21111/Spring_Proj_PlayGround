package com.playground.pg;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class MyPageInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("uId_Session");
		
		if (id == null) {
			PrintWriter printwriter = response.getWriter();
			printwriter.print("<script>alert('로그인 이후 사용 가능합니다.');</script>");
			printwriter.flush();
			printwriter.close();
			response.sendRedirect(request.getContextPath()+"/Login/Login");
			return false;
		}
		
		return true;
	}
	
}
