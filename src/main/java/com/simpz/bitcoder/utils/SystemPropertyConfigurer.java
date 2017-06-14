package com.simpz.bitcoder.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;  

/**
 * 获取spring 中的占位符
 * 所有配置文件由spring 加载，然后统一从该类获取
 */
public class SystemPropertyConfigurer extends PropertyPlaceholderConfigurer {  
  
    private static Map<String, String> ctxPropertiesMap = new HashMap<String, String>();  
  
    @Override  
    protected void processProperties(ConfigurableListableBeanFactory beanFactory,  
            Properties props)throws BeansException {  
  
        super.processProperties(beanFactory, props);  
        for (Object key : props.keySet()) {  
            String keyStr = key.toString();  
            String value = props.getProperty(keyStr);  
            ctxPropertiesMap.put(keyStr, value);  
        }  
    }  
  
    //static method for accessing context properties  
    public static String getContextProperty(String name) {  
        return ctxPropertiesMap.get(name);  
    }  
} 