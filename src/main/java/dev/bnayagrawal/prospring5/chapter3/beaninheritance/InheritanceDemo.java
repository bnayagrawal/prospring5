package dev.bnayagrawal.prospring5.chapter3.beaninheritance;

import org.springframework.context.support.GenericXmlApplicationContext;

public class InheritanceDemo {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:chapter3/beaninheritance/app-context-xml.xml");
        ctx.refresh();

        Singer parent = (Singer) ctx.getBean("parent");
        Singer child = (Singer) ctx.getBean("child");

        System.out.println("Parent:\n" + parent);
        System.out.println("Child:\n" + child);
    }
}
