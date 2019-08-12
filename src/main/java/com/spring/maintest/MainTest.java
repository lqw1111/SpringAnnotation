package com.spring.maintest;

import com.spring.bean.Person;
import com.spring.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class MainTest {

    //配置文件的方式
//    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//        Person person = (Person) context.getBean("person");
//        System.out.println(person);
//    }

    //只使用注解的方式
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person person = applicationContext.getBean(Person.class);
        System.out.println(person);

        String[] names = applicationContext.getBeanNamesForType(Person.class);

        for (String name :
                names) {
            System.out.println(name);
        }

    }
}
