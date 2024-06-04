package ru.job4j.tracker.actions;

import ru.job4j.tracker.*;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;

import java.util.List;

public class FindByNameAction implements UserAction {
    private final Output output;

    public FindByNameAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Show items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Showing items by name ===");
        String name = input.askStr("Enter the name: ");
        List<Item> items = tracker.findByName(name);
        if (!items.isEmpty()) {
            for (Item item : items) {
                output.println(item);
            }
        } else {
            output.println("Item with the entered name: " + name + " has not been found.");
        }
        return true;
    }
}
