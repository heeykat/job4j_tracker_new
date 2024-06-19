package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("ivan@mail.ru", "Ivanov Ivan Ivanovich");
        map.put("ivan_ivan@mail.ru", "Ivanov Ivan");
        map.put("123@gmail.com", "Petrov Petr");
        map.put("345@gmail.com", "Petrov Ivan");
        map.put("123@gmail.com", "Ivanov Petr");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
