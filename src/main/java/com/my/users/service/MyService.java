package com.my.users.service;

import org.springframework.stereotype.Service;

@Service
public class MyService {

    @Annotation1
    public void method1() {
        System.out.println("method1");
        method2();
    }

    @Annotation1
    public void method2() {
        System.out.println("method2");
    }
}
