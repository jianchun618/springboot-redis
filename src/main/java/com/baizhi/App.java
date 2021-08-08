package com.baizhi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.baizhi.dao")
/*
* 组合注解：一个注解包含多个注解的功能
* @SpringBootApplication=@Configuration+@ComponentScan+@EnableAutoConfiguration
* @Configuration：加在类上声明当前类 为配置类
* @ComponentScan：组件扫描,将扫描到的类交由工厂管理
    * @Repository
      @Component
      @Service
      @Controller
  @EnableAutoConfiguration：开启自动配置，一旦引入第三方的jar，springboot就可以帮你配制相关组件
* */
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
}
