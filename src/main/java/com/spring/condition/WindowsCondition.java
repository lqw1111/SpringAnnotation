package com.spring.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class WindowsCondition implements Condition {

    /**
     *
     * @param conditionContext: 判断条件能使用的上下文环境
     * @param annotatedTypeMetadata：注释信息
     * @return
     */
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //判断是不是window

        //拿到bean工厂
        ConfigurableListableBeanFactory beanFactory = conditionContext.getBeanFactory();
        //拿到类加载器
        ClassLoader classLoader = conditionContext.getClassLoader();

        //获得当前环境信息
        Environment environment = conditionContext.getEnvironment();

        //获得bean定义的注册类
        BeanDefinitionRegistry registry = conditionContext.getRegistry();

        String property = environment.getProperty("os.name");

        if (property.contains("Windows"))
            return true;

        return false;
    }
}
