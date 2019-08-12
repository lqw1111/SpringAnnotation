package com.spring.condition;

import com.spring.bean.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinationRegistrar implements ImportBeanDefinitionRegistrar {

    //annotationMetadata
    //beanDefinitionRegistry注册类：调用beanDefinitionRegistry.registerBeanDefinition()手动注册
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        if (beanDefinitionRegistry.containsBeanDefinition("com.spring.bean.Blue")){
            //指定bean的定义信息
            RootBeanDefinition definition = new RootBeanDefinition(RainBow.class);

            //注册一个bean，指定 bean的名字
            beanDefinitionRegistry.registerBeanDefinition("rainbow", definition);
        }
    }
}
