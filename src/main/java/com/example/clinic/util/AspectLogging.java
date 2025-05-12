package com.example.clinic.util;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
@Slf4j
public class AspectLogging {
    @Pointcut("execution(* com.example.clinic.service.*.*(..))")
    public void serviceMethods(){}

    @Pointcut("execution(* com.example..*(..))")
    public void allMethods() {}

    @Around("serviceMethods()")
    public void logService(ProceedingJoinPoint pjp) throws Throwable {
        log.info("Вызов {}", pjp.getSignature());
        Object res = pjp.proceed();
        log.info("Результат выполнения: {}", res);
    }

}
