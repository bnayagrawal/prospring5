package dev.bnayagrawal.prospring5.chapter4.jsr330;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

@Named("messageRenderer")
@Singleton
public class StandardOutMessageRenderer implements MessageRenderer {

    @Inject
    @Named("messageProvider")
    private MessageProvider messageProvider;

    @Override
    public void render() {
        if(null == messageProvider) {
            throw new RuntimeException("You must set the property messageProvider of class:" +
                    StandardOutMessageRenderer.class.getName());
        }
        System.out.println(messageProvider.getMessage());
    }

    @Override
    public MessageProvider getMessageProvider() {
        return messageProvider;
    }

    @Override
    public void setMessageProvider(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }
}
