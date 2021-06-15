package dev.bnayagrawal.prospring5.chapter3.rslvngdpndncs;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

/* These annotations are only required by ADependsOnDemo */
@Component("johnMayer")
@DependsOn("gopher")
public class Singer implements ApplicationContextAware {

    ApplicationContext ctx;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }

    private Guitar guitar;

    public Singer() {

    }

    public void sing() {
        guitar = (Guitar) ctx.getBean("gopher", "Guitar.class");
        guitar.sing();
    }
}
