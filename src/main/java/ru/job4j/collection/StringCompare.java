package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int minSize = Math.min(left.length(), right.length());
        for (int i = 0; i < minSize; i++) {
            char l = left.charAt(i);
            char r = right.charAt(i);
           if (l != r) {
               return Character.compare(l, r);
           }
        }
        return left.length() - right.length();
    }
}