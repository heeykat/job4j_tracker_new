package ru.job4j.collection;

import java.util.ArrayList;

public class UsageArrayList {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("apple");
        arrayList.add("pear");
        arrayList.add("banana");
        for (String el: arrayList) {
            System.out.println(el);
        }
    }
}
