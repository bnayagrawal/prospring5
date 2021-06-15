package dev.bnayagrawal.prospring5.chapter4.appevents;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Publisher implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void publish(String message) {
        applicationContext.publishEvent(new MessageEvent(this, message));
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath:chapter4/appevents/app-context-01-xml.xml");

        Publisher publisher = (Publisher) context.getBean("publisher");
        publisher.publish("Hello world...");
        publisher.publish("Yet another message event...");
        publisher.publish("bubye");
    }
}
