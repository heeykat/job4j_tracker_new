package ru.job4j.exercise;

import java.util.ArrayList;
import java.util.List;

public class AddElement {
    public static boolean addNewElement(List<String> list, String str) {
/*        return list.add(str); */
        List<String> list1 = new ArrayList<>();
        list1.addAll(list);
        list1.add(str);
        return list1.size() > list.size();
    }
}