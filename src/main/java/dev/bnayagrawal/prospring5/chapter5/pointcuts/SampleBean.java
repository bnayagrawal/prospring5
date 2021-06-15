package dev.bnayagrawal.prospring5.chapter5.pointcuts;

public class SampleBean {

    public void foo(int x) {
        System.out.println("Invoked foo() with: " + x);
    }

    public void bar() {
        System.out.println("Invoked bar()");
    }
}
