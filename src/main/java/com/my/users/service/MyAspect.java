package com.my.users.service;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    @Pointcut("@annotation(com.my.users.service.Annotation1)")
    public void annotated() {}

    @Before("annotated()")
    public void printABit() {
        System.out.println("Aspect1");
    }
}