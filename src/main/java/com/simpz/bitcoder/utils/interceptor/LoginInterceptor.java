package com.simpz.bitcoder.utils.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response,
			Object handler) throws Exception {
//		String currentUrl = request.getRequestURL().toString();
////		String url = request.getRequestURI();
//		if(InternalConstants.LOGIN_URL.equals(currentUrl) || InternalConstants.INDEX_URL.equals(currentUrl)){
//			return true;
//		}
//		String cookieValue = WebUtil.getCookieValue(request, InternalConstants.COOKIE_STR);
//		if(StringUtils.isEmpty(cookieValue)){
//			response.sendRedirect(InternalConstants.INDEX_URL);
//			return false;
//		}
		return true;
	}

}
