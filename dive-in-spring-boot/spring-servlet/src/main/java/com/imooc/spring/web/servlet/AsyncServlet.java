package com.imooc.spring.web.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/** 异步 Servlet
 *  @author AmVilCresx
 *  @date 2018/12/11 11:26
 **/
@WebServlet(
        asyncSupported = true, // 激活异步特性
        name = "asyncServlet",
        urlPatterns = "/async-servlet"
)
public class AsyncServlet extends HttpServlet {

    // 覆盖service

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 判断是否支持异步
        if(req.isAsyncStarted()){
            // 创建AsyncContext
            AsyncContext asyncContext = req.startAsync();
            // 设置超时时间
            asyncContext.setTimeout(50L);
            asyncContext.addListener(new AsyncListener() {
                @Override
                public void onComplete(AsyncEvent event) throws IOException {
                    println("执行完成");
                }

                @Override
                public void onTimeout(AsyncEvent event) throws IOException {
                    HttpServletResponse servletResponse = (HttpServletResponse) event.getSuppliedResponse();
                    servletResponse.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
                    println("执行超时");
                }

                @Override
                public void onError(AsyncEvent event) throws IOException {
                    println("执行错误");
                }

                @Override
                public void onStartAsync(AsyncEvent event) throws IOException {
                    println("开始执行");
                }
            });

          /*  ServletResponse servletResponse = asyncContext.getResponse();
            // 设置响应媒体类型
            servletResponse.setContentType("text/plain;charset=UTF-8");
            // 获取字符输出流
            PrintWriter writer = servletResponse.getWriter();
            writer.print("Hello Wolrd!");
            writer.flush();*/
        }
       // super.service(req, resp);
    }

    private static void println(Object o){
        String threadName = Thread.currentThread().getName();
        System.out.println("AsyncServlet[" + threadName + "]:" +o);
    }
}
