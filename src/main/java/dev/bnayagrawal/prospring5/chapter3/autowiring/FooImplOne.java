package dev.bnayagrawal.prospring5.chapter3.autowiring;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/* This annotation is only used by CTrickyTarget*/
@Component
@Primary // Remove this annotation to see the main method in CTrickyTarget throw error
public class FooImplOne implements FooInterface {
}
