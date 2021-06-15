package dev.bnayagrawal.prospring5.chapter4.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfigSix {

    @Bean
    public MessageProvider messageProvider() {
        return new ConfigurableMessageProvider("Love on the weekend (AppConfigSix)");
    }
}
