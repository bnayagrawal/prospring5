package dev.bnayagrawal.prospring5.chapter4.messagesource;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Locale;

public class MessageSourceDemo {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:chapter4/propertyeditor/app-context-03-xml.xml");
        ctx.refresh();

        Locale english = Locale.ENGLISH;
        Locale german = new Locale("de", "DE");

        System.out.println(ctx.getMessage("nameMsg", new Object[]{"John", "Mayer"}, english));
        System.out.println(ctx.getMessage("nameMsg", new Object[]{"John", "Mayer"}, german));

        ctx.close();
    }
}
