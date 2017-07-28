//package com.hj.pers.dbSource;
//
//import java.util.Iterator;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.ValueOperations;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//import com.Application;
//import com.hj.pers.entites.Blogger;
//import com.hj.pers.entites.User;
//import com.hj.pers.resp.BloggerReposity;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = Application.class)
//@WebAppConfiguration 
//public class RedisTest {
//	@Autowired 
//	BloggerReposity bs;
//    @Autowired
//    private RedisTemplate<String, String> redisTemplate;
//    @Autowired
//    private RedisTemplate<String, User> redisTemplateObj;
//
//    @Test
//    public void test() throws Exception {
//    	List<Blogger> allBlogger = bs.findAll();
//    	for (Iterator<Blogger> iterator = allBlogger.iterator(); iterator.hasNext();) {
//			Blogger blogger = (Blogger) iterator.next();
//			System.out.println(blogger.toString());
//			
//		}
//    }
//    @Test
//    public void testq() throws Exception {
//    	redisTemplate.opsForValue().set("aaa", "111");
//    	Assert.assertEquals("111", redisTemplate.opsForValue().get("aaa"));
//    }
//    
//    @Test
//    public void testObj() throws Exception {
//        User user=new User(11L, "aa123456","123");
//        ValueOperations<String, User> operations=redisTemplateObj.opsForValue();
//        operations.set("qq", user);
//        operations.set("aa", user,1,TimeUnit.SECONDS);
//        Thread.sleep(1000);
//        redisTemplate.delete("com.neo.f");
//        boolean exists=redisTemplate.hasKey("com.neo.f");
//        if(exists){
//            System.out.println("exists is true");
//        }else{
//            System.out.println("exists is false");
//        }
//       // Assert.assertEquals("aa", operations.get("com.neo.f").getUserName());
//    }
//}