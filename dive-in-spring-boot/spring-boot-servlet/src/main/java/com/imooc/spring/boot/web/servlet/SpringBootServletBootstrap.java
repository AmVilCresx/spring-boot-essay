package com.imooc.spring.boot.web.servlet;

import com.imooc.spring.web.servlet.AsyncServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration.Dynamic;
import java.util.EnumSet;

/**
 *  @Author AmVilCresx
 *  @Date 2018/12/11 14:15
 *  @Description
 */
@EnableAutoConfiguration
//@ServletComponentScan(basePackages = "com.imooc.spring.web.servlet")
public class SpringBootServletBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootServletBootstrap.class,args);
    }

    @Bean
    public ServletContextInitializer servletContextInitializer(){
        return servletContext -> {
            CharacterEncodingFilter filter = new CharacterEncodingFilter();
            Dynamic registration = servletContext.addFilter("filter",filter);
            registration.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST),false,"/");
        };
    }

    @Bean
    public ServletRegistrationBean asyncServletRegistrationBean(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new AsyncServlet(),"/async-servlet");

        return registrationBean;
    }
}

