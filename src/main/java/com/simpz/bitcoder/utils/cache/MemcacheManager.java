/*  
 * To change this template, choose Tools | Templates  
 * and open the template in the editor.  
 */  
package com.simpz.bitcoder.utils.cache;  
  
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientCallable;
import net.rubyeye.xmemcached.exception.MemcachedException;  
  
/**  
 *缓存工具类  
 */  
@Component  
public class MemcacheManager {  
  
    @Resource  
    private MemcachedClient memcachedClient;  
  
    /**  
     * 添加或修改一个对象到缓存  
     * @param namespace  
     * @param key 缓存key值  
     * @param value 缓存对象（必须是可序列化(Serializer)的对象）  
     * @return   
     */  
    public boolean put(final String namespace, final String key, final Object value) {  
        boolean flag = false;  
        try {  
            this.memcachedClient.withNamespace(namespace,  
                new MemcachedClientCallable<Void>() {  
  
                    @Override  
                    public Void call(MemcachedClient client)  
                            throws MemcachedException, InterruptedException, TimeoutException {  
                        client.set(key, 0, value);  
                        return null;  
                    }  
                });  
            flag = true;  
        } catch (Exception e) {  
        }  
        return flag;  
    }  
  
    /**  
     * 添加一个缓存  
     *  
     * @param namespace  
     * @param key  
     * @param value  
     * @return  
     */  
    public boolean add(final String namespace, final String key, final Object value) {  
        boolean flag = false;  
        try {  
            this.memcachedClient.withNamespace(namespace,  
                    new MemcachedClientCallable<Void>() {  
  
                        @Override  
                        public Void call(MemcachedClient client)  
                                throws MemcachedException, InterruptedException,  
                                TimeoutException {  
                            client.add(key, 0, value);  
                            return null;  
                        }  
                    });  
            flag = true;  
        } catch (Exception e) {  
            
        }  
        return flag;  
    }  
  
    /**  
     * 更新存在的缓存  
     *  
     * @param namespace  
     * @param key  
     * @param value  
     * @return  
     */  
    public boolean update(final String namespace, final String key, final Object value) {  
        boolean flag = false;  
        try {  
            this.memcachedClient.withNamespace(namespace,  
                    new MemcachedClientCallable<Void>() {  
  
                        @Override  
                        public Void call(MemcachedClient client)  
                                throws MemcachedException, InterruptedException,  
                                TimeoutException {  
                            client.replace(key, 0, value);  
                            return null;  
                        }  
                    });  
            flag = true;  
        } catch (Exception e) {  
            
        }  
        return flag;  
    }  
  
    /**  
     * 获取一个缓存对象  
     *  
     * @param <T>  
     * @param namespace  
     * @param key 缓存存储key  
     * @return 缓存对象  
     */  
    public <T> T get(final String namespace, final String key) {  
        T t = null;  
        try {  
            t = this.memcachedClient.withNamespace(namespace,  
                    new MemcachedClientCallable<T>() {  
  
                        @Override  
                        public T call(MemcachedClient client)  
                                throws MemcachedException, InterruptedException,  
                                TimeoutException {  
                            return client.get(key);  
                        }  
                    });  
        } catch (Exception e) {  
            
        }  
        return t;  
    }  
  
    /**  
     * 获取一个缓存对象  
     *  
     * @param <T>  
     * @param namespace  
     * @param key 缓存存储key  
     * @param timeout  
     * @return 缓存对象  
     */  
    public <T> T get(final String namespace, final String key, final long timeout) {  
        T t = null;  
        try {  
            t = this.memcachedClient.withNamespace(namespace,  
                    new MemcachedClientCallable<T>() {  
  
                        @Override  
                        public T call(MemcachedClient client)  
                                throws MemcachedException, InterruptedException,  
                                TimeoutException {  
                            return client.get(key, timeout);  
                        }  
                    });  
        } catch (Exception e) {  
            
        }  
        return t;  
    }  
  
    /**  
     * 获取多个缓存对象  
     *  
     * @param <T>  
     * @param namespace  
     * @param keys 缓存存储key  
     * @return 缓存对象  
     */  
    public <T> Map<String, T> get(final String namespace, final Collection<String> keys) {  
        Map<String, T> valueMap = null;  
        try {  
            valueMap = this.memcachedClient.withNamespace(namespace,  
                    new MemcachedClientCallable<Map<String, T>>() {  
  
                        @Override  
                        public Map<String, T> call(MemcachedClient client)  
                                throws MemcachedException, InterruptedException,  
                                TimeoutException {  
                            return client.get(keys);  
                        }  
                    });  
        } catch (Exception e) {  
            
        }  
        return valueMap;  
    }  
  
    /**  
     * 获取多个缓存对象  
     *  
     * @param <T>  
     * @param namespace  
     * @param keys 缓存存储key  
     * @param timeout  
     * @return 缓存对象  
     */  
    public <T> Map<String, T> get(final String namespace, final Collection<String> keys, final long timeout) {  
        Map<String, T> valueMap = null;  
        try {  
            valueMap = this.memcachedClient.withNamespace(namespace,  
                    new MemcachedClientCallable<Map<String, T>>() {  
  
                        @Override  
                        public Map<String, T> call(MemcachedClient client)  
                                throws MemcachedException, InterruptedException,  
                                TimeoutException {  
                            return client.get(keys, timeout);  
                        }  
                    });  
        } catch (Exception e) {  
            
        }  
        return valueMap;  
    }  
  
    /**  
     * 移除一个缓存对  
     *  
     * @param namespace  
     * @param key 缓存对象key  
     * @return 移除状态  
     */  
    public boolean remove(final String namespace, final String key) {  
        boolean flag = false;  
        try {  
            this.memcachedClient.withNamespace(namespace,  
                    new MemcachedClientCallable<Void>() {  
  
                        @Override  
                        public Void call(MemcachedClient client)  
                                throws MemcachedException, InterruptedException,  
                                TimeoutException {  
//                            client.deleteWithNoReply(key);  
                            client.delete(key);  
                            return null;  
                        }  
                    });  
            flag = true;  
            flag = true;  
        } catch (Exception e) {  
            
        }  
        return flag;  
    }  
  
    /**  
     * 清除命名空间下的缓存数据  
     *  
     * @param namespace  
     * @return 清除状态  
     */  
    public boolean clean(final String namespace) {  
        boolean flag = false;  
        try {  
            this.memcachedClient.invalidateNamespace(namespace);  
            flag = true;  
        } catch (Exception e) {  
            
        }  
        return flag;  
    }  
}  