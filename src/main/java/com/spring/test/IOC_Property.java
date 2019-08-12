package com.spring.test;

import com.spring.bean.Person;
import com.spring.bean.Yello;
import com.spring.config.MainConfigOfProfile;
import com.spring.config.MainConfigOfPropertyValues;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

public class IOC_Property {

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);

    @Test
    public void test01(){
        this.applicationContext.getBeanDefinitionNames();
        printBeans(this.applicationContext);
        Person person = this.applicationContext.getBean(Person.class);
        System.out.println(person);

        applicationContext.close();
    }

    private void printBeans(AnnotationConfigApplicationContext applicationContext){
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name :
                names) {
            System.out.println(name);
        }
    }

    //1. 使用命令行动态参数的方式: 在虚拟机参数位置加载 -Dspring.profiles.active=test
    @Test
    public void test02(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfProfile.class);
        String[] names = applicationContext.getBeanNamesForType(DataSource.class);

        for (String name : names){
            System.out.println(name);
        }

        applicationContext.close();
    }

    //2. 使用代码的方式激活
    @Test
    public void test03(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        //1. 创建一个applicationContext
        //2. 设置需要激活的环境
        applicationContext.getEnvironment().setActiveProfiles("dev");

        //3. 注册主配置类
        applicationContext.register(MainConfigOfProfile.class);

        //4. 启动刷新容器
        applicationContext.refresh();

        System.out.println(applicationContext.getBean(Yello.class));

        String[] names = applicationContext.getBeanNamesForType(DataSource.class);
        for (String name : names){
            System.out.println(name);
        }
        applicationContext.close();
    }
}
