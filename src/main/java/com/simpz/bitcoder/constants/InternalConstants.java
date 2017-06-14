package com.simpz.bitcoder.constants;


public class InternalConstants {
	public static final String COOKIE_STR = "user_cookie";
	public static final String INDEX_URL = "http://localhost/user-manage/management/index.do";
	public static final String LOGIN_URL = "http://localhost/user-manage/management/login.do";
    private static long version  = System.currentTimeMillis();

	public static long getVersion() {
		return version;
	}
}
