package com.dr5hx.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Component
@Aspect
public class TimeCostAspect {
    @Around(value = ("execution(* com.dr5hx.controller.HelloController.*(..) )"))
    public void timeCost(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("aop作用开始");
        long startTime = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        proceedingJoinPoint.proceed();
        System.out.println("aop所耗时为：" + (new Date().getTime() - startTime));
    }
}
