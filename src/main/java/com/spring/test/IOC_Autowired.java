package com.spring.test;

import com.spring.bean.Boss;
import com.spring.config.MainConfigOfAutowoired;
import com.spring.service.BookSerive;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOC_Autowired {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAutowoired.class);

//        BookSerive bookSerive = applicationContext.getBean(BookSerive.class);
//        System.out.println(bookSerive);

        Boss boss = applicationContext.getBean(Boss.class);
        System.out.println(boss);

        applicationContext.close();
    }
}
