package dev.bnayagrawal.prospring5.chapter3.autowiring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;

public class TargetDemo {

    @Configuration
    static class TargetConfig {

        @Bean
        public FooInterface fooImplOne() {
            return new FooImplOne();
        }

        @Bean
        public FooInterface fooImplTwo() {
            return new FooImplTwo();
        }

        @Bean
        public Bar bar() {
            return new Bar();
        }

        @Bean
        public CTrickyTarget cTrickyTarget() {
            return new CTrickyTarget();
        }
    }

    public static void main(String[] args) {
        GenericApplicationContext context = new AnnotationConfigApplicationContext(TargetConfig.class);
        CTrickyTarget t = context.getBean(CTrickyTarget.class);
        context.close();
    }
}
