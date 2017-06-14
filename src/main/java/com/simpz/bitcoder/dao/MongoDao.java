package com.simpz.bitcoder.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.simpz.bitcoder.model.mongoentity.User;
import com.simpz.bitcoder.model.po.BitPo;

@Repository
public class MongoDao {
	/** 
     * 操作mongodb的类,可以参考api 
     */  
    @Autowired  
    private MongoTemplate mongoTemplate;  
      
    /** 
     * 保存用户信息 
     * @param userBo 
     * @return 
     */  
    public BitPo save(BitPo bitPo) {  
        mongoTemplate.save(bitPo);  
        return bitPo;  
    }  
    
    public User insert(User user){
    	mongoTemplate.insert(user);
		return user;
    }
    public User insert(User user,String clazz){
    	mongoTemplate.insert(user,clazz);
    	return user;
    }
    
    public int batchInsert(List<User> users,Class<?> clazz){
    	mongoTemplate.insert(users,clazz);
		return users.size();
    }
    
    public int batchInsert(List<User> users,String clazz){
    	mongoTemplate.insert(users,clazz);
		return users.size();
    }

    /** 
     * 获取所有集合的名称 
     * @return 
     * @date 2016年7月7日 下午8:27:28 
     */  
    public Set<String> getCollectionNames() {  
        Set<String> collections = mongoTemplate.getCollectionNames();  
        return collections;  
    }  
      
    /***
     *  
     * @Title: selectPage    
     * @Description: TODO    
     * @param userBo
     * @param pager
     * @return   
     * @return Pager   
     * @throws
     */
    /*public Pager selectPage(UserBo userBo,Pager pager){  
        Query query = new Query();  
        query.skip((pager.getPageNum()-1)*pager.getPageSize());  
        query.limit(pager.getPageSize());  
        Criteria criteria = new Criteria(); 
        query.addCriteria(criteria);  
        long total = mongoTemplate.count(query, UserBo.class);  
        List<UserBo> users = mongoTemplate.find(query, UserBo.class);  
        pager.setResult(users);  
        pager.setTotal(total);  
        return pager;  
    }  */
    
    @SuppressWarnings("unused")
	public List<User> query(User user){
    	Query query = new Query();
    	query.addCriteria(Criteria.where("name").is("朱星星"));
    	List<User> user1 = mongoTemplate.find(query, User.class);
    	User user12 = mongoTemplate.findOne(query, User.class);
    	return user1;
    }
    @SuppressWarnings("unused")
	public List<User> query1(){
    	Query query = new Query();
    	Criteria criteria = new Criteria();
    	criteria.and("name").is("朱星星");
    	Calendar calendar = Calendar.getInstance();
    	calendar.set(Calendar.MINUTE, 20);
    	criteria.and("createTime").lt(calendar.getTime());
    	query.addCriteria(criteria);
    	
    	Query query1 = new Query();
    	Criteria criteria1 = new Criteria();
    	criteria1.and("name").is("朱星星");
    	Calendar calendar1 = Calendar.getInstance();
    	calendar1.set(Calendar.MINUTE, 20);
    	criteria1.and("createTime").gt(calendar1.getTime());
    	query1.addCriteria(criteria1);
    	
    	List<User> user1 = mongoTemplate.find(query, User.class);
    	List<User> user2 = mongoTemplate.find(query1, User.class);
    	return user1;
    }
    
    public List<User> queryOr(){
    	Query query = new Query();
    	Criteria criteria = new Criteria();
    	criteria.orOperator(Criteria.where("age").is(18),Criteria.where("age").gt(18));
    	query.addCriteria(criteria);
    	List<User> users = mongoTemplate.find(query, User.class);
    	return users;
    }
    
    @SuppressWarnings("unused")
	public List<User> pageQuery(){
    	Query query = new Query();
    	Criteria criteria = Criteria.where("age").gt(15);
    	query.addCriteria(criteria);
    	long size = mongoTemplate.count(query, User.class);
    	query.skip(3).limit(5);
    	List<Order> orders = new ArrayList<>();
    	orders.add(new Order(Direction.DESC,"age"));
    	query.with(new Sort(orders));
    	List<User> users = mongoTemplate.find(query, User.class);
    	return users;
    }
    
    public Object distinct(){
    	@SuppressWarnings("unchecked")
		List<Integer> list = mongoTemplate.getCollection("user").distinct("age");
    	return list;
    } 
    
    public Object findById(){
    	return mongoTemplate.findById("58d7e5ced3bbdaf0db37af86", User.class);
    }
}
