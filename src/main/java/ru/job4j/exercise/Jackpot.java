package ru.job4j.exercise;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Jackpot {
    public static boolean checkYourWin(String[] combination) {
        Set<String> combinationSet = new HashSet<>(Arrays.asList(combination));
        return combinationSet.size() == 1;
    }

    public static void main(String[] args) {
        String[] strings = {"@", "@", "@", "@"};
        String[] strings1 = {"&&", "&", "&&&", "&&&&"};
        System.out.println(checkYourWin(strings));
        System.out.println(checkYourWin(strings1));
    }
}