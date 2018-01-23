package com.elink.manage;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectClass {
	 /**
     * 定义前置通知
     * execution(* biz.UserBiz.*(..)) 表示  所有修饰符的所有返回值类型  biz.UserBiz 包下的所有方法
     * 在方法执行之前执行
     * */
    @Before("execution(* cn.no7player.controller.*.*(..))")
    public void before(JoinPoint join){
        //获取方法名
        String mathName=join.getSignature().getName();
        //获取参数列表
        List<Object> args = Arrays.asList(join.getArgs());
        System.out.println("前置通知---->before   方法名是:"+mathName+"\t参数列表是:"+args);
    }
    
    /**
     * 后置通知
     * 在方法返回后执行，无论是否发生异常
     * 不能访问到返回值
     * 
     * */
    @After("execution(* cn.no7player.controller.*.*(..))")
    public void after(){
        System.out.println("后置通知---->after....");
    }
    
    
    @Pointcut("execution(* cn.no7player.controller.*.*(..))")
    private void anyMethod(){}

    @Before("anyMethod()")
    public void doAccessCheck() {
        System.out.println("前置通知");
    }
    
    @After("anyMethod()")
    public void afters() {
        System.out.println("最终结果");
    }
    @AfterReturning("anyMethod()")
    public void doAfter() {
        System.out.println("后置通知");
    }
    @AfterThrowing("anyMethod()")
    public void doAfterThrow() {
        System.out.println("例外通知");
    }
    @Around("anyMethod()")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("进入环绕通知");
        Object object = pjp.proceed();
        System.out.println("退出方法");
        return object;
    }
    
}
