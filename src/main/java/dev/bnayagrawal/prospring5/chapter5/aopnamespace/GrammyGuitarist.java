package dev.bnayagrawal.prospring5.chapter5.aopnamespace;

public class GrammyGuitarist {

    public void sing() {
        System.out.println("sing: Just a simple one line string");
    }

    public void sing(Guitar guitar) {
        System.out.println("play: " + guitar.play());
    }

    public void talk() {
        System.out.println("talk");
    }
}
