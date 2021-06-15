package dev.bnayagrawal.prospring5.chapter3.lkpmthdinjctn;

public abstract class AbstractLookupDemoBean implements DemoBean {
    public abstract Singer getMySinger();

    @Override
    public void doSomething() {
        getMySinger().sing();
    }
}
