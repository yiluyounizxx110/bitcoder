/*package com.simpz.bitcoder.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.danga.MemCached.MemCachedClient;


public class MemcacheUtil {
	public static Integer MAX_EXPIRY_TIME = 24*60*60;
	
    public static MemCachedClient getMemCachedClient() {
        return SpringContextHolder.getBean("memcachedClient1");
    }
    
    public static Object get(String key){
    	return MemcacheUtil.getMemCachedClient().get("memcachedPool_" + key);
    }
    
    public static void set(String key,Object value,Date expiry){
//    	MemcacheUtil.getMemCachedClient().set(key, value, expiry);
    	MemcacheUtil.getMemCachedClient().set(key, value);
    }
    
    public static void set(String key,Object value){
    	Calendar calendar = Calendar.getInstance();
    	calendar.add(Calendar.SECOND, MAX_EXPIRY_TIME);
    	System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime()));
    	MemcacheUtil.set("memcachedPool_" + key, value, calendar.getTime());
    }
    
    *//** 
     * MemCache通过compare and set即cas协议实现原子更新，类似乐观锁，每次请求存储某个数据都要附带一个cas值，MemCache 
     * 比对这个cas值与当前存储数据的cas值是否相等，如果相等就覆盖老数据，如果不相等就认为更新失败，这在并发环境下特别有用 
     *//*  
     public boolean update(String key, Integer i) throws Exception  
     {  
    	 MemcachedItem result = MemcacheUtil.getMemCachedClient().gets(key);  
        long cas = result.getCas();  
          
  // 尝试更新key对应的value  
        if (!mc.cas(key, 0, i, cas))  
        {  
            return false;  
        }  
        return true;  
     }  
}*/