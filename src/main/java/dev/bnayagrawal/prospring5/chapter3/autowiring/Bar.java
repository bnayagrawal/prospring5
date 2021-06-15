package dev.bnayagrawal.prospring5.chapter3.autowiring;

import org.springframework.stereotype.Component;

/* The annotation is only used by TrickyTarget class, the name attribute in the annotation has
* no effect as in auto wiring by annotation auto wiring byType is used */
@Component("Burger")
public class Bar {
}
