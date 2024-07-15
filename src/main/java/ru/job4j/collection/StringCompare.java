package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int minSize = Math.min(left.length(), right.length());
        for (int i = 0; i < minSize; i++) {
           if (left.charAt(i) != right.charAt(i)) {
               return Character.compare(left.charAt(i), right.charAt(i));
           }
        }
        return Integer.compare(left.length(), right.length());
    }
}