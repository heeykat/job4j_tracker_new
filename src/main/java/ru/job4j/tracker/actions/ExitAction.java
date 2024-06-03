package ru.job4j.tracker.actions;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.Tracker;

public class ExitAction implements UserAction {
    private final Output output;

    public ExitAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Finish the program";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== The program has been finished ===");
        return false;
    }
}
