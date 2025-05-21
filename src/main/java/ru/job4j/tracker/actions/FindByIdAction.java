package ru.job4j.tracker.actions;

import ru.job4j.tracker.*;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;

public class FindByIdAction implements UserAction {
    private final Output output;

    public FindByIdAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Show the item by id";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        output.println("=== Showing the item by id ===");
        int id = input.askInt("Enter the id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            output.println(item);
        } else {
            output.println("Item with the entered id: " + id + " has not been found.");
        }
        return true;
    }
}
