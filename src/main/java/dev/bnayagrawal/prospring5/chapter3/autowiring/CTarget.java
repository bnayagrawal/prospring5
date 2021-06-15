package dev.bnayagrawal.prospring5.chapter3.autowiring;

import org.springframework.context.support.GenericXmlApplicationContext;

public class CTarget {
    private FooInterface fooOne;
    private FooInterface fooTwo;
    private Bar bar;

    public CTarget() {

    }

    public CTarget(FooInterface foo) {
        System.out.println("CTarget(Foo) called");
    }

    public CTarget(FooInterface foo, Bar bar) {
        System.out.println("CTarget(Foo, Bar) called");
    }

    public void setFooOne(FooInterface fooOne) {
        this.fooOne = fooOne;
        System.out.println("Property fooOne set");
    }

    public void setFooTwo(FooInterface foo) {
        this.fooTwo = foo;
        System.out.println("Property fooTwo set");
    }

    public void setBar(Bar bar) {
        this.bar = bar;
        System.out.println("Property bar set");
    }


    /**
     * This may throw exceptions because of auto-wiring byType
     *y
     * See app-context-02-xml for primary attribute
     *
     * @param args cli args
     */
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:chapter3/autowiring/app-context-02-xml.xml");
        ctx.refresh();
        System.out.println("\nUsing byType:\n");
        CTarget t = (CTarget) ctx.getBean("targetByType");
        ctx.close();
    }
}
