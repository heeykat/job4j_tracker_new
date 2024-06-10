package ru.job4j.exercise;

import java.util.List;

public class ArProgression {
    public static int checkData(List<Integer> data) {
        int sum = data.get(0) + data.get(data.size() - 1);
        for (int i = 1; i < data.size() - 1; i++) {
            if (data.get(i) == ((data.get(i - 1) + data.get(i + 1)) / 2)) {
                sum += data.get(i);
            } else {
                return 0;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        List<Integer> data = List.of(
                1, 6, 11, 15, 21,
                26, 31, 36, 41, 46
        );
        System.out.println(checkData(data));
    }
}
