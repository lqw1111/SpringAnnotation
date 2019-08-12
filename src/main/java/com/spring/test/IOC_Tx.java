package com.spring.test;

import com.spring.tx.TxConfig;
import com.spring.tx.UserDao;
import com.spring.tx.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOC_Tx {

    public void test1(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TxConfig.class);

        UserService userService = applicationContext.getBean(UserService.class);
        userService.insertUser();

        applicationContext.close();
    }
}
