package com.yjj.fresh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EnableEurekaClient
@EnableRedisHttpSession
@MapperScan("com.yjj.fresh.mapper")
public class OrderApplication {
    public static void main( String[] args ){
        SpringApplication.run(OrderApplication.class, args);
    }
}
