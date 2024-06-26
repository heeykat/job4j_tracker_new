package ru.job4j.exercise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class RemoveElements {
    public static Map<Integer, String> removeElement(Map<Integer, String> data,
                                                     List<Integer> ids,
                                                     List<User> users) {
        for (Integer key : ids) {
            data.remove(key);
        }
        for (User user: users) {
            data.remove(user.getId());
        }
        return data;
    }

    public static class User {
        private int id;
        private String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return id == user.id && Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }

    public static void main(String[] args) {
        Map<Integer, String> data = new HashMap<>(
                Map.of(
                        1, "name1",
                        2, "name2",
                        3, "name3",
                        4, "name4",
                        5, "name5",
                        6, "name6",
                        7, "name7",
                        8, "name8",
                        9, "name9",
                        10, "name10"
                )
        );
        List<Integer> ids = List.of(1, 5, 8);
        List<User> users = List.of(
                new User(3, "name3"),
                new User(7, "name7"),
                new User(10, "name10")
        );
        Map<Integer, String> rsl = RemoveElements.removeElement(data, ids, users);
        System.out.println(rsl);
    }
}
