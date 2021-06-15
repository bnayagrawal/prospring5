package dev.bnayagrawal.prospring5.chapter4.jsr330;

public interface MessageRenderer {
    void render();
    void setMessageProvider(MessageProvider provider);
    MessageProvider getMessageProvider();
}
