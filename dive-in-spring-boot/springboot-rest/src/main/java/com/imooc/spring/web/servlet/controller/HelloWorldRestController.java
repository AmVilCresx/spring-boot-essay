package com.imooc.spring.web.servlet.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/** HelloWorld {@link RestController}
 *  @Author AmVilCresx
 *  @Date 2018/12/7 10:45
 *  @Description
 */
@RestController
public class HelloWorldRestController {

    @GetMapping(value = "/hello-world")
    public String helloWorld(@RequestParam(required = false) String message){
        return "hello World! " + message;
    }
}
