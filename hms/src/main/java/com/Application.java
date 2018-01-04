package com;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication 
public class Application {
	
	   @Bean
	    public RestTemplate restTemplate(ClientHttpRequestFactory factory){
	        return new RestTemplate(factory);
	    }
	
	   @Bean
	    public ClientHttpRequestFactory simpleClientHttpRequestFactory(){
	        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
	        factory.setReadTimeout(5000);//ms
	        factory.setConnectTimeout(15000);//ms
	        return factory;
	    }
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}
