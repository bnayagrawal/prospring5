package dev.bnayagrawal.prospring5.chapter5.aopnamespace;

import org.aspectj.lang.ProceedingJoinPoint;

public class AroundAdvice {
    public Object simpleAroundAdvice(ProceedingJoinPoint pjp, Guitar value) throws Throwable {
        System.out.println("Before execution: " + pjp.getSignature().getDeclaringTypeName() +
                " " + pjp.getSignature().getName() + " argument: " + value.getBrand());

        Object retVal = pjp.proceed();

        System.out.println("After execution: " + pjp.getSignature().getDeclaringTypeName() +
                " " + pjp.getSignature().getName() + " argument: " + value.getBrand());
        return retVal;
    }
}
