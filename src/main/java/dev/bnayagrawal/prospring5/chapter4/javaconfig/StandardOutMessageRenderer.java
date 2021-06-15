package dev.bnayagrawal.prospring5.chapter4.javaconfig;

public class StandardOutMessageRenderer implements MessageRenderer {
    private MessageProvider messageProvider;

    public StandardOutMessageRenderer() {
        System.out.println("--> StandardOutMessageRenderer: constructor called");
    }

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
        System.out.println("--> StandardOutMessageRenderer: setting the provider");
        this.messageProvider = messageProvider;
    }
}
