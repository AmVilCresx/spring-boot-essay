package com.imooc.diveinspringboot.context;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;

public class AfterHelloWorldApplicationContextInitializer <C extends ConfigurableApplicationContext>  implements ApplicationContextInitializer<C> , Ordered {

    @Override
    public void initialize(C applicationContext) {
        System.out.println("After--applicationContext.Id() = "+applicationContext.getId());
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
