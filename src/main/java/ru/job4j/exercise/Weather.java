package ru.job4j.exercise;

import java.util.*;

public class Weather {
    public static List<Info> editData(List<Info> list) {
        List<Info> rsl = new ArrayList<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Info el : list) {
            String k = el.getCity();
            map.compute(k, (key, value) -> (value == null) ? el.getRainfall() : value + el.getRainfall());
        }
        for (String key : map.keySet()) {
            rsl.add(new Info(key, map.get(key)));
        }
        return rsl;
    }

    public static class Info {
        private String city;

        private int rainfall;

        public Info(String city, int rainfall) {
            this.city = city;
            this.rainfall = rainfall;
        }

        public String getCity() {
            return city;
        }

        public int getRainfall() {
            return rainfall;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Info info = (Info) o;
            return rainfall == info.rainfall && Objects.equals(city, info.city);
        }

        @Override
        public int hashCode() {
            return Objects.hash(city, rainfall);
        }

        @Override
        public String toString() {
            return "Info{"
                    + "city='" + city + '\''
                    + ", rainfall=" + rainfall
                    +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<Info> list = List.of(
                new Info("Minsk", 25), new Info("Brest", 5), new Info("Grodna", 33),
                new Info("Gomel", 26), new Info("Minsk", 15), new Info("Vitebsk", 18),
                new Info("Grodna", 18), new Info("Brest", 18), new Info("Gomel", 40),
                new Info("Minsk", 55), new Info("Vitebsk", 36), new Info("Minsk", 30),
                new Info("Gomel", 15), new Info("Grodna", 15), new Info("Brest", 40)
        );
        System.out.println(editData(list).toString());
    }
}
