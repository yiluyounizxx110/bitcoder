package com.simpz.bitcoder.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.simpz.bitcoder.dao.MongoDao;
import com.simpz.bitcoder.model.mongoentity.User;
import com.simpz.bitcoder.utils.cache.MemcacheManager;

@Controller
public class UserController {
//
//	@Autowired
//	private UserService userService;
	
	@Autowired
	private MemcacheManager memcacheManager;
	
	@Autowired
	private MongoDao mongoDao;
	
	public static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping("index")
	public ModelAndView index(){
//		List<UserPo> userPoList = userService.getAllUser();
//		MemcacheUtil.set("user_names", "xingxing.zhu");
//		String object1 = (String) MemcacheUtil.get("user_names");
		memcacheManager.put("Meme", "user", "xingxing.zhu");
		Object object = memcacheManager.get("Meme", "user");
		System.out.println(object);
		return new ModelAndView("index");
	}
	
	@RequestMapping("mongotest")
	@ResponseBody
	public Object mogotest(){
		/*BitPo po = new BitPo();
		po.setAddress("湖北省武汉市狮子山街一号");
		po.setAge(12);
//		po.setId(1);
		po.setName("朱星星");
		
		BitPo po1 = mongoDao.save(po);
		
		System.out.println(ToStringBuilder.reflectionToString(po1));
		
		Set<String> set = mongoDao.getCollectionNames();
		System.out.println(ToStringBuilder.reflectionToString(set));*/
		User user = new User();
				
		user.setAddress("insert");
		user.setAge(12);
		user.setName("朱星星");
		user.setCreateTime(Calendar.getInstance().getTime());
		
		User user1 = new User();
		
		user1.setAddress("insert collectionname");
		user1.setAge(12);
		user1.setName("朱星星");
		user1.setCreateTime(Calendar.getInstance().getTime());
		
		User user2 = new User();
		
		user2.setAddress("batch  insert collectionname");
		user2.setAge(12);
		user2.setName("朱星星");
		user2.setCreateTime(Calendar.getInstance().getTime());
		
		User user3 = new User();
		
		user3.setAddress("batch  insert collectionname2");
		user3.setAge(12);
		user3.setName("朱星星");
		user3.setCreateTime(Calendar.getInstance().getTime());
		
		List<User> userList = new ArrayList<>();
		userList.add(user2);
		userList.add(user3);
		
		User user4 = new User();
		
		user4.setAddress("batch  insert collectionname");
		user4.setAge(12);
		user4.setName("朱星星");
		user4.setCreateTime(Calendar.getInstance().getTime());
		
		User user5 = new User();
		
		user5.setAddress("batch  insert collectionname2");
		user5.setAge(12);
		user5.setName("朱星星");
		user5.setCreateTime(Calendar.getInstance().getTime());
		
		List<User> userList2 = new ArrayList<>();
		userList2.add(user4);
		userList2.add(user5);
		
//		User user01 = mongoDao.insert(user);
//		User user02 = mongoDao.insert(user1,"user");
//		int size1 = mongoDao.batchInsert(userList, "user");
		/*int size2 = mongoDao.batchInsert(userList2, User.class);*/
		
//		List<User> users = mongoDao.query(user1);
//		List<User> users = mongoDao.pageQuery();
		
//		logger.info("user:" + JSONObject.toJSONString(userList));
//		return mongoDao.distinct();
		return mongoDao.findById();
//		return new ModelAndView("index");
	}
}
