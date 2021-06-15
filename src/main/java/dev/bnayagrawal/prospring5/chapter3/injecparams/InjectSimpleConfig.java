package dev.bnayagrawal.prospring5.chapter3.injecparams;

import org.springframework.stereotype.Component;

// Annotating only for use in AInjectSimpleSpel, for InjectSImpleSpel
// the below annotation is not required
@Component("injectSimpleConfig")
public class InjectSimpleConfig {
    private String name = "John Mayer";
    private int age = 39;
    private float height = 1.92f;
    private boolean programmer = true;
    private Long ageInSeconds = 1241401112l;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public float getHeight() {
        return height;
    }

    public boolean isProgrammer() {
        return programmer;
    }

    public Long getAgeInSeconds() {
        return ageInSeconds;
    }
}
