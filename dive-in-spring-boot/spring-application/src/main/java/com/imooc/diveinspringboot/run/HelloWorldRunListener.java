package com.imooc.diveinspringboot.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 *  @Author AmVilCresx
 *  @Date 2018/12/3 20:10
 *  @Description
 */
public class HelloWorldRunListener implements SpringApplicationRunListener {

    public HelloWorldRunListener(SpringApplication application, String[] args){}

    @Override
    public void starting() {
        System.out.println("HelloWorldRunListener#starting（）......");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {

    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {

    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {

    }

    @Override
    public void started(ConfigurableApplicationContext context) {

    }

    @Override
    public void running(ConfigurableApplicationContext context) {

    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {

    }
}
