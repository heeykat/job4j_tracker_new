package ru.job4j.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortBySet {
    public static Set<String> sort(List<String> list) {
        return new TreeSet<>(list);
    }

    public static void main(String[] args) {
        List<String> input = Arrays.asList("5", "4", "3", "2", "1");
        System.out.println(sort(input));
    }
}
