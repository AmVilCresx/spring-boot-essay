package com.imooc.diveinspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

/**
 * {@link SpringApplication} 引导类
 * */
//@SpringBootApplication
public class SpringApplicationBootstrap {

    public static void main(String[] args) {
       // SpringApplication.run(ApplicationConfiguration.class,args);
        Set<String> sources = new HashSet<>();
        sources.add(ApplicationConfiguration.class.getName());
        SpringApplication springApplication = new SpringApplication();
        springApplication.setSources(sources);
        //springApplication.setWebApplicationType(WebApplicationType.NONE);
        springApplication.run(args);
    }

    @SpringBootApplication
    public static class ApplicationConfiguration{

    }
}
