package dev.bnayagrawal.prospring5.chapter4.factorybeans;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.security.MessageDigest;

public class AccessingFactoryBeans {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:chapter4/factorybeans/app-context-01-xml.xml");
        ctx.refresh();

        ctx.getBean("shaDigest", MessageDigest.class);
        MessageDigestFactoryBean factoryBean = (MessageDigestFactoryBean) ctx.getBean("&shaDigest");
        try{
            MessageDigest shaDigest = factoryBean.getObject();
            System.out.println(shaDigest.digest("Hello world".getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        ctx.close();
    }
}
