package com.imooc.web.template.engine;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Thymeleaf 模板引擎
 *  @Author AmVilCresx
 *  @Date 2018/12/6 11:02
 *  @Description
 */
public class ThymeleafTemplateBootstrap {

    public static void main(String[] args) throws IOException {
        // 创建引擎
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        // 创建渲染上下文
        Context context = new Context();
        context.setVariable("message","HelloWorld");
        // 读取内容从 cp: templates/thymeleaf/hello-world.html

        ResourceLoader resourceLoader = new DefaultResourceLoader();
        // 通过claspath
        Resource resource = resourceLoader.getResource("classpath:templates/thymeleaf/hello-world.html");
        File templateFile = resource.getFile();
        // 文件流
        FileInputStream inputStream = new FileInputStream(templateFile);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        // copy
        IOUtils.copy(inputStream,outputStream);

        inputStream.close();
        // 模板的内容
        String content = outputStream.toString("UTF-8");;
        // 渲染（处理）结果
        String result = templateEngine.process(content,context);
        // 输出
        System.out.println(result);

    }
}
