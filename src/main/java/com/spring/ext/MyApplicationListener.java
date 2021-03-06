package com.spring.ext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationListener implements ApplicationListener<ApplicationEvent> {

    //当容器中发布此事件以后，方法会得到触发
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("收到事件：" + event);
    }
}
