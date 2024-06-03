package ru.job4j.tracker.actions;

import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.input.Input;

public interface UserAction {
    String name();

    boolean execute(Input input, Tracker tracker);
}
