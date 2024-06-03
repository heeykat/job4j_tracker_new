package ru.job4j.tracker.actions;

import ru.job4j.tracker.*;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;

public class ReplaceAction implements UserAction {
    private final Output output;

    public ReplaceAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Change the item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Changing the item ===");
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            output.println("Item has been changed successfully.");
        } else {
            output.println("Item change error.");
        }
        return true;
    }
}
