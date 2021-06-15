package dev.bnayagrawal.prospring5.chapter5.pfbadvice;

public class Documentarist {

    private GrammyGuitarist guitarist;

    public void execute() {
        guitarist.sing();
        guitarist.talk();
    }

    public void setGuitarist(GrammyGuitarist guitarist) {
        this.guitarist = guitarist;
    }
}
