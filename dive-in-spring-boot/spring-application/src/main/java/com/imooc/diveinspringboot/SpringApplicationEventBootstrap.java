package com.imooc.diveinspringboot;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 *  @Author AmVilCresx
 *  @Date 2018/12/3 20:01
 *  @Description
 */
public class SpringApplicationEventBootstrap {

    public static void main(String[] args) {
        // 创建上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        // 注册应用事件监听器
        context.addApplicationListener(event -> {
            System.out.println("监听到事件：" + event);
        });

        // 启动上下文
        context.refresh();

        // 发送事件
        context.publishEvent("你好，世界！");
        context.publishEvent("2018");
        context.publishEvent(new ApplicationEvent("Hello World") {

        });

        // 关闭上下文
        context.close();
    }
}
