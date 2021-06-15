package dev.bnayagrawal.prospring5.chapter5.aopnamespace;

import org.aspectj.lang.JoinPoint;

public class ComplexAdvice {
    public void simpleBeforeAdvice(JoinPoint joinPoint, Guitar value) {
        if(value.getBrand().equals("Gibson")) {
            System.out.println("Executing: " + joinPoint.getSignature().getDeclaringTypeName() +
                    " " + joinPoint.getSignature().getName());
        }
    }
}
