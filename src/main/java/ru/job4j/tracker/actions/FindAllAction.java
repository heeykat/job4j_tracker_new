package ru.job4j.tracker.actions;

import ru.job4j.tracker.*;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;

public class FindAllAction implements UserAction {
    private final Output output;

    public FindAllAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Showing all items ===");
        Item[] items = tracker.findAll();
        if (items.length > 0) {
            for (Item item : items) {
                output.println(item);
            }
        } else {
            output.println("The repository does not contain items yet");
        }
        return true;
    }
}
