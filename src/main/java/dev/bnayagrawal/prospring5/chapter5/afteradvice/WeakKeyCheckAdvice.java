package dev.bnayagrawal.prospring5.chapter5.afteradvice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

import static dev.bnayagrawal.prospring5.chapter5.afteradvice.KeyGenerator.WEAK_KEY;

public class WeakKeyCheckAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object retVal, Method method, Object[] args, Object target) throws Throwable {
        if((target instanceof KeyGenerator) && ("getKey".equals(method.getName()))) {
            long key = ((Long) retVal).longValue();
            if(WEAK_KEY == key) {
                throw new SecurityException("Key Generator generated a weak key. Try again");
            }
        }
    }
}
