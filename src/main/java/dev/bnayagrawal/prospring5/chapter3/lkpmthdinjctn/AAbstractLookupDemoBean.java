package dev.bnayagrawal.prospring5.chapter3.lkpmthdinjctn;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component("aAbstractLookupBean")
public class AAbstractLookupDemoBean implements DemoBean {

    @Lookup("singer")
    public Singer getMySinger() {
        return null;
    }

    @Override
    public void doSomething() {
        getMySinger().sing();
    }
}
