package dev.bnayagrawal.prospring5.chapter3.injectingclxn;

import org.springframework.stereotype.Service;

// This below annotation is provided only for to demonstrate
// the annotation config used by ACollectionInjection. For
// simple CollectionInjection class, it is not used there.
@Service("lyricHolder")
public class LyricHolder implements ContentHolder {

    private String value = "I did it for me, I was good at it.";

    @Override
    public String toString() {
        return "LyricHolder{" +
                "value='" + value + '\'' +
                '}';
    }
}
