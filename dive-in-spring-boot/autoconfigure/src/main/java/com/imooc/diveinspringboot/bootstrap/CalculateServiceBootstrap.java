package com.imooc.diveinspringboot.bootstrap;

import com.imooc.diveinspringboot.service.CalculateService;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * {@link CalculateService} 引导类
 * */
@SpringBootApplication(scanBasePackages = "com.imooc.diveinspringboot.service")
public class CalculateServiceBootstrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =new SpringApplicationBuilder(CalculateServiceBootstrap.class)
                .web(WebApplicationType.NONE)
                .profiles("Java8")
                .run(args);

        CalculateService calculateService  = context.getBean(CalculateService.class);
        System.out.println("calculate = "+calculateService.sum(1,2,3,4,5));

        context.close();
    }

}
