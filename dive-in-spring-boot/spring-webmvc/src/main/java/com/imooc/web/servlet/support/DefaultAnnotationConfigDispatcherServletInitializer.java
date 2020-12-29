package com.imooc.web.servlet.support;

import com.imooc.web.config.DispatcherServletConfiguration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 *  Spring web Mvc 自动装配 {@link AbstractAnnotationConfigDispatcherServletInitializer} 默认实现
 *
 *  @Author AmVilCresx
 *  @Date 2018/12/5 20:02
 *  @Description
 */

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
        return new Class[]{DispatcherServletConfiguration.class};
    }

    /**
     * 映射关系
     * */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
