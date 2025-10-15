package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect      // 声明切面
@Component   // 注册为Spring Bean
public class LogAspect {

    // 切入点：匹配 service 包下所有方法
    @Pointcut("execution(* com.example.service.*.*(..))")
    public void serviceMethods() {}

    // 后置通知：方法执行完后记录日志
    @AfterReturning("serviceMethods()")
    public void logAfter(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("[AOP日志] 用户执行了：" + methodName + " 操作");
    }
}
