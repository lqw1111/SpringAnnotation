package com.spring.config;

import com.spring.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import sun.tools.serialver.SerialVer;

//配置类 就是 配置文件
@Configuration //告诉spring，这是一个配置类
@ComponentScan(value = "com.spring", includeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class, Service.class}),
        @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})
})
//@ComponentScan指定要扫描的规则
//excludeFileters = [], 按照规则排除一些组件
//includeFilters = [], 按照规则只需要包含哪些组件
//CUSTOM 自己指定规则
public class MainConfig {

    //给容器注册一个bean；类型为返回值的类型，id默认是使用方法名作为id
    @Bean(value = "person1")
    public Person person() {
        return new Person("lisi", "20");
    }
}
