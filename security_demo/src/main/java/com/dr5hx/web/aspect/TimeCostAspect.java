package com.dr5hx.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Component
@Aspect
public class TimeCostAspect {
    Logger log = LoggerFactory.getLogger(getClass());

    @Around(value = ("execution(* com.dr5hx.web.controller.HelloController.*(..) )"))
    public void timeCost(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("aop作用开始");
        long startTime = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        proceedingJoinPoint.proceed();
        log.info("aop所耗时为：" + (new Date().getTime() - startTime));
    }
}
