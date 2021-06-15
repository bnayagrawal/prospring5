package dev.bnayagrawal.prospring5.chapter4.profiles;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class ProfileXMLConfigExample {
    // Run this with JVM arg -Dspring.profiles.active="PROFILE_NAME"
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:chapter4/profiles/*-config.xml");
        ctx.refresh();

        FoodProviderService foodProviderService = ctx.getBean("foodProviderService", FoodProviderService.class);
        List<Food> lunchSet = foodProviderService.provideLunchSet();

        lunchSet.forEach(System.out::println);
        ctx.close();
    }
}
