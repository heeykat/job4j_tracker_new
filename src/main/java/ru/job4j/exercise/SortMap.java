package ru.job4j.exercise;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class SortMap {
    public static Map<Integer, String> sort(Map<Integer, String> map) {
        Map<Integer, String> rst = new TreeMap<>(Comparator.reverseOrder());
        rst.putAll(map);
        return rst;
    }

    public static void main(String[] args) {
        Map<Integer, String> input = Map.of(
                1, "1",
                2, "2",
                3, "3"
        );
        System.out.println(sort(input));
    }
}