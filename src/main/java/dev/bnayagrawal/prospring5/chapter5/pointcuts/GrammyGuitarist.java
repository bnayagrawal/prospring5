package dev.bnayagrawal.prospring5.chapter5.pointcuts;

public class GrammyGuitarist implements Singer {

    @Override
    public void sing() {
        System.out.println("sing: Just a simple one line string");
    }

    // This annotation is used here only for to demonstrate AnnotationMatchingPointcut
    // otherwise this annotation is not used anywhere
    @AdviceRequired
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
