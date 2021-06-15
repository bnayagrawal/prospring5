package dev.bnayagrawal.prospring5.chapter5.pointcuts;

public class DefaultSimpleBean implements AdviceType {
    private long dummy = 0;

    @Override
    public void advised() {
        dummy = System.currentTimeMillis();
    }

    @Override
    public void unadvised() {
        dummy = System.currentTimeMillis();
    }
}
