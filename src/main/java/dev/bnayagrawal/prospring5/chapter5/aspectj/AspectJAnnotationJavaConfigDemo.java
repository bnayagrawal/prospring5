package dev.bnayagrawal.prospring5.chapter5.aspectj;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.GenericApplicationContext;

public class AspectJAnnotationJavaConfigDemo {


    @Configuration
    @ComponentScan(basePackages = {"dev.bnayagrawal.prospring5.chapter5.aspectj"})
    @EnableAspectJAutoProxy(proxyTargetClass = true)
    static class AppConfig {

    }

    public static void main(String[] args) {
        GenericApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        NewDocumentarist documentarist = context.getBean("documentarist", NewDocumentarist.class);
        documentarist.execute();
    }
}
