package ru.job4j;

public class Calculator1 {
    public static class Multiple {

        private final int result;

        public Multiple(int number) {
            result = number;
        }

        public int getResult() {
            return result;
        }
    }

    public static Multiple getMultiple(int value) {
        int result = value * value;
        return new Multiple(result);
    }

    public static void main(String[] args) {
        Calculator1.Multiple multiple = Calculator1.getMultiple(3);
        System.out.println("Квадрат числа равен " + multiple.getResult());
        Calculator1.Multiple multiple1 = new Multiple(2);
        Calculator1.Multiple multiple2 = new Multiple(2);
    }
}
