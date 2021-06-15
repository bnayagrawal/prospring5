package dev.bnayagrawal.prospring5.chapter4.jsr330;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Jsr330Demo {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:chapter4/jsr330/app-context-annotation.xml");
        context.refresh();

        MessageRenderer renderer = context.getBean("messageRenderer", MessageRenderer.class);
        renderer.render();
        context.close();
    }
}
