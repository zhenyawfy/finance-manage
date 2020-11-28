package com.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
    @Pointcut("execution(* com.demo.service.*.*(..))")
    public void pc() {

    }
    @Before(value = "pc()")
    public void before(JoinPoint jp) {
        String name = jp.getSignature().getName();
        long threadId = Thread.currentThread().getId();
        System.out.println(threadId + "》》》》》》》" + name + "方法于" + System.currentTimeMillis() + "开始执行。。。");
    }

    @After(value = "pc()")
    public void after(JoinPoint jp) {
        String name = jp.getSignature().getName();
        long threadId = Thread.currentThread().getId();
        System.out.println(threadId + "》》》》》》》" + name + "方法于" + System.currentTimeMillis() + "开始结束。");
    }

//    @AfterReturning()
}