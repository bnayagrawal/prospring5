package dev.bnayagrawal.prospring5.chapter5.afteradvice;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

public class SimpleAfterAdvice implements AfterReturningAdvice {

    public static void main(String[] args) {
        Guitarist johnMayer = new Guitarist();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new SimpleAfterAdvice());
        proxyFactory.setTarget(johnMayer);
        Guitarist proxy = (Guitarist) proxyFactory.getProxy();
        proxy.sing();
    }

    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("After '" + method.getName() + "', put down guitar. ");
    }
}
