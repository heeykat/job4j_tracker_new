package ru.job4j.tracker.actions;

import ru.job4j.tracker.Store;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;

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
    public boolean execute(Input input, Store tracker) {
        output.println("=== The program has been finished ===");
        return false;
    }
}
