package com.baizhi.cache;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

//当前类也需要，交给工厂管理，使用该注解
@Component
public class ApplicationContextUtil implements ApplicationContextAware {

    //静态，便于在方法中使用
    private  static ApplicationContext applicationContext;

    //工厂对象，通过方法，传递过来
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }

    // 工厂里拿对象，通过对象的名获取
    public static Object getBeanByName(String name){
        Object bean = applicationContext.getBean(name);
        return bean;
    }

    //根据类型拿对象
    public static Object getBeanByClass(Class clazz){
        Object bean = applicationContext.getBean(clazz);
        return bean;
    }

    // 根据类型 和名字拿
    public static Object getBeanByClassAndName(String name,Class clazz){
        Object bean = applicationContext.getBean(name,clazz);
        return bean;
    }
}
