package com.spring.bean;

import org.springframework.beans.factory.FactoryBean;


//创建一个Spring定义的FactoryBean
public class ColorFactory implements FactoryBean<Color> {

    //返回一个Color对象，这个对象会添加到容器中
    public Color getObject() throws Exception {
        System.out.println("return object..");
        return new Color();
    }

    public Class<?> getObjectType() {
        return Color.class;
    }

    //控制是不是单例
    //如果是true就是单例
    //false就不是
    public boolean isSingleton() {
        return false;
    }
}
