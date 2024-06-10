package ru.job4j.exercise;

import java.util.ArrayList;
import java.util.List;

public class CheckerAhdGetter {
    public static String getElement(List<String> list) {
        return !list.isEmpty() ? list.get(0) : "";
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("first");
        list.add("second");
        list.add("third");
        System.out.println(getElement(list));
        List<String> listEmpty = new ArrayList<>();
        System.out.println(getElement(listEmpty));
    }
}