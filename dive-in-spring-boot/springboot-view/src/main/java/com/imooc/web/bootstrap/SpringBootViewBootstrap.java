package com.imooc.web.bootstrap;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *  视图引导类
 *  @Author AmVilCresx
 *  @Date 2018/12/6 14:25
 *  @Description
 */
@SpringBootApplication(scanBasePackages = "com.imooc.web")
public class SpringBootViewBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootViewBootstrap.class,args);
    }
}
