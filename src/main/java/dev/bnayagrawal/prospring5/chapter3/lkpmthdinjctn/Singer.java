package dev.bnayagrawal.prospring5.chapter3.lkpmthdinjctn;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/*
* Annotations only required for ALookupDemo
* */
@Component("singer")
@Scope("prototype")
public class Singer {

    private String lyric = "I played a quick game of chess with the salt and pepper shaker";

    void sing(){

    }
}
