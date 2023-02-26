package com.yjh.memo.common;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class PermissionInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(
			HttpServletRequest request
			, HttpServletResponse response
			, Object hander) throws IOException {
		
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		
		// user/signin/view
		String url = request.getRequestURI();
		if(userId != null) {
			// 로그인이 되어있는 경우
			// 회원가입페이지, 로그인 페이지를 접근할 경우
			// /user/signin/view /user/signup/view
			// /user로 시작하는 페이지 접근할경우
			if(url.startsWith("/user")) {
				// 메모 리스트 페이지 이동
				response.sendRedirect("/post/list/view");
				return false;
			}
			
		} else {
			// 로그인이 되어있지 않은 경우
			// 메모리스트, 입력화면, 디테일화면으로 접근할 경우
			// /post/..
			if(url.startsWith("/post")) {
				// 로그인 페이지로 이동
				response.sendRedirect("/user/signin/view");
				return false;
			}
		}
		
		return true;
		
		
	}
	
//	@Override
//	public boolean preHandle(
//			HttpServletRequest request
//			, HttpServletResponse response
//			, Object hander
//			, ModelAndView modelAndView) {
//		
//	}

//	@Override
//	public boolean preHandle(
//			HttpServletRequest request
//			, HttpServletResponse response
//			, Object hander
//			, Exception ex) {
//		
//	}
	
}
