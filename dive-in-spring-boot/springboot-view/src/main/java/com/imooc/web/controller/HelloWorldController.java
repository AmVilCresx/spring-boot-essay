package com.imooc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  @Author AmVilCresx
 *  @Date 2018/12/6 14:22
 *  @Description
 */

@Controller
public class HelloWorldController {

    @RequestMapping("")
    public String index(){
        return "index";
    }

    @GetMapping("/hello-world")
    public String helloWorld(){

        return "hello-world"; // View逻辑名称
    }

    @ModelAttribute("message")
    public String message(){
        return "Hello World!";
    }
}
