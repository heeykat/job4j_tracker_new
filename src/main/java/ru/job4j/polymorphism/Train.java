package ru.job4j.polymorphism;

public class Train implements Transport {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " - The train rides on the rails");
    }
}
