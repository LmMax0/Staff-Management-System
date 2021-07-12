package com.lmdd.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
//是springboot程序开始的入口
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
//        String[] beanDefinitionNames = run.getBeanDefinitionNames();
//        for (String definitionName : beanDefinitionNames) {
//            System.out.println(definitionName);
//        }

    }

}
