package dev.bnayagrawal.prospring5.chapter4.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigExampleOne {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MessageRenderer renderer = context.getBean("messageRenderer", MessageRenderer.class);
        renderer.render();
    }
}
