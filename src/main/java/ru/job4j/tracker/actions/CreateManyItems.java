package ru.job4j.tracker.actions;

import ru.job4j.tracker.*;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;

public class CreateManyItems implements UserAction {
    private final Output out;

    public CreateManyItems(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Create many items";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Create many items ===");
        int count = input.askInt("Enter the number of items ");
        for (int i = 0; i < count; i++) {
            tracker.add(new Item("Item № " + i));
        }
        out.println("Added items " + count);
        return true;
    }
}