package dev.bnayagrawal.prospring5.chapter3.beannamealiasing;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Arrays;
import java.util.Map;

public class AliasConfigDemo {

    @Configuration
    public static class AliasBeanConfig {

        /* Toggle between these two annotations to see how bean name aliasing works */
        // @Bean
        @Bean(name={"johnMayer","john","johnathan","johnny"})
        public Singer singer() {
            return new Singer();
        }
    }

    public static void main(String[] args) {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(AliasBeanConfig.class);
        Map<String, Singer> beans = ctx.getBeansOfType(Singer.class);
        beans.entrySet().stream().forEach(b -> System.out.println("id: " + b.getKey() +
                "\n aliases: " +
                Arrays.toString(ctx.getAliases(b.getKey())) +
                "\n"
        ));
        ctx.close();
    }
}
