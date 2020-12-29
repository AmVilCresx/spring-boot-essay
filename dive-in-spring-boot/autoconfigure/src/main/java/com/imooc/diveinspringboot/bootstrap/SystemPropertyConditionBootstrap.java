package com.imooc.diveinspringboot.bootstrap;

import com.imooc.diveinspringboot.condition.ConditionalOnSystemProperty;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * 系统属性条件引导类
 * */
public class SystemPropertyConditionBootstrap {

    @Bean
    @ConditionalOnSystemProperty(name="user.name",value = "AmVilCres")
    public String helloWorld(){
        return "Hello World!";
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(SystemPropertyConditionBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        String hello = context.getBean("helloWorld",String.class);
        System.out.println("hello = "+hello);

        context.close();
    }
}

