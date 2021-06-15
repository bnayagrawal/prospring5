package dev.bnayagrawal.prospring5.chapter5.aopnamespace;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AopNamespaceDemo {

    public static void main(String[] args) {
        NewDocumentarist documentarist = getSimpleAdviceDocumentarist();
        documentarist.execute();
        documentarist = getComplexAdviceDocumentarist();
        documentarist.execute();
        documentarist = getAroundAdviceDocumentarist();
        documentarist.execute();
    }

    private static NewDocumentarist getSimpleAdviceDocumentarist() {
        System.out.println("\n=============== SimpleAdvice Demo ===============\n");
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:chapter5/aopnamespace/app-context-01-xml.xml");
        context.refresh();
        return context.getBean("documentarist", NewDocumentarist.class);
    }

    private static NewDocumentarist getComplexAdviceDocumentarist() {
        System.out.println("\n=============== ComplexAdvice Demo ===============\n");
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:chapter5/aopnamespace/app-context-02-xml.xml");
        context.refresh();
        return context.getBean("documentarist", NewDocumentarist.class);
    }

    private static NewDocumentarist getAroundAdviceDocumentarist() {
        System.out.println("\n=============== AroundAdvice Demo ===============\n");
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:chapter5/aopnamespace/app-context-03-xml.xml");
        context.refresh();
        return context.getBean("documentarist", NewDocumentarist.class);
    }
}
