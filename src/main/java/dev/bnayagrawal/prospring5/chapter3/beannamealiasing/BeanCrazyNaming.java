package dev.bnayagrawal.prospring5.chapter3.beannamealiasing;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Arrays;
import java.util.Map;

public class BeanCrazyNaming {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:chapter3/beannamealiasing/app-context-02-xml.xml");
        ctx.refresh();

        Map<String, String> beans = ctx.getBeansOfType(String.class);
        beans.entrySet().stream().forEach(
                b -> {
                    System.out.println("id: " + b.getKey() +
                            "\n aliases: " +
                            Arrays.toString(ctx.getAliases(b.getKey())) +
                            "\n"
                    );
                }
        );

        ctx.close();
    }
}
