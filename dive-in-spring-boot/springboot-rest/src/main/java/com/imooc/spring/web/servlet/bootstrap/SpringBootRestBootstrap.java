package com.imooc.spring.web.servlet.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *  SpringBootRest 引导类
 *  @Author AmVilCresx
 *  @Date 2018/12/7 10:42
 *  @Description
 */

@SpringBootApplication(scanBasePackages = "com.imooc.web")
public class SpringBootRestBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestBootstrap.class,args);
    }
}
