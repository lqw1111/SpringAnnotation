package com.spring.bean;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

//默认加载ioc容器中的组件，容器启动会调用无参数构造器创建对象，在进行初始化赋值等操作
@Component
public class Boss {

    private Car car;

    //Autowired标在构造器上

    public Car getCar() {
        return car;
    }


    //标注的方法上，spring容器创建当前对象，就会调用方法，完成赋值
    //方法使用的参数，自定义类型的值从ioc容器中进行获取
    @Autowired
    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "car=" + car +
                '}';
    }
}
