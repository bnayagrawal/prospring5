package dev.bnayagrawal.prospring5.chapter4.factorybeans;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MessageDigestFactoryDemo {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:chapter4/factorybeans/app-context-02-xml.xml");
        ctx.refresh();

        MessageDigester digester = ctx.getBean("digester", MessageDigester.class);
        digester.digest("Hello World!");
        ctx.close();
    }
}
