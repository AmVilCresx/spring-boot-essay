package com.imooc.diveinspringboot.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("Java7")
public class Java7CalculateService implements CalculateService{
    @Override
    public Integer sum(Integer... values) {
        System.out.println("--Java7CalculateService---");
        int sum = 0;
        for (int i=0; i<values.length; i++)
            sum += values[i];

        return sum;
    }

}
