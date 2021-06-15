package dev.bnayagrawal.prospring5.chapter5.demo;

import org.springframework.aop.framework.ProxyFactory;

public class AgentAOPDemo {
    public static void main(String[] args) {
        Agent target = new Agent();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new AgentDecorator());
        proxyFactory.setTarget(target);

        Agent proxy = (Agent) proxyFactory.getProxy();
        target.speak();
        System.out.println("");
        proxy.speak();
    }
}
