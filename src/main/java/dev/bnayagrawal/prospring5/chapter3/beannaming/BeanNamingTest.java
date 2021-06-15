package dev.bnayagrawal.prospring5.chapter3.beannaming;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Map;

public class BeanNamingTest {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:chapter3/beannaming/app-context-01-xml.xml");
        ctx.refresh();

        Map<String, String> beans = ctx.getBeansOfType(String.class);
        beans.entrySet().stream().forEach(b -> System.out.println(b.getKey()));
        ctx.close();
    }
}
