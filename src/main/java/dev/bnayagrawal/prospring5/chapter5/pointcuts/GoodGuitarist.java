package dev.bnayagrawal.prospring5.chapter5.pointcuts;

public class GoodGuitarist implements Singer {
    @Override
    public void sing() {
        System.out.println("Who says I can't be free \n" + "From all of the things that I used to be");
    }
}
