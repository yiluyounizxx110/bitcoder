package com.simpz.bitcoder.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
/**
 * @ClassName: WebUtil    
 * @Description: TODO   
 * @author: xingxing.zhu    
 * @date: 2016年1月5日 下午2:56:50    
 * @version: V1.0
 */
public class WebUtil
{
  
  public static String getCookieValue(HttpServletRequest httpServletRequest, String cookieName)
  {
    String returnValue = null;
    Cookie[] cookies = httpServletRequest.getCookies();
    if (ArrayUtils.isNotEmpty(cookies)) {
      for (Cookie oneCookie : cookies) {
        if (StringUtils.equalsIgnoreCase(cookieName, oneCookie.getName()))
        {
          returnValue = oneCookie.getValue();
          break;
        }
      }
    }
    return returnValue;
  }
  
  /**
	 * 设置cookie
	 * @param name
	 * @param value
	 * @param domain
	 * @param expire
	 */
	public static void setCookie(HttpServletResponse response,String name, String value, String domain, int expire) {
		Cookie cookie = new Cookie(name, value);
		cookie.setDomain(domain);
		cookie.setPath("/");
		if (expire >= 0) {
			cookie.setMaxAge(expire);
		}
		response.addCookie(cookie);
	}
	/**
	 * 设置cookie
	 * @param name
	 * @param value
	 * @param domain
	 * @param expire
	 */
	public static void setNoDomainCookie(HttpServletResponse response,String name, String value,int expire) {
		Cookie cookie = new Cookie(name, value);
		cookie.setPath("/");
		if (expire >= 0) {
			cookie.setMaxAge(expire);
		}
		response.addCookie(cookie);
	}
}
