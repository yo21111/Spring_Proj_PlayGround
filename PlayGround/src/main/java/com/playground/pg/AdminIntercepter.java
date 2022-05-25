package com.playground.pg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.playground.pg.service.FaqService;

public class AdminIntercepter extends HandlerInterceptorAdapter {
	@Autowired
	FaqService faqService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		// 세션에서 아이디를 가져옴 
		String id = (String)session.getAttribute("uId_Session");
		
		if (id == null) {
			return false;
		}
		
		// 관리자 아이디가 맞으면 true 반환
		boolean result = faqService.adminChk(id);
		
		
		return result;
	}
}
