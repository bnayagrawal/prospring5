package dev.bnayagrawal.prospring5.chapter4.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigExampleThree {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfigThree.class);
        MessageRenderer renderer = context.getBean("messageRenderer", MessageRenderer.class);
        renderer.render();
    }
}
