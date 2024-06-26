package ru.job4j.exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PutIfAbsent {
    private final Map<Integer, User> users;

    public PutIfAbsent(Map<Integer, User> users) {
        this.users = users;
    }

    public boolean addNewElement(User u) {
        if (!users.containsKey(u.id)) {
            users.put(u.id, u);
        }
        return users.containsValue(u);
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

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

    public static void main(String[] args) {
        Map<Integer, User> map = new HashMap<>(
                Map.of(
                        1, new User(1, "Name1"),
                        2, new User(2, "Name2")
                )
        );
        PutIfAbsent put = new PutIfAbsent(map);
        User user = new User(1, "Name3");
        boolean rsl = put.addNewElement(user);
        System.out.println(rsl);
    }
}
