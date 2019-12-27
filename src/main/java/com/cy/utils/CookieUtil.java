package com.cy.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
	//1.删除cookie信息
	public static void deleteCookie(String cookieName,String path,String domain,HttpServletResponse response) {
		Cookie cookie = new Cookie(cookieName, "");
		cookie.setMaxAge(0);
		cookie.setPath(path);
		cookie.setDomain(domain);
		response.addCookie(cookie);
	}
	
	//2.获取cookie信息 返回对象
	public static Cookie getCookie(HttpServletRequest request,String cookieName) {
		Cookie[] cookies = request.getCookies();
		if(cookies!=null && cookies.length>0) {
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals(cookieName)) {
					return cookie;
				}
			}
		}
		return null;
	}
	
}
