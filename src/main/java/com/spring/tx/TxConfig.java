package com.spring.tx;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;


/**
 * 声明式食物：
 *
 * 环境配置：
 *  1. 导入相关依赖
 *      数据源，数据库驱动，Springjdbc模块
 *
 *  2. 配置数据源，JdbcTemplate（spring提供的简化操作的数据）操作数据；
 *  3. 给方法上标注 @Transactional 标示是一个事务方法
 *  4. @EnableTransactionManagement 开启基于注解的事务管理功能
 *        @EnableXXX
 *  5. 配置事务管理器来管理事务
 *
 *
 *  原理：
 *      1）@EnableTransactionManagement
 *              利用 TransactionManagementConfigurationSelector 给容器中会导入组件
 *              导入两个组件
 *              AutoProxyRegistrar
 *              ProxyTransactionManagementConfiguration
 *      2) AutoProxyRegistrar implements ImportBeanDefinitionRegistrar
 *              给容器中注册一个InfrastructureAdvisorAutoProxyCreator组件
 *              InfrastructureAdvisorAutoProxyCreator 利用后置处理器机制在对象创建以后，包装对象成一个代理对象（增强器）
 *              代理对象执行方法利用拦截器链进行调用
 *
 *      3）ProxyTransactionManagementConfiguration 做了什么？
 *              1、给容器中注册事务增强器
 *                  1）事务增强器要用事务注解的信息，AnnotationTransactionAttributeSource 解析事务注解
 *                  2）事务拦截器：
 *                          TransactionInterceptor: 保存了事务属性信息，包括事务管理器
 *                          他是一个MethodInterceptor;
 *                          在目标方法执行的时候:
 *                                  执行拦截器链:
 *                                  事务拦截器:
 *                                      1) 先获取事务相关的属性
 *                                      2）再获取PlatformTransactionManager, 如果事先没有添加指定任何transactionManager
 *                                          最终会从容器中按照类型获取一个PlatformTransactionManager
 *                                      3）执行目标方法
 *                                          如果异常，获取到事务管理器，利用事务管理器回滚操作
 *                                          如果正常，利用事务管理器，提交事务
 *
 *
 */

@EnableTransactionManagement
@ComponentScan("com.spring.tx")
@Configuration
public class TxConfig {

    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("123456");
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        return dataSource;
    }

    //spring对Configuration类会特殊处理
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) throws PropertyVetoException {
        //spring对@Configuration类会特殊处理；给容器中加组件的方法，多次调用都只是从容器中找组件
        //比如这里的datasource()调用，不会再创建一个新的datasource
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
        return jdbcTemplate;
    }

    //注册事务管理器
    @Bean
    public PlatformTransactionManager transactionManager() throws PropertyVetoException {
        return new DataSourceTransactionManager(dataSource());
    }
}
