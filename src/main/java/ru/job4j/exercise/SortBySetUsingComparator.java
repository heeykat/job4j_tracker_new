package ru.job4j.exercise;

import java.util.*;

public class SortBySetUsingComparator {
    public static Set<String> sort(List<String> list) {
        Set<String> set = new TreeSet<>(Comparator.reverseOrder());
        set.addAll(list);
        return set;
    }

    public static void main(String[] args) {
        List<String> input = Arrays.asList("1", "2", "3", "4", "5");
        System.out.println(sort(input));
    }
}