package ru.job4j.exercise;

import java.util.*;

public class Isogram {
    public static boolean checkString(String s) {
        String[] arrayS = s.split("");
        Set<String> setS = new HashSet<>(List.of(arrayS));
        return s.length() == setS.size();
    }

    public static void main(String[] args) {
        String s = "uncopyrightables";
        String s1 = "javascript";
        System.out.println(checkString(s));
        System.out.println(checkString(s1));
    }
}
