package dev.bnayagrawal.prospring5.chapter4.envprpsrc;

import org.springframework.context.support.GenericXmlApplicationContext;

public class PlaceHolderDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:chapter4/envprpsrc/app-context-01-xml.xml");
        context.refresh();

        AppProperty appProperty = context.getBean("appProperty", AppProperty.class);
        System.out.println("application.home: " + appProperty.getApplicationHome());
        System.out.println("user.home: " + appProperty.getUserHome());

        context.close();
    }
}
