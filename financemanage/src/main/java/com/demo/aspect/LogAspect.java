package com.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
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

    @AfterReturning(value = "pc()", returning = "result")
    public void afterReturning(JoinPoint jp, Object result) {
        String name = jp.getSignature().getName();
        long threadId = Thread.currentThread().getId();
        System.out.println(threadId + "》》》》》》》" + name + "方法返回值：" + result);
    }

    @AfterThrowing(value = "pc()", throwing = "e")
    public void afterThrowing(JoinPoint jp, Exception e) {
        String name = jp.getSignature().getName();
        long threadId = Thread.currentThread().getId();
        System.out.println(threadId + "》》》》》》》" + name + "方法抛异常了，异常是：" + e.getMessage());
    }

    @Around(value = "pc()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        String name = pjp.getSignature().getName();
        long threadId = Thread.currentThread().getId();
        System.out.println(threadId + "》》》》》》》" + name + "方法around....");
        return pjp.proceed();
    }
}
