package dev.bnayagrawal.prospring5.chapter5.afteradvice;

import java.util.Random;

public class KeyGenerator {
    protected static final long WEAK_KEY = 0xFFFFFFF0000000L;
    protected static final long STRONG_KEY = 0XACDF03F590AE56L;

    private Random random = new Random();

    public long getKey() {
        int x = random.nextInt(3);

        if(1 == x) {
            return WEAK_KEY;
        }

        return STRONG_KEY;
    }
}
