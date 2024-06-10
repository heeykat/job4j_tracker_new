package ru.job4j.exercise;

import java.util.ArrayList;

public class GeomProgression {
    public static int generateAndSum(int first, int denominator, int count) {
        ArrayList<Integer> data = new ArrayList<>();
        int rsl = 0;
        while (data.size() < count) {
            data.add((int) (first * Math.pow(denominator, data.size())));
        }
        System.out.println(data);
        for (int el : data) {
            rsl += el;
        }
        return rsl;
    }

    public static void main(String[] args) {
        generateAndSum(1, 3, 10);
    }
}
