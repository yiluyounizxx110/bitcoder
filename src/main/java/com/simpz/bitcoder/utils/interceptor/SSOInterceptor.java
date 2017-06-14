package com.simpz.bitcoder.utils.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SSOInterceptor extends HandlerInterceptorAdapter {
    public static final String LOGIN_URL = "ftltest/login.do";
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response,
			Object handler) throws Exception {
//		String cookieValue = WebUtil.getCookieValue(request, InternalConstants.COOKIE_STR);
//		String currentUrl = request.getRequestURL().toString();
////		String loginFullPath = request.getRequestURI() + request.getContextPath() + LOGIN_URL;
//		if(InternalConstants.LOGIN_URL.equals(currentUrl)){
//			System.out.println("true");
//			return true;
//		}
//		if(StringUtils.isEmpty(cookieValue)){
//			response.sendRedirect(InternalConstants.LOGIN_URL);
//			return false;
//		}else{
//			return true;
//		}
		return true;
	}

}
