package com.cy.interceptor.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

//springmvc web访问拦截器
@Component
public class WebInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//request.setAttribute("webInterceptor", "springmvc拦截器");
		//request.getRequestDispatcher("/login").forward(request, response);
		response.sendRedirect("/login");
		System.out.println("拦截成功");
		return false;
	}
}
