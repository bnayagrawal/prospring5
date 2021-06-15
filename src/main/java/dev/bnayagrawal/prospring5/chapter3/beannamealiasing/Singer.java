package dev.bnayagrawal.prospring5.chapter3.beannamealiasing;

import org.springframework.stereotype.Component;

/* Toggle between these annotations to see how bean naming works */
// @Component
@Component("johnMayer")
public class Singer {

    private String lyric = "We found a message in a bottle we were drinking";

    public void sing() {
        System.out.println(lyric);
    }
}
