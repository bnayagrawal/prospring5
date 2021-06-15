package dev.bnayagrawal.prospring5.chapter4.javaconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

// These annotations are used by JavaConfigExampleTwo only
@Service("provider")
public class ConfigurableMessageProvider implements MessageProvider {
    private String message = "Default message";

    // To use the injected message demo, remove this
    // constructor and run JavaConfigExampleTwo or JavaConfigExampleThree
    ConfigurableMessageProvider() {

    }

    ConfigurableMessageProvider(@Value("Love on the weekend (@Value)") String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
