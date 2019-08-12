package com.spring.ext;

import com.spring.bean.Blue;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.*;
import org.springframework.stereotype.Component;

@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    //bean定义信息的保存中心。以后beanDefinitionRegistry里面保存的每一个bean定义信息创建bean的实例
   public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
       System.out.println("postProcessBeanDefinitionRegistry...bean的数量： " + registry.getBeanDefinitionCount());

       AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.rootBeanDefinition(Blue.class).getBeanDefinition();
       registry.registerBeanDefinition("hello",beanDefinition );
   }

    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("MyBeanDefinitionRegistryPostProcessor...bean的数量 " + beanFactory.getBeanDefinitionCount());
    }
}
