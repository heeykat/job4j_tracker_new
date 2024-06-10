package ru.job4j.exercise;

import java.util.ArrayList;
import java.util.List;

public class AddIndexElement {
    @SuppressWarnings("checkstyle:NeedBraces")
    public static boolean addNewElement(List<String> list, int index, String str) {
        boolean rst = false;
        if (!list.isEmpty() && !list.contains(str)) {
            list.add(index, str);
            rst = true;
        }
        return rst;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("first");
        list.add("second");
        list.add("third");
    }
}
