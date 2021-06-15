package dev.bnayagrawal.prospring5.chapter3.beaninheritance;

public class Singer {
    public String name;
    public String age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Singer{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
