package ru.job4j.exercise;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class MostUsedCharacter {
    public static char getMaxCount(String str) {
        Map<Character, Integer> map = new TreeMap<>();
        for (Character ch : str.toLowerCase().toCharArray()) {
            if (!ch.equals(' ') && !map.containsKey(ch)) {
                map.computeIfAbsent(ch, key -> 1);
            } else if (!ch.equals(' ') && map.containsKey(ch)) {
                map.computeIfPresent(ch, (key, value) -> map.get(ch) + 1);
            }
        }
        Integer maxValue = Collections.max(map.values());
        char rsl = ' ';
        for (Character ch : map.keySet()) {
            if (map.get(ch).equals(maxValue)) {
                rsl = ch;
                break;
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        String str = "Мой дядя самых честных правил "
                + "Когда не в шутку занемог "
                + "Он уважать себя заставил "
                + "И лучше выдумать не мог "
                + "Его пример другим наука "
                + "Но боже мой какая скука "
                + "С больным сидеть и день и ночь "
                + "Не отходя ни шагу прочь "
                + "Какое низкое коварство "
                + "Полуживого забавлять "
                + "Ему подушки поправлять "
                + "Печально подносить лекарство "
                + "Вздыхать и думать про себя "
                + "Когда же черт возьмет тебя";
        System.out.println("ответ " + getMaxCount(str));
    }
}
