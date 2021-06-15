package dev.bnayagrawal.prospring5.chapter5.afteradvice;

import org.springframework.aop.framework.ProxyFactory;

public class AfterAdviceDemo {
    private static KeyGenerator getKeyGenerator() {
        KeyGenerator target = new KeyGenerator();
        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(target);
        factory.addAdvice(new WeakKeyCheckAdvice());

        return (KeyGenerator) factory.getProxy();
    }

    public static void main(String[] args) {
        KeyGenerator keyGenerator = getKeyGenerator();
        for(int x = 0; x < 10; x++) {
            try {
                long key = keyGenerator.getKey();
                System.out.println("Key: " + key);
            } catch (SecurityException e) {
                System.out.println("Weak Key Generated!");
            }
        }
    }
}
