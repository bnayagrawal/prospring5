package dev.bnayagrawal.prospring5.chapter5.pointcuts;

public class Guitarist implements Singer {

    @Override
    public void sing() {
        System.out.println("Just keep me where the light is");
    }

    public void sing2() {
        System.out.println("oh gravity, stay the hell away from me");
    }

    public void rest() {
        System.out.println("zzz");
    }
}
