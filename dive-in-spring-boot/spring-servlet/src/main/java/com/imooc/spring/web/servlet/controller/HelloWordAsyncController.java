package com.imooc.spring.web.servlet.controller;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Random;
import java.util.concurrent.*;

/**
 *  @Author AmVilCresx
 *  @Date 2018/12/10 19:36
 *  @Description
 */
@RestController
@EnableScheduling
public class HelloWordAsyncController {

    private final BlockingQueue<DeferredResult<String>> queue = new ArrayBlockingQueue<>(5);

    // 超时随机数
    private final Random random = new Random();

    @Scheduled(fixedRate = 5000)
    public void process() throws InterruptedException {
        DeferredResult<String> result = null;
        do{
            result = queue.take();
            // 随机超时时间
            long timeout = random.nextInt(100);
            // 模拟等待时间，RPC 或者 DB查寻
            Thread.sleep(timeout);
            // 计算结果
            result.setResult("Hello World!");
            println("执行计算结果，消耗："+timeout+" ms.");
        }while(result != null);
    }

    @GetMapping("/completionStage")
    public CompletionStage<String> completionStage(){
        final long startTime = System.currentTimeMillis();
        println("Hello World!");

        return CompletableFuture.supplyAsync(() ->{
            long costTime = System.currentTimeMillis() - startTime;
            println("执行计算结果，消耗："+costTime+" ms.");
            return "Hello World!";
        });
    }

    @GetMapping("/callable-hello-world")
    public Callable<String> callableHelloWorld(){
        final long startTime = System.currentTimeMillis();
        println("Hello World!");

        return () ->{
            long costTime = System.currentTimeMillis() - startTime;
            println("执行计算结果，消耗："+costTime+" ms.");
          return "Hello World!";
        };

    }

    @GetMapping("/hello-world")
    public DeferredResult<String> helloWorld(){
        DeferredResult<String> result = new DeferredResult<>(50L);
        // result.setResult("Hello World!");
        // 入队列
        queue.offer(result);
        println("Hello World!");
        result.onCompletion(() -> {
            println("执行结束!");
        });

        result.onTimeout(() ->{
            println("执行超时！");
        });
        return result;
    }

    private static void println(Object o){
        String threadName = Thread.currentThread().getName();
        System.out.println("HelloWordAsyncController[" + threadName + "]:" +o);
    }
}
