package com.imooc.spring.web.servlet.support;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 *  Spring web Mvc 自动装配 {@link AbstractAnnotationConfigDispatcherServletInitializer} 默认实现
 *
 *  @Author AmVilCresx
 *  @Date 2018/12/5 20:02
 *  @Description
 */
@ComponentScan(basePackages = "com.imooc.spring.web.servlet.controller")
public class DefaultAnnotationConfigDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * 对应 web.xml 的 init -param 参数 配置
     * */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    /**
     * DispatcherServlet
     * */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{this.getClass()}; // 返回当前类
    }

    /**
     * 映射关系
     * */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
