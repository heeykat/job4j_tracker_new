package ru.job4j.exercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class ThenComparingMethod {

    public static class User implements Comparable<User> {

        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
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
            return age == user.age && Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }

        @Override
        public String toString() {
            return "User{"
                    + "name='" + name + '\''
                    + ", age=" + age
                    +
                    '}';
        }

        @Override
        public int compareTo(User o) {
            return ThenComparingMethod.thenComparing().compare(this, o);
        }
    }

    public static Comparator<User> thenComparing() {
        return ascByName().thenComparing(descByAge());
    }

    public static Comparator<User> ascByName() {
        return new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return String.CASE_INSENSITIVE_ORDER.compare(o1.name, o2.name);
            }
        };
    }

    public static Comparator<User> descByAge() {
        return new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o2.age, o1.age);
            }
        };
    }

    public static void main(String[] args) {
        User u = new User("name", 1);
        User u1 = new User("name", 2);
        List<User> l = new ArrayList<>();
        l.add(u);
        l.add(u1);
        l.sort(thenComparing());
        System.out.println(l);
    }
}
