package com.imooc.diveinspringboot.repository;

import com.imooc.diveinspringboot.annotation.FirstLevelRepository;
import com.imooc.diveinspringboot.annotation.SecondLevelRepository;
import org.springframework.stereotype.Component;

@SecondLevelRepository(value = "myFirstLevelRepository") // Bean 的名称
//@Component(value = "myFirstLevelRepository")
public class MyFirstLevelRepository {
}
