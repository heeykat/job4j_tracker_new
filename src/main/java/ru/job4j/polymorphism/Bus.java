package ru.job4j.polymorphism;

public class Bus implements Transport {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " - The bus moves by the roads");
    }
}
