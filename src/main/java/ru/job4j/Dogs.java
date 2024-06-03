package ru.job4j;

public class Dogs {
    private String name;

    public void eat() {
        System.out.println("Ham!");
    }

    class Dog {
    }

    public static void main(String[] args) {
        Dog dog = new Dogs().new Dog();
    }
}
