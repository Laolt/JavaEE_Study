package org.example.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


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
//通知类型before、after、around（重点）、AfterReturning、AfterThrowing
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
    //无返回值示例（重点：需要依赖ProceedingJoinPoint对象才可以调用对应的函数）
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        //ProceedingJoinPoint对象中getSignature()方法获取一个含有此次方法执行的签名信息的类型
        Signature signature= pjp.getSignature();
        String className=signature.getDeclaringTypeName();//类型名
        String methodName=signature.getName();//方法名
        System.out.println("before");
        //表示对原始操作的调用
        Object re=pjp.proceed();//调用函数返回值为null
        System.out.println("after"+className+methodName);
        return re;
    }
    @Around("pointer1()")
    //有返回值示例
    public Object around1(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("before");
        //表示对原始操作的调用
        Object re= pjp.proceed();//调用函数，返回值为Object对应上述返回类型
        System.out.println("after");
        return re;
    }
    //@AfterReturning在函数成功执行之后
    //@AfterThrowing在函数发生异常之后
//    ------------------------------------------分割线-----------------------------------------
//    函数执行前/后(before/after/around)获取形参->JoinPoint.getArgs(),返回一个参数数组可以进行修改后再传回原函数执行JoinPoint.proceed(args[])‘
//    JoinPoint参数必须是通知形参的第一个参数
//    关于afterreturning获取返回值示例：
    //    @AfterReturning(value = pointerCutMethodName,returning = returnName)
    //    public void method(Object returnName){
    //        //returnName为执行后获取到的返回值
    //    }
//    @around获取异常可以通过传统的try语句捕捉异常
//    @AfterThrowing获取异常如下：
//    @AfterThrowing(value = pointerCutMethodName,throwing = throwable )
//    public void afterThrowing(Throwable throwable){
//        //throwable为异常后获取到的异常对象
//    }
}
