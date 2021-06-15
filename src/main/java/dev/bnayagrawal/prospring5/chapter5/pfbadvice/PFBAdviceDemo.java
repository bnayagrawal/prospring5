package dev.bnayagrawal.prospring5.chapter5.pfbadvice;

import org.springframework.context.support.GenericXmlApplicationContext;

public class PFBAdviceDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:chapter5/pfbadvice/app-context-01-xml.xml");
        context.refresh();

        Documentarist documentaristOne = context.getBean("documentaristOne", Documentarist.class);
        Documentarist documentaristTwo = context.getBean("documentaristTwo", Documentarist.class);

        System.out.println("Documentarist One >>");
        documentaristOne.execute();

        System.out.println("\nDocumentarist Two >>");
        documentaristTwo.execute();
    }
}
