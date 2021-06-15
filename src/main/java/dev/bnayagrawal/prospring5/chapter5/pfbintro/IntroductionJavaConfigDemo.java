package dev.bnayagrawal.prospring5.chapter5.pfbintro;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class IntroductionJavaConfigDemo {
    public static void main(String[] args) {
        GenericApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

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
