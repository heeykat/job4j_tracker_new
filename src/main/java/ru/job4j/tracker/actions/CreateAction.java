package ru.job4j.tracker.actions;

import ru.job4j.tracker.*;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;

public class CreateAction implements UserAction {
    private final Output output;

    public CreateAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Add new item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Adding new item ===");
        String name = input.askStr("Enter the name: ");
        Item item = new Item(name);
        tracker.add(item);
        output.println("Item has been added: " + item);
        return true;
    }
}
