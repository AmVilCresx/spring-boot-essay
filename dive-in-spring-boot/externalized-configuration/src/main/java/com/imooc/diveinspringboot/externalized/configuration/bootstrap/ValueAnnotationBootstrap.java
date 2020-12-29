package com.imooc.diveinspringboot.externalized.configuration.bootstrap;

import com.imooc.diveinspringboot.externalized.configuration.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import static org.springframework.context.ConfigurableApplicationContext.ENVIRONMENT_BEAN_NAME;

/**
 *  @Author AmVilCresx
 *  @Date 2019/1/14 14:48
 *  @Description
 *  执行顺序： 1.@Autowired  2.BeanFactoryAware  3.EnvironmentAware
 *            有且只有一个 Environment 对象
 */

@EnableAutoConfiguration
public class ValueAnnotationBootstrap implements BeanFactoryAware
       , EnvironmentAware
{ // @Configuration Class

    @Autowired
    @Qualifier(ENVIRONMENT_BEAN_NAME)
    private Environment environment;


    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        if(this.environment != beanFactory.getBean(ENVIRONMENT_BEAN_NAME, Environment.class)){
            System.out.println("BeanFactory不相等");
        }
    }

    @Override
    public void setEnvironment(Environment environment) {
        if(this.environment != environment){
            System.out.println("EnvironmentAware不相等");
        }
        this.environment = environment;
    }

   /* @Autowired
    public ValueAnnotationBootstrap(Environment environment) {
        this.environment = environment;
    }*/

/*private final Long id;

    private final String name;

    private final Integer age;

    public ValueAnnotationBootstrap(@Value("${user.id}")Long id, @Value("${user.name}")String name, @Value("${user.age}")Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }*/

    @Bean
    public User user2(
    //        Environment environment
    ){
        User u = new User();
        Long id = environment.getRequiredProperty("user.id",Long.class);
        String name = environment.getRequiredProperty("user.name",String.class);
        Integer age = environment.getProperty("user.age",Integer.class,
                environment.getProperty("my.user.age",Integer.class,9));

        u.setId(id);
        u.setName(name);
        u.setAge(age);
        return u;
    }


    @Bean
    public User user(@Value("${user.id}")Long id, @Value("${user.name}")String name,
                     @Value("${user.age:${my.user.age:14}}")Integer age){
        User u = new User();
        u.setId(id);
        u.setName(name);
        u.setAge(age);
        return u;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                new SpringApplicationBuilder(ValueAnnotationBootstrap.class)
                        .web(WebApplicationType.NONE) // 非 Web 应用
                        .run(args);

        User user = context.getBean("user", User.class);
        User user2 = context.getBean("user2", User.class);

        System.err.println("用户对象 : " + user);
        System.err.println("用户对象2 : " + user2);
        // 关闭上下文
        context.close();
    }


}

