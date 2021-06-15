package dev.bnayagrawal.prospring5.chapter5.aspectj;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AspectJAnnotationDemo {

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:chapter5/aspectj/app-context-01-xml.xml");
        context.refresh();

        NewDocumentarist documentarist = context.getBean("documentarist", NewDocumentarist.class);
        documentarist.execute();
    }
}
