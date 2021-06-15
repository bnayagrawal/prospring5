package dev.bnayagrawal.prospring5.chapter5.aopnamespace;

import org.aspectj.lang.JoinPoint;

public class SimpleAdvice {

    public void simpleBeforeAdvice(JoinPoint joinPoint) {
        System.out.println("Executing: " + joinPoint.getSignature().getDeclaringTypeName() +
                " " + joinPoint.getSignature().getName());
    }
}
