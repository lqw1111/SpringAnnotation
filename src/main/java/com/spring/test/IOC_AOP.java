package com.spring.test;

import com.spring.aop.MathCalculator;
import com.spring.config.MainConfigOfAOP;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOC_AOP {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);

        //1. 使用spring容器中的bean，而不是自己创建
        MathCalculator mathCalculator = applicationContext.getBean(MathCalculator.class);

        mathCalculator.div(1,1);
    }
}
