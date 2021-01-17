package com.liuwq.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// 这里写错了，报错的意思是spring里面找不到userMapper这个对象：No qualifying bean of type 'com.liuwq.demo.dao.UserMapper' available
@MapperScan("com.liuwq.demo.dao")
public class DemoApplication {

    // 启动项目，只要运行这个main方法，不需要配tomcat了
    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
    }

}
