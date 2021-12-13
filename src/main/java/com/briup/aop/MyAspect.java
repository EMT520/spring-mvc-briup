package com.briup.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * AOP概念：
 * 将程序中重复的代码抽取出来，在程序执行的时候，利用动态代理技术，在不修改源码的基
 * 础上，把抽取出来的代码，在重新织入到原有的程序中，对现有的功能进行动态的增强。
 * 关键名称：
 * 1.切面类（Aspect）：
 * 将来要被织入到方法执行 前/后/异常 的时候去执行的代码片段
 * 2.连接点（joinpoint）：
 * Spring中的连接点是目标对象里面需要被代理的方法，默认情况下是目标对象中所有非final修饰的
 * 方法
 * 3.切入点（pointCut）
 * 一组连接点的集合，就是一个切入点。因为连接点就是方法(spring中是这样)，所有一个切入点也是
 * 一组方法的集合
 * 4.通知/拦截器（advice）
 * 控制 切面/切面类 将来要在目标对象中方法的什么位置执行，例如方法的前面或者后面或者抛异常
 * 的时候
 * 5.织入（wave）
 * 将切面类织入到指定方法中去执行的动作
 * 6.目标对象（target）
 * 需要被代理的对象，一般是代理目标对象的一个或多个指定的方法
 * 7.代理对象（proxy）
 * 代理目标对象，在完成核心功能的前提下，添加额外的代码去执行
 *
 */
@Aspect //该注解声明该类是一个切面类
@Component// <bean> @Controller @Service
public class MyAspect {
    public MyAspect() {
        System.out.println("创建切面类对象，实现aop功能");
    }

    /**
     * 定义切入点的规则（一组方法的集合）
     * 任意在service包的方法都是切入点，
     */
    @Pointcut("execution(* com.briup.service..*.*(..))")
    public void pointCut(){
        //切入点就是方法名
    }

    /**
     * 声明方法为前置通知，value属性，用来指定引用的切入点是谁
     */
    @Before("pointCut()")
    public void before(){
        System.out.println("前置通知");
    }

    /**
     * 声明方法为后置通知，value属性，用来指定引用的切入点是谁
     * 被代理的方法必须正常返回，抛出异常不织入
     */
    @AfterReturning("pointCut()")
    public void afterReturn(){
        System.out.println("后置通知");
    }

    /**
     * 被代理的方法正常返回或者抛出异常都会织入该代码片段
     */
    @After("pointCut()")
    public void after(){
        System.out.println("最终通知");
    }

    /**
     * 声明方法为环绕通知，value属性，用来指定引用的切入点是谁
     * 将该代码片段织入到目标对象中方法的执行之前和和之后
     * @param pjp 切入点
     * @throws Throwable
     */
    @Around("pointCut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("开始环绕通知");
        Object obj = pjp.proceed();//调用目标对象中切入点方法
        System.out.println("结束环绕通知");
        return obj;
    }
    @AfterThrowing(value = "pointCut()",throwing = "ex")
    public void throwable(Exception ex){
        System.out.println("异常通知："+ex.getMessage());
    }
}
