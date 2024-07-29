package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] leftParts = left.split("/");
        String[] rightParts = right.split("/");
        int result = rightParts[0].compareTo(leftParts[0]);
        if (result != 0) {
            return result;
        }
        int length = Math.min(leftParts.length, rightParts.length);
        for (int i = 1; i < length; i++) {
            result = leftParts[i].compareTo(rightParts[i]);
                if (result != 0) {
                    return result;
                }
            }
        return Integer.compare(leftParts.length, rightParts.length);
    }
}