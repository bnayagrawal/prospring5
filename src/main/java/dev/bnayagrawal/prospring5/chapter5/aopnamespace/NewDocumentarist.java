package dev.bnayagrawal.prospring5.chapter5.aopnamespace;

public class NewDocumentarist extends Documentarist {

    @Override
    public void execute() {
        guitarist.sing();
        Guitar guitar = new Guitar();
        guitar.setBrand("Gibson");
        guitarist.sing(guitar);
        // Only for use in around advice
        guitarist.sing(new Guitar());
        guitarist.talk();
    }
}
