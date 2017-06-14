package com.simpz.bitcoder.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.mapping.ResultMap;
import org.apache.ibatis.mapping.ResultMapping;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;


public class MySQLBaseDao extends SqlSessionDaoSupport{
	  
	public static final int BATCH_DEAL_NUM = 10;
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
	/* 
	 * @Title: batchInsert    
	 * @Description: 批量插入    
	 * @param statement
	 * @param list
	 * @return int   
	 * @throws
	 */
	public int batchInsert(String statement, List<?> list) {
		int i = 0;
		if(StringUtils.isEmpty(statement)||list.isEmpty()){
			logger.warn("batchInsert-->statement or insertList is null");
			return i;
		}
		SqlSession batchSession = getSqlSessionFactory().openSession(ExecutorType.BATCH, false);  
	    int cnt = list.size();
	    for(; i < cnt; i++) {  
	        batchSession.insert(statement, list.get(i));  
	        if((i + 1) % BATCH_DEAL_NUM == 0) {//Constants.BATCH_DEAL_NUM为批量提交的条数  
	            batchSession.flushStatements();  
	        }  
	    }  
	    batchSession.flushStatements();  
	    batchSession.close();  
	    return i;  
	}  
	/**
	 * 
	 * @Title: batchUpdate    
	 * @Description: 批量更新    
	 * @param statement
	 * @param list
	 * @return int   
	 * @throws
	 */
	public int batchUpdate(String statement, List<?> list) {
		int i = 0;
		if(StringUtils.isEmpty(statement)||list.isEmpty()){
			logger.warn("batchUpdate-->statement or updateList is null");
			return i;
		}
		SqlSession batchSession = getSqlSessionFactory().openSession(ExecutorType.BATCH, false);  
	    int cnt = list.size();
	    for(; i < cnt; i++) {  
	        batchSession.update(statement, list.get(i));  
	        if((i + 1) %  BATCH_DEAL_NUM == 0) {  
	            batchSession.flushStatements();  
	        }  
	    }  
	    batchSession.flushStatements();  
	    batchSession.close();  
	    return i;  
	}  
	/**
	 * @Title: batchDelete    
	 * @Description: 批量删除   
	 * @param statement
	 * @param list
	 * @return int   
	 * @throws
	 */
	public int batchDelete(String statement, List<?> list) {
		int i = 0;
		if(StringUtils.isEmpty(statement)||list.isEmpty()){
			logger.warn("batchDelete-->statement or deleteList is null");
			return i;
		}
	    SqlSession batchSession = getSqlSessionFactory().openSession(ExecutorType.BATCH, false);  
	    int cnt = list.size();
	    for(; i < cnt; i++) {  
	        batchSession.delete(statement, list.get(i));  
	        if((i + 1) %  BATCH_DEAL_NUM == 0) {  
	            batchSession.flushStatements();  
	        }  
	    }  
	    batchSession.flushStatements();  
	    batchSession.close();  
	    return i;  
	}  

	/**
     * 
     * @Title: getColumnByResultMap    
     * @Description: 根据resultMap的映射获取数据库列名
     * @param id 
     * @param property
     * @return   
     * @return String   
     * @throws
     */
    public String getColumnByResultMap(String id,
            String property) {
        if (StringUtils.isEmpty(id) || StringUtils.isEmpty(property)) {
            return property;
        }
        // 取得Configuration ,获取到对应的resultMap
        ResultMap map = getSqlSessionFactory().getConfiguration().getResultMap(id);
        List<ResultMapping> mapping = map.getResultMappings();

        for (ResultMapping mp : mapping) {
            if (mp.getProperty().equals(property)) {
                return mp.getColumn();
            }
        }
        return property;
    }

}
