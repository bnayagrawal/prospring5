package dev.bnayagrawal.prospring5.chapter5.pfbintro;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    public Contact guitarist() {
        Contact guitarist = new Contact();
        guitarist.setName("John Mayer");
        return guitarist;
    }

    @Bean
    public Advisor advisor() {
        return new IsModifiedAdvisor();
    }

    @Bean
    ProxyFactoryBean bean() {
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        proxyFactoryBean.setTarget(guitarist());
        proxyFactoryBean.setProxyTargetClass(true);
        proxyFactoryBean.addAdvisor(advisor());
        return proxyFactoryBean;
    }
}
