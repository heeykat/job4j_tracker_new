package ru.job4j;

public class Test2  {

    private String name;

    private String hello;

    public Test2(String name) {
        this.name = name;
    }

    public String getHello() {
        return hello;
    }

    public void method(int... nums) {

    }

    public void method(String str, int... nums) {

    }

    public void method(String... strings) {

    }

    public static void main(String[] args) {
        System.out.println((new Test2("name").getHello() == null));
        System.out.printf("Имя: %d, возраст: %s", 22, "Иван");
        System.out.printf("Имя: %2$s, возраст: %s", 22, "Иван");
    }
}
