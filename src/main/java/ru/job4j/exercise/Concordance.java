package ru.job4j.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Concordance {
    public static Map<Character, List<Integer>> collectCharacters(String s) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character key = s.charAt(i);
            if (key != ' ') {
                if (!map.containsKey(key)) {
                    map.put(key, new ArrayList<Integer>());
                }
                map.get(key).add(i);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        String str = "Hello World";
        System.out.println(collectCharacters(str));
    }
}
