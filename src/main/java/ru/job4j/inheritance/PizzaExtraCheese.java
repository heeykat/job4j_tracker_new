package ru.job4j.inheritance;

public class PizzaExtraCheese extends Pizza {
    private static final String CHEESE_NAME = "extra cheese";

    @Override
    public String name() {
        return super.name() + " + " + CHEESE_NAME;
    }
}
