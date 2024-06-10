package ru.job4j.exercise;

import java.util.ArrayList;
import java.util.List;

public class RepositionElement {
    public static List<String> changePosition(List<String> list, int index) {
        String el = list.remove(list.size() - 1);
        if (index < list.size()) {
            list.set(index, el);
        }
        return list;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        list.add("six");
        list.add("seven");
        list.add("eight");
        list.add("nine");
        System.out.println(changePosition(list, 3));
    }
}
