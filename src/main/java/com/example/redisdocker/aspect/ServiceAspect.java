package com.example.redisdocker.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class ServiceAspect {

    @Before("execution(* com.example.redisdocker.service.ProductService.*(..))")
    public void beforeMethods(JoinPoint joinPoint) {

        log.info(joinPoint.getSignature().getName() + " Before method " + Arrays.toString(joinPoint.getArgs()));

    }

    @After("execution(* com.example.redisdocker.service.ProductService.*(..))")
    public void afterMethods(JoinPoint joinPoint) {

        log.info(joinPoint.getSignature().getName() + " After method " + Arrays.toString(joinPoint.getArgs()));

    }

    @AfterReturning("execution(* com.example.redisdocker.service.ProductService.*(..))")
    public void afterReturnOfMethod(JoinPoint joinPoint) {

        log.info(joinPoint.getSignature().getName() + " After the method returns a value " + Arrays.toString(joinPoint.getArgs()));

    }

    @Pointcut("execution(* com.example.redisdocker.service.ProductService.*(..))")
    public void pointCutForAfterReturning() {
    }


    @AfterThrowing(
            pointcut = "pointCutForAfterReturning()", throwing = "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {

        log.info("LogAfterThrowing is runnning");
        log.info("MethodName: " + joinPoint.getSignature().getName());
        log.info("Exception: " + error);

    }

}
