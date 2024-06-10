package ru.job4j.exercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Alphabet {
    public static String reformat(String s) {
        List<String> strings = Arrays.asList(s.split(""));
        Comparator<String> comparator = (o1, o2) -> {
            char c1 = o1.charAt(0);
            char c2 = o2.charAt(0);
            return Character.compare(c1, c2);
        };
        strings.sort(comparator);
        StringBuilder srst = new StringBuilder();
        for (String string : strings) {
            srst.append(string);
        }
        return srst.toString();
    }
}
