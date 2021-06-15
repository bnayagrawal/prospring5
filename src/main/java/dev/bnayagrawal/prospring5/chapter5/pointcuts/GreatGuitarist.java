package dev.bnayagrawal.prospring5.chapter5.pointcuts;

public class GreatGuitarist implements Singer {

    @Override
    public void sing() {
        System.out.println("I shot the sheriff, \n" + "But I did not shoot the deputy");
    }
}
