package com.spring.bean;

import org.springframework.beans.factory.annotation.Value;

public class Person {

    //使用@Value赋值
    //1. 基本数值
    //2. 可以写spEL； #{}
    //3. 可以写${}: 取出配置文件的值

    @Value("张三")
    private String name;

    @Value("${person.age}")
    private String age;

    public Person() {
    }

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
