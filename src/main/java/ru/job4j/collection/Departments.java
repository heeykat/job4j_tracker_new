package ru.job4j.collection;

import java.util.*;

public class Departments {
    public static List<String> fillGaps(List<String> departments) {
        Set<String> temp = new LinkedHashSet<>();
        for (String value : departments) {
            StringBuilder start = new StringBuilder();
            String[] str = value.split("/");
            for (String element : str) {
                start.append(start.isEmpty() ? element : "/" + element);
                temp.add(start.isEmpty() ? element : start.toString());
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
