package ru.job4j.exercise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PutContainsKey {
    public static Map<Integer, User> addNewElementWithoutCheck(List<User> list) {
        Map<Integer, User> rsl = new HashMap<>();
        for (User user: list) {
            rsl.put(user.id, user);
        }
        return rsl;
    }

    public static Map<Integer, User> addNewElementWithCheck(List<User> list) {
        Map<Integer, User> rsl = new HashMap<>();
        for (User user: list) {
            if (!rsl.containsKey(user.id)) {
                rsl.put(user.id, user);
            }
        }
        return rsl;
    }

    public record User(int id, String name) {
    }

    public static void main(String[] args) {
        User one = new User(1, "Name1");
        User two = new User(2, "Name2");
        User three = new User(1, "Name3");
        List<User> list = List.of(one, two, three);
        Map<Integer, User> map = PutContainsKey.addNewElementWithCheck(list);
        System.out.println(map);
    }
}
