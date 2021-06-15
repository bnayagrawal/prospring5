package dev.bnayagrawal.prospring5.chapter4.javaconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"dev.bnayagrawal.prospring5.chapter4.javaconfig"})
public class AppConfigTwo {

    @Autowired
    MessageProvider messageProvider;

    @Bean(name = "messageRenderer")
    public MessageRenderer messageRenderer() {
        MessageRenderer messageRenderer = new StandardOutMessageRenderer();
        messageRenderer.setMessageProvider(messageProvider);
        return messageRenderer;
    }
}
