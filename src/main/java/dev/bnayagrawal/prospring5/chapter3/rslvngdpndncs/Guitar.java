package dev.bnayagrawal.prospring5.chapter3.rslvngdpndncs;

import org.springframework.stereotype.Component;

/* These annotations are only required by ADependsOnDemo */
@Component("gopher")
public class Guitar {
    public void sing() {
        System.out.println("Cm Eb Fm Ab Bb");
    }
}
