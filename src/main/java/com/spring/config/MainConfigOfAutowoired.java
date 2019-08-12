package com.spring.config;

import com.spring.bean.Car;
import com.spring.bean.Color;
import com.spring.dao.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * 自动装配：
 *      Spring利用依赖注入(DI),完成对IOC容器中各个组件的依赖关系的赋值
 *
 *
 * 1) @Autowired: 自动注入
 *      1）默认优先按照类型去容器中找到组件
 *      2) 如果找到多个相同类型的组件，再将属性的名称作为组件的id去容器中查找
 *      3）@Qualifier("bookDao"): 使用该注解可以指定需要装备的组件的id，而不是使用属性名
 *      4）自动装配默认一定要将属性赋值好，没有就会报错
 *      5) @Primary: 让spring自动装配的时候，默认使用首选的bean，也可以继续使用@Qualifier指定需要装配的bean的名字
 *
 * 2）Spring还支持使用@Resource(JSR250)和@Inject(JSR330)  java规范的注解
 * @Resource: 可以和Autowired一样实现自动装配功能，默认是按照组件名称进行的
 *            没有支持@Primary功能，也没有required的功能
 *
 * @Inject： 需要导入javax.inject的包，和Autowired的功能一样，没有required = false的功能
 *
 * @Autowird： 是spring定义
 * 另外两个是java规范
 *
 * AutowiredAnnotationBeanPostProcessor: 解析完成自动装配功能
 *
 * 3）@Autowired: 构造器，参数，方法，属性
 *      1) 标注在方法上：@Bean+方法参数，参数从容器中获取，默认不写autowired，效果是一样的都可以自动装配
 *      2）放在构造器上：如果组件只有一个有参数构造器，这个有参构造器的@Autowired可以省略，参数位置的组件还是可以自动从容器中获取
 *      3）放在参数位置上
 *
 * 4）自定义组件想要使用Spring容器底层的一些组件（ApplicationContext，BeanFactory，xxx）
 *      自定义组件实现xxxAware: 在创建对象的时候，会调用接口规定的方法注入相关的组件: Aware
 *      吧spring底层一些嘴贱注入到自定义的bean中
 *      xxxAware：功能使用xxxProcessor
 *          ApplicationContextAware ==> ApplicationContextAwareProcessor;
 */

@ComponentScan({"com.spring.service","com.spring.controller","com.spring.dao","com.spring.bean"})
public class MainConfigOfAutowoired {

    @Bean("bookDao2")
    public BookRepository bookRepository(){
        BookRepository bookRepository = new BookRepository();
        bookRepository.setLabel("2");
        return bookRepository;
    }

    /**
     * @Bean 标注的方法创建对象的时候，方法参数的值从容器中来
     * @param car
     * @return
     */
    @Bean
    public Color color(Car car){
        return new Color();
    }


}
