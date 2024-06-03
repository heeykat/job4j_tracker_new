package ru.job4j.polymorphism;

public class Plane implements Transport {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " - The plane flies through the air");
    }
}
