package ru.job4j.tracker.input;

import java.util.List;

public class MockInput implements Input {
    private List<String> answers;

    public MockInput(List<String> answers) {
        this.answers = answers;
    }

    @Override
    public String askStr(String question) {
        return answers.remove(0);
    }

    @Override
    public int askInt(String question) {
        return Integer.parseInt(askStr(question));
    }
}
