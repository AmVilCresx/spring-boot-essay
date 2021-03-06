package com.imooc.diveinspringboot.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
@Profile("Java8")
public class Java8CalculateService implements CalculateService{
    @Override
    public Integer sum(Integer... values) {
        System.out.println("--Java8CalculateService---");
        int sum = Stream.of(values).reduce(0,Integer::sum);
        return sum;
    }

    public static void main(String[] args) {
        CalculateService calculateService = new Java8CalculateService();
        int sum = calculateService.sum(1,2,3,4,5,6,7,8,9,10);
        System.out.println(sum);
    }

}
