package dev.bnayagrawal.prospring5.chapter4.javaconfig;

public interface MessageRenderer {
    void render();
    void setMessageProvider(MessageProvider provider);
    MessageProvider getMessageProvider();
}
