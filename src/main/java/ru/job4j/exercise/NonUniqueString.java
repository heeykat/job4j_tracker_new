package ru.job4j.exercise;

import java.util.HashMap;
import java.util.Map;

public class NonUniqueString {
    public static Map<String, Boolean> checkData(String[] strings) {
        Map<String, Boolean> map = new HashMap<>();
        for (String st : strings) {
//            map.compute(st, (key, value) -> value != null);
            map.merge(st, false, (el1, el2) -> true);
        }
        return map;
    }

    public static void main(String[] args) {
        String[] data = {"a", "b", "a", "c", "b"};
        Map<String, Boolean> rsl = NonUniqueString.checkData(data);
        System.out.println(rsl);
    }
}
