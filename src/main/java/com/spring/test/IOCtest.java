package com.spring.test;

import com.spring.bean.Blue;
import com.spring.bean.Person;
import com.spring.config.MainConfig;
import com.spring.config.MyConfig2;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

public class IOCtest {
    AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MyConfig2.class);

    @Test
    public void test01(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] names = annotationConfigApplicationContext.getBeanDefinitionNames();

        for (String name:
             names) {
            System.out.println(name);
        }
    }

    @Test
    public void test02(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MyConfig2.class);
//        String[] names = annotationConfigApplicationContext.getBeanDefinitionNames();
//        for (String name:
//                names) {
//            System.out.println(name);
//        }

        System.out.println("容器创建完成...");

        Object bean = annotationConfigApplicationContext.getBean("person");
//        Object bean2 = annotationConfigApplicationContext.getBean("person");
//        System.out.println(bean == bean2);
    }

    @Test
    public void test03(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MyConfig2.class);
        String[] names = annotationConfigApplicationContext.getBeanNamesForType(Person.class);
        for(String name : names){
            System.out.println(name);
        }

        Map<String, Person> map = annotationConfigApplicationContext.getBeansOfType(Person.class);
        System.out.println(map);

        ConfigurableEnvironment environment = annotationConfigApplicationContext.getEnvironment();
        String property = environment.getProperty("os.name");
        System.out.println(property);
    }

    @Test
    public void testImport(){
        printBeans(this.annotationConfigApplicationContext);
        Blue blue = this.annotationConfigApplicationContext.getBean(Blue.class);
        System.out.println(blue);
        Object bean2 = this.annotationConfigApplicationContext.getBean("colorFactory");
        System.out.println("bean类型：" + bean2.getClass());
    }

    private void printBeans(AnnotationConfigApplicationContext applicationContext){
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name :
                names) {
            System.out.println(name);
        }
    }


}
