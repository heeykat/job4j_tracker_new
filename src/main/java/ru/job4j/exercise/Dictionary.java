package ru.job4j.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dictionary {
    public static Map<String, List<String>> collectData(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strings) {
            String key = String.valueOf(str.charAt(0));
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return map;
    }

    public static void main(String[] args) {
        String[] data = {"two", "three", "four", "five", "six", "seven"};
        Map<String, List<String>> rsl = Dictionary.collectData(data);
        System.out.println(rsl);
    }
}
