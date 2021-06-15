package dev.bnayagrawal.prospring5.chapter5.aspectj;

public class Documentarist {

    protected GrammyGuitarist guitarist;

    public void execute() {
        guitarist.sing();
        guitarist.talk();
    }

    public void setGuitarist(GrammyGuitarist guitarist) {
        this.guitarist = guitarist;
    }
}
