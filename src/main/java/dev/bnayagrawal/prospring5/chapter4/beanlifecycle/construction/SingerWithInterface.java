package dev.bnayagrawal.prospring5.chapter4.beanlifecycle.construction;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SingerWithInterface implements InitializingBean {

    private static final String DEFAULT_NAME = "Eric Claption";

    private String name;
    private int age = Integer.MIN_VALUE;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initializing bean");

        if(null == name) {
            System.out.println("Using default name");
            name = DEFAULT_NAME;
        }

        if(Integer.MIN_VALUE == age) {
            throw new IllegalArgumentException(
                    "You must set the age property of any bean of type " + Singer.class
            );
        }
    }

    @Override
    public String toString() {
        return "Singer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:chapter4/beanlifecycle/construction/app-context-02-xml.xml");
        ctx.refresh();

        getBean("singerOne", ctx);
        getBean("singerTwo", ctx);
        getBean("singerThree", ctx);
    }

    public static SingerWithInterface getBean(String beanName, GenericXmlApplicationContext ctx) {
        try {
            SingerWithInterface bean = (SingerWithInterface) ctx.getBean(beanName);
            System.out.println(bean);
            return bean;
        } catch (BeanCreationException ex) {
            System.out.println("An error occurred in bean configuration: " + ex.getMessage());
            return null;
        }
    }
}
