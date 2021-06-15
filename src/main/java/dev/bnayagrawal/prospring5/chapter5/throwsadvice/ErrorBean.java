package dev.bnayagrawal.prospring5.chapter5.throwsadvice;

public class ErrorBean {

    public void errorProneMethod() throws Exception {
        throw new Exception("Generic Exception");
    }

    public void otherErrorProneMethod() throws IllegalArgumentException {
        throw new IllegalArgumentException("IllegalArgumentException");
    }
}