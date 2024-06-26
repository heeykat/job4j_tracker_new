package ru.job4j.exercise;

import java.util.Map;
import java.util.Objects;

public class Farm {
    public static int sumLegs(Map<Animal, Integer> data) {
        int sum = 0;
        for (Map.Entry<Animal, Integer> entry : data.entrySet()) {
            sum += entry.getKey().getLegs() * entry.getValue();
        }
        return sum;
    }

    public static class Animal {
        private String name;

        private int legs;

        public Animal(String name, int legs) {
            this.name = name;
            this.legs = legs;
        }

        public String getName() {
            return name;
        }

        public int getLegs() {
            return legs;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Animal animal = (Animal) o;
            return Objects.equals(name, animal.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

    public static void main(String[] args) {
        Map<Animal, Integer> data = Map.of(
                new Animal("chicken", 2), 5,
                new Animal("cow", 4), 2,
                new Animal("pig", 4), 8
        );
        int rsl = Farm.sumLegs(data);
        System.out.println(rsl);
    }
}
