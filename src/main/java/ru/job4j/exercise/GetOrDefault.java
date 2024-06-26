package ru.job4j.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetOrDefault {
    private Map<Integer, List<String>> store = new HashMap<>();

    public void addValue(int index, List<String> list) {
        if (getValue(index).isEmpty()) {
            store.put(index, list);
        }
    }

    public List<String> getValue(int index) {
        return store.getOrDefault(index, new ArrayList<>());
    }

    public static void main(String[] args) {
        List<String> list = List.of("one", "two", "three");
        List<String> second = List.of("four", "five", "six");
        GetOrDefault get = new GetOrDefault();
        get.addValue(1, list);
        get.addValue(2, second);
        List<String> value = get.getValue(2);
        System.out.println(value);
    }
}
