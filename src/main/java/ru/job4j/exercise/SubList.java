package ru.job4j.exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubList {
    public static List<String> getElementsBetweenIndexes(List<String> list, String el) {
        int i = Collections.frequency(list, el);
        return i == 0 || i == 1 ? new ArrayList<>() : list.subList(list.indexOf(el), list.lastIndexOf(el));
    }
}
