package dev.bnayagrawal.prospring5.chapter5.aspectj;

public class Guitar {
    private String brand = "Martin";

    public String play() {
        return "Going back!";
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
