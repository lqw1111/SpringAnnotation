package com.spring.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.spring.bean.Yello;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Profile：
 *      Spring为我们提供的可以根据当前环境，动态的激活和切换一系列组件的功能
 *
 * 开发环境，测试环境，生产环境
 * 数据源：(A)(B)(C)
 *
 * @Profile: 指定组件在哪个环境下才会被加载到容器中
 *
 * 不指定的时候所有的都加载
 *
 * 1) 加了环境标示的bean，只有环境被激活才会加入,默认你是default环境
 * 2）写在配置类上，只有是指定环境的时候，整个配置类里面的所有配置才能开始生效
 * 3) 没有标注环境标示的bean，在任何环境下，都是加载的
 */

//@Profile("dev")
@PropertySource("classpath:/dbconfig.properties")
@Configuration
public class MainConfigOfProfile implements EmbeddedValueResolverAware {

    @Value("${db.user}")
    private String user;

    private StringValueResolver valueResolver;

    private String driverClass;

//    @Profile("test")
    @Bean
    public Yello yello(){
        return new Yello();
    }

    @Profile("dev")
    @Bean("devDataSource")
    public DataSource dataSourceDev(@Value("${db.password}") String pwd) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        dataSource.setJdbcUrl("");
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }

    @Profile("test")
    @Bean("testDataSource")
    public DataSource dataSourceTest(@Value("${db.password}") String pwd) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        dataSource.setJdbcUrl("");
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }

    @Profile("pro")
    @Bean("proDataSource")
    public DataSource dataSourcePro(@Value("${db.password}") String pwd) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        dataSource.setJdbcUrl("");
        dataSource.setDriverClass(driverClass);

        return dataSource;
    }

    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
        this.valueResolver = stringValueResolver;
        this.driverClass = valueResolver.resolveStringValue("${db.driverClass}");
    }
}
