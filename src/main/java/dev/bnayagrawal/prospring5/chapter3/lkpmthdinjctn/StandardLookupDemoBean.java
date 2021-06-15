package dev.bnayagrawal.prospring5.chapter3.lkpmthdinjctn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/*
 * Annotations only required for ALookupDemo
 * */
@Component("standardLookupBean")
public class StandardLookupDemoBean implements DemoBean {

    private Singer mySinger;

    @Autowired
    @Qualifier("singer")
    public void setMySinger(Singer mySinger) {
        this.mySinger = mySinger;
    }

    @Override
    public Singer getMySinger() {
        return this.mySinger;
    }

    @Override
    public void doSomething() {
        mySinger.sing();
    }
}
