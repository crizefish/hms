package com.hj.pers.service;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.hj.pers.entites.User;
import com.hj.pers.resp.UserRepository;

 

/**

 *

 *DemoInfo数据处理类

 *

 * @author Angel(QQ:412887952)

 * @version v.0.1

 */

@Service

public class DemoService{

      

       @Resource
       private UserRepository demoInfoRepository;

      

       @Resource
       private RedisTemplate<String,String> redisTemplate;

      
       public void test(){

              ValueOperations<String,String>valueOperations = redisTemplate.opsForValue();

              valueOperations.set("mykey4", "random1="+Math.random());

              System.out.println(valueOperations.get("mykey4"));
              
              User user=new User(3L, "aa123456","123");
              valueOperations.set("com.neox.q", user.toString());
              valueOperations.set("com.neox.w", user.toString());
              boolean exists=redisTemplate.hasKey("com.neox.q");
              if(exists){
                  System.out.println("exists is true");
                  System.out.println(valueOperations.get("com.neox.q"));
              }else{
                  System.out.println("exists i  s false");
              }


       }

      

       //keyGenerator="myKeyGenerator"

       @Cacheable(value="demoInfo") //缓存,这里没有指定key.
       public User findById(long id) {

              System.err.println("DemoInfoServiceImpl.findById()=========从数据库中进行获取的....id="+id);

              return demoInfoRepository.findOne(id);

       }

      

       @CacheEvict(value="demoInfo")
       public void deleteFromCache(long id) {

              System.out.println("DemoInfoServiceImpl.delete().从缓存中删除.");

       }

      

}