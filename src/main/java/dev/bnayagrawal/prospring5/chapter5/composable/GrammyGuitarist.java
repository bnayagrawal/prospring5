package dev.bnayagrawal.prospring5.chapter5.composable;

public class GrammyGuitarist implements Singer {

    @Override
    public void sing() {
        System.out.println("sing: Just a simple one line string");
    }

    public void sing(Guitar guitar) {
        System.out.println("play: " + guitar.play());
    }

    public void rest() {
        System.out.println("zzz");
    }

    public void talk() {
        System.out.println("talk");
    }
}
