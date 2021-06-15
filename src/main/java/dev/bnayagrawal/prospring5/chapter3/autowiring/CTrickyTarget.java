package dev.bnayagrawal.prospring5.chapter3.autowiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class CTrickyTarget {
    private FooInterface fooOne;
    private FooInterface fooTwo;
    private Bar bar;

    public CTrickyTarget() {

    }

    public CTrickyTarget(FooInterface foo) {
        System.out.println("CTrickyTarget(Foo) called");
    }

    public CTrickyTarget(FooInterface foo, Bar bar) {
        System.out.println("CTrickyTarget(Foo, Bar) called");
    }

    @Autowired
    @Qualifier("fooImplOne") // Only used by TargetDemo
    public void setFooOne(FooInterface fooOne) {
        this.fooOne = fooOne;
        System.out.println("Property fooOne set");
    }

    @Autowired
    @Qualifier("fooImplTwo") // Only used by TargetDemo
    public void setFooTwo(FooInterface foo) {
        this.fooTwo = foo;
        System.out.println("Property fooTwo set");
    }

    @Autowired
    public void setBar(Bar bar) {
        this.bar = bar;
        System.out.println("Property bar set");
    }


    /**
     * This may throw exceptions because of auto-wiring byType
     *y
     * See FooImplOne for primary attribute
     *
     * @param args cli args
     */
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:chapter3/autowiring/app-context-02-annotation.xml");
        ctx.refresh();
        System.out.println("\nUsing byType:\n");
        CTrickyTarget t = ctx.getBean(CTrickyTarget.class);
        ctx.close();
    }
}
