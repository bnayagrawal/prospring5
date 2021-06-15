package dev.bnayagrawal.prospring5.chapter3.beannamealiasing;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Map;

public class AnnotatedBeanNaming {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:chapter3/beannamealiasing/app-context-annotated.xml");
        ctx.refresh();

        /* SEE SINGER CLASS */

        Map<String, Singer> beans = ctx.getBeansOfType(Singer.class);
        beans.entrySet().stream().forEach(b -> System.out.println("id: " + b.getKey()));
        ctx.close();
    }
}
