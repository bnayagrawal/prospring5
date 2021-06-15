package dev.bnayagrawal.prospring5.chapter5.pointcuts;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class NoOpBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        // no-op
    }
}
