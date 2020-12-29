package com.imooc.diveinspringboot.externalized.configuration.bootstrap;

import com.imooc.diveinspringboot.externalized.configuration.domain.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *  @Author AmVilCresx
 *  @Date 2019/1/14 14:20
 *  @Description spring xml 配置占位符引导类
 */
public class SpringXmlConfigPlaceholderBootstrap {

    public static void main(String[] args) {

        String[] locations = {"META-INF/spring/spring-context.xml", "META-INF/spring/user-context.xml"};

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(locations);

        User user = applicationContext.getBean("user", User.class);

        System.err.println("用户对象 : " + user);

        // 关闭上下文
        applicationContext.close();
    }
}
