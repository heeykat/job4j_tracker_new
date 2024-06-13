package ru.job4j.exercise;

import java.util.Arrays;
import java.util.Set;

public class Firewall {
    public static String checkName(String s, Set<String> words) {
        String[] article = s.split(" ");
        String answer = "Вы сделали правильный выбор!";
        for (String el : article) {
            if (words.contains(el)) {
                answer = "Выберите другую статью...";
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Set<String> words = Set.of("instagram", "фото", "мем", "котик");
        String s = "Создание многомодульного Gradle проекта SpringBoot + Angular в IDEA";
        System.out.println(checkName(s, words));
        Set<String> words1 = Set.of("instagram", "фото", "мем", "котик");
        String s1 = "Криштиану Роналду опубликовал новую фотографию с детьми в instagram";
        System.out.println(checkName(s1, words1));
    }
}
