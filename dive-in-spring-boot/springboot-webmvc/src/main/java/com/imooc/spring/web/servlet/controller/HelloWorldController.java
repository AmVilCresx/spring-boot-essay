package com.imooc.spring.web.servlet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  @Author AmVilCresx
 *  @Date 2018/12/3 21:17
 *  @Description
 */

@Controller
public class HelloWorldController {

    @RequestMapping("")
    public String index(){
        //model.addAttribute("AcceptLanguage",AcceptLanguage);
        //model.addAttribute("jsessionId",jsessionId);
        return "index";
    }
}
