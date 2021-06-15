package dev.bnayagrawal.prospring5.chapter5.pfbintro;

import org.springframework.context.support.GenericXmlApplicationContext;

public class IntroductionConfigDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:chapter5/pfbintro/app-context-01-xml.xml");
        context.refresh();

        Contact bean = (Contact) context.getBean("bean");
        IsModified proxyInterface = (IsModified) bean;

        System.out.println("Is Contact?: " + (bean instanceof Contact));
        System.out.println("Is IsModified?: " + (bean instanceof IsModified));

        System.out.println("Has been modified?: " + proxyInterface.isModified());

        bean.setName("John Mayer");

        System.out.println("Has been modified?: " + proxyInterface.isModified());

        bean.setName("Eric Clapton");

        System.out.println("Has been modified?: " + proxyInterface.isModified());
    }
}
