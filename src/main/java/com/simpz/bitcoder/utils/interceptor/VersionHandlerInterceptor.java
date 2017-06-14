package com.simpz.bitcoder.utils.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.simpz.bitcoder.constants.InternalConstants;

import freemarker.ext.beans.BeansWrapper;

/**
 * 将页面要访问的静态变量设置到视图中
 * @ClassName: ContractHandlerInterceptor    
 * @Description: TODO   
 * @author: xingxing.zhu    
 * @date: 2015年10月22日 下午7:55:04    
 * @version: V1.0
 */
public class VersionHandlerInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response,
			Object handler) throws Exception {
		return true;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response,
			Object handler,
			ModelAndView modelAndView) throws Exception {
		if (modelAndView == null) {
			modelAndView = new ModelAndView();
		}
		modelAndView.addObject("version", InternalConstants.getVersion());
		modelAndView.addObject("enums",BeansWrapper.getDefaultInstance().getEnumModels());
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response,
			Object handler,
			Exception ex) throws Exception {
	}

}