package com.spring.config;

import com.spring.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

//使用propertysource读取外部配置文件中的值,加载完外部配置文件信息之后，再用${}来获取
@PropertySource(value = {"classpath:/person.properties"})
@Configuration
public class MainConfigOfPropertyValues {

    @Bean
    public Person person(){
        return new Person();
    }
}
