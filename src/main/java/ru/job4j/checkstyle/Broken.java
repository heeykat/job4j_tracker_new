package ru.job4j.checkstyle;

public class Broken {
    private static final String NEW_VALUE = "";
    private int sizeOfEmpty = 10;
    private String surname;

    public Broken() {
    }

    public void echo() {
    }

    public void media(Object obj) {
        String name;
        if (obj != null) {
            System.out.println(obj);
        }
    }

    public void method(int a, int b, int c, int d, int e, int f, int g) {
    }
}