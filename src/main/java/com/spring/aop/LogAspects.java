package com.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

//告诉spring当前类是一个切面类
@Aspect
public class LogAspects {

    //抽取公共的切入点表达式
    //1、本类引用
    //2、其他的切面引用
    @Pointcut("execution(public int com.spring.aop.MathCalculator.*(..))")
    public void pointCut(){};

    //@Before 目标方法之前切入：切入点表达式（指定在哪个方法切入）
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint){

        System.out.println(" " + joinPoint.getSignature().getName() + "除法运行。。参数列表是：{" + Arrays.asList(joinPoint.getArgs()) +"}");
    }

    @After("com.spring.aop.LogAspects.pointCut()")
    public void logEnd(JoinPoint joinPoint){
        System.out.println(" " + joinPoint.getSignature().getName() +" 除法结束。。。");
    }

    //JoinPoint一定要出现在参数表的第一位
    @AfterReturning(value = "pointCut()",returning = "result")
    public void logReturn(JoinPoint joinPoint, Object result){
        System.out.println(joinPoint.getSignature().getName()+" 除法正常返回。。。运行结果:{ "+ result +"}");
    }

    @AfterThrowing(value = "pointCut()",throwing = "exception")
    public void logException(Exception exception){
        System.out.println("除法异常。。" + exception.getMessage());
    }
}
