package com.imooc.diveinspringboot.configuration;

import com.imooc.diveinspringboot.annotation.EnableHelloWorld;
import com.imooc.diveinspringboot.condition.ConditionalOnSystemProperty;
import org.springframework.context.annotation.Configuration;

/**
 * 自动化装配
 * */

@Configuration // spring模式注解
@EnableHelloWorld // spring @Enable 模块装配
@ConditionalOnSystemProperty(name="user.name",value = "dell") // 条件装配
public class HelloWorldAutoConfiguration {
}
