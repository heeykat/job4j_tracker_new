package ru.job4j.exercise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pangram {
    public static boolean checkString(String s) {
        String[] text = s.split("");
        Set textSet = new HashSet<>();
        for (String el : text) {
            if (!el.equals(" ")) {
                textSet.add(el);
            }
        }
        return textSet.size() >= 26;
    }
}
