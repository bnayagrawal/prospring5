package dev.bnayagrawal.prospring5.chapter3.mthdrplcmnt;

public class ReplacementTarget {

    public String formatMessage(String msg) {
        return "<h1> " + msg + "</h1>";
    }

    public String formatMessage(Object msg) {
        return "<h1> " + msg + "</h1>";
    }
}
