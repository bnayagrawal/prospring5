package dev.bnayagrawal.prospring5.chapter5.aroundadvice;

public class WorkBean {

    public void doSomeWork(int noOfTimes) {
        for(int x = 0; x < noOfTimes; x++) {
            work();
        }
    }

    private void work() {
        System.out.print("");
    }
}
