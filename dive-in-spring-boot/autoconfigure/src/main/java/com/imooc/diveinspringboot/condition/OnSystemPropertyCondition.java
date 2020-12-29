package com.imooc.diveinspringboot.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

/*
 * 系统属性条件判断
 * */
public class OnSystemPropertyCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //Map<String,Object> attributes = metadata.getAnnotationAttributes(ConditionalOnSystemProperty.class.getName());
        AnnotationAttributes attributes = AnnotationAttributes
                .fromMap(metadata.getAnnotationAttributes(ConditionalOnSystemProperty.class.getName(), true));
        String propertyName = String.valueOf(attributes.get("name"));
        String propertyValue = String.valueOf(attributes.get("value"));

        System.out.println("propertyName = "+propertyName+", propertyValue = "+propertyValue);

        String javaPropertyValue = System.getProperty(propertyName);

        System.out.println("javaPropertyValue = "+javaPropertyValue);

        return javaPropertyValue.equals(propertyValue);
    }
}
