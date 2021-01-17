package com.liuwq.demo.aop;

import com.liuwq.demo.annotation.MyAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
@Slf4j
public class MyAop {
    /**
     * 切入点
     * 匹配com.liuwq.demo.controller包及其子包下的所有类的所有方法
     */
    @Pointcut("@annotation(com.liuwq.demo.annotation.MyAnnotation)")
    public void aa(){
    }

    @Before("aa()")
    public void ss(JoinPoint joinPoint){
        System.out.println("----------- 2.前置通知 -----------");

        String className = joinPoint.getTarget().getClass().getName();

        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();

        MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);

        if (myAnnotation !=null){

            System.out.println("MyAnnotation----------------------" + myAnnotation.name());
        }
    }

}
