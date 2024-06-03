package ru.job4j.tracker.actions;

import ru.job4j.tracker.*;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;

public class DeleteAction implements UserAction {
    private final Output output;

    public DeleteAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Delete the item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Deleting the item ===");
        int id = input.askInt("Enter the id: ");
        Item item = tracker.findById(id);
        tracker.delete(id);
        output.println(item != null ? "Item has been deleted successfully." : "Item deleting error.");
        return true;
    }
}
