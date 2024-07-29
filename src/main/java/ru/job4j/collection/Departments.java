package ru.job4j.collection;

import java.util.*;

public class Departments {
    public static List<String> fillGaps(List<String> departments) {
        Set<String> temp = new LinkedHashSet<>();
        for (String value : departments) {
            StringBuilder start = new StringBuilder();
            String[] str = value.split("/");
            for (int i = 0; i < str.length; i++) {
                if (i == 0) {
                    start.append(str[i]);
                    temp.add(start.toString());
                } else {
                    temp.add(start + "/" + str[i]);
                    start.append("/").append(str[i]);
                }
            }
        }
        return new ArrayList<>(temp);
    }

    public static void sortAsc(List<String> departments) {
        departments.sort(Comparator.naturalOrder());
    }

    public static void sortDesc(List<String> departments) {
        departments.sort(new DepartmentsDescComparator());
    }
}
