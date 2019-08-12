package com.spring.config;

import com.spring.bean.Color;
import com.spring.bean.ColorFactory;
import com.spring.bean.Person;
import com.spring.bean.Red;
import com.spring.condition.MacOSCondition;
import com.spring.condition.MyImportBeanDefinationRegistrar;
import com.spring.condition.MyImportSelector;
import com.spring.condition.WindowsCondition;
import org.springframework.context.annotation.*;

//满足当前条件，这个类中的配置的所有bean才会生效
@Conditional({MacOSCondition.class})
@Configuration
//导入组件，id是默认的组件全类名
@Import({Color.class,Red.class, MyImportSelector.class, MyImportBeanDefinationRegistrar.class})
public class MyConfig2 {

    /**
     * prototype: 多实例的
     * singleton: 单实例的
     * request: 同一个请求创建一个实例
     * session: 同一个session创建一个实例
     *
     * 在使用prototype之后，在IOC容器启动的时候不会创建对象，而是在每次获取的时候，才会调用方法创建对象
     * 可以使用socpe调整范围
     *
     * 懒加载：
     *      单实例bean：默认在容器启动的时候创建对象
     *      懒加载：容器启动不创建对象，第一次使用的时候获得Bean对象创建，并初始化
     */
    @Lazy
    @Bean("person")
    public Person person(){
        System.out.println("添加person..");
        return new Person("张三","25");
    }

    /**
     * @Conditional({Conditional}): 按照一定的条件判断，满足条件就给容器中注册bean
     *
     * 如果系统的windows，就放bill，如果是linux，就放linus
     */
    @Bean
    @Conditional({WindowsCondition.class})
    public Person Bill(){
        return new Person("Bill", "22");
    }

    @Bean
    @Conditional({MacOSCondition.class})
    public Person jobs(){
        return new Person("jobs", "22");
    }

    /**
     * 给容器中注册逐渐
     * 1）包扫描+组件标注注解（@Controller,@Service ...)
     * 2）@bean 倒入第三方的包里面的组件
     * 3）@Import[快速的给容器中导入组件]
     *      Import
     *      ImportSelector: 批量导入全类名
     *      ImportBeanRegistrar:
     * 4）使用Spring提供的FactoryBean(工厂Bean)
     */
    @Bean
    public ColorFactory colorFactory(){
        return new ColorFactory();
    }
}
