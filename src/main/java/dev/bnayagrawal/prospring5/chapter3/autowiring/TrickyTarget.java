package dev.bnayagrawal.prospring5.chapter3.autowiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class TrickyTarget {

    private Foo fooOne;
    private Foo fooTwo;
    private Bar bar;

    public TrickyTarget() {

    }

    public TrickyTarget(Foo foo) {
        System.out.println("TrickyTarget(Foo) called");
    }

    public TrickyTarget(Foo foo, Bar bar) {
        System.out.println("TrickyTarget(Foo, Bar) called");
    }

    @Autowired
    public void setFooOne(Foo fooOne) {
        this.fooOne = fooOne;
        System.out.println("Property fooOne set");
    }

    @Autowired
    public void setFooTwo(Foo foo) {
        this.fooTwo = foo;
        System.out.println("Property fooTwo set");
    }

    @Autowired
    public void setBar(Bar bar) {
        this.bar = bar;
        System.out.println("Property bar set");
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:chapter3/autowiring/app-context-01-annotation.xml");
        ctx.refresh();
        TrickyTarget t = ctx.getBean(TrickyTarget.class);
        ctx.close();
    }
}
