package dev.bnayagrawal.prospring5.chapter4.profiles;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;

public class ProfileJavaConfigExample {
    // Run this with JVM arg -Dspring.profiles.active="PROFILE_NAME"
    public static void main(String[] args) {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(
                KindergartenConfig.class,
                HighschoolConfig.class
        );

        FoodProviderService foodProviderService = ctx.getBean("foodProviderService", FoodProviderService.class);
        List<Food> lunchSet = foodProviderService.provideLunchSet();
        lunchSet.forEach(System.out::println);
    }
}
