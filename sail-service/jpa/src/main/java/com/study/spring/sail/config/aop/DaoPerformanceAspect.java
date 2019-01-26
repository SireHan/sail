package com.study.spring.sail.config.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * pepository 执行时间 aop
 *
 * @author 韩炜
 * @date 2019-01-15 11:00
 */
@Aspect
@Component
public class DaoPerformanceAspect {

    @Pointcut("execution(* com.study.spring.sail.modules.*.jpaImpl.dao.*Repository.*(..))")
    public void repositoryClassMethods() {
    }

    @Around("repositoryClassMethods()")
    public Object measureMehtodExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.nanoTime();
        Object returnValue = joinPoint.proceed();
        long end = System.nanoTime();
        String methodName = joinPoint.getSignature().getName();
        String classType = joinPoint.getTarget().getClass().getName();
        Class<?> clazz = Class.forName(classType);
        String clazzName = clazz.getName();
        System.out.println("Execution of " + clazzName + ":" + methodName + " took " + TimeUnit.NANOSECONDS.toMillis(end - start) + " ms");
        return returnValue;
    }
}
