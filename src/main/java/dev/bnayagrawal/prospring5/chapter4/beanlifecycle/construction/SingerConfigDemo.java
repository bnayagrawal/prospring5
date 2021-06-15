package dev.bnayagrawal.prospring5.chapter4.beanlifecycle.construction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.GenericApplicationContext;

public class SingerConfigDemo {

    @Configuration
    static class SingerConfig {

        @Lazy
        @Bean(initMethod = "init")
        Singer singerOne() {
            Singer singer = new Singer();
            singer.setName("John Mayer");
            singer.setAge(39);
            return singer;
        }

        @Lazy
        @Bean(initMethod = "init")
        Singer singerTwo() {
            Singer singer = new Singer();
            singer.setAge(72);
            return singer;
        }

        @Lazy
        @Bean(initMethod = "init")
        Singer singerThree() {
            Singer singer = new Singer();
            singer.setName("John Butler");
            return singer;
        }
    }

    public static void main(String[] args) {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(SingerConfig.class);
        Singer.getBean("singerOne", ctx);
        Singer.getBean("singerTwo", ctx);
        Singer.getBean("singerThree", ctx);
        ctx.close();
    }
}
