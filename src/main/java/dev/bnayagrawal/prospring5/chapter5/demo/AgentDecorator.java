package dev.bnayagrawal.prospring5.chapter5.demo;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AgentDecorator implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.print("James ");
        Object retVal = methodInvocation.proceed();
        System.out.println("!");
        return retVal;
    }
}
