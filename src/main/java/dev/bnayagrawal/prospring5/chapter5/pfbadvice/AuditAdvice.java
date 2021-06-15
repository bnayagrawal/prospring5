package dev.bnayagrawal.prospring5.chapter5.pfbadvice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class AuditAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("Executing: " + method.getName());
    }
}
