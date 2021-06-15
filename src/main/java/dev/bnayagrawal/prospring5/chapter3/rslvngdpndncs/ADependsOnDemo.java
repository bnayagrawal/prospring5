package dev.bnayagrawal.prospring5.chapter3.rslvngdpndncs;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ADependsOnDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:chapter3/rslvngdpndncs/app-context-01-annotation.xml");
        context.refresh();

        Singer johnMayer = context.getBean("johnMayer", Singer.class);
        johnMayer.sing();
        context.close();
    }
}
