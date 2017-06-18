package com.simpz.bitcoder.utils;

import org.junit.Before;
import org.junit.Test;

import com.simpz.bitcoder.BaseTest;
import com.simpz.bitcoder.utils.cache.JedisTemplate;

public class RedisTemplateTest extends BaseTest{

	private JedisTemplate jedisTemplate;
	
	@Before
	public void setUp(){
		jedisTemplate = (JedisTemplate) getBean("jedisTemplate");
	}
	
	@Test
	public void test(){
		jedisTemplate.set("test", "123123123");
	}
	@Test
	public void get(){
		String val = jedisTemplate.get("test");
		System.out.println(val);
	}
	
}
