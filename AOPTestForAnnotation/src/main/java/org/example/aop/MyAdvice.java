package org.example.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component//将该类作为一个bean交给spring处理
@Aspect//将该类里面的方法识别为AOP的通知
public class MyAdvice {
    //配置切入点
    //一个私有的无返回值无参数无内容的方法
    @Pointcut("execution(void org.example.dao.testDaoOfAOPFA.update())")//交代切入点的位置
    //切入点表达式语句:动作关键字(访问修饰符 返回值 包名.类/接口名.方法(参数)异常名)
    //可以加通配符(见笔记)
    private void pointer(){}
    @Pointcut("execution(int org.example.dao.testDaoOfAOPFA.save())")//交代切入点的位置
    private void pointer1(){}

    @Before("pointer()")//绑定切入点与通知
    //配置通知
    public void before(){
        System.out.println(System.currentTimeMillis());
    }
    @After("pointer()")
    public void after(){
        System.out.println("After");
    }
    @Around("pointer()")
    //无返回值示例
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("before");
        //表示对原始操作的调用
        pjp.proceed();
        System.out.println("after");
    }
    @Around("pointer1()")
    //有返回值示例
    public Object around1(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("before");
        //表示对原始操作的调用
        Object re= pjp.proceed();
        System.out.println("after");
        return re;
    }
}
