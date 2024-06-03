package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int b) {
        return b - x;
    }

    public int divide(int c) {
        return c / x;
    }

    public int sumAllOperation(int d) {
        return sum(d) + multiply(d) + minus(d) + divide(d);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int a = 10;
        int resultSum = sum(a);
        int resultMultiply = calculator.multiply(a);
        int resultMinus = minus(a);
        int resultDivide = calculator.divide(a);
        int resultSumAllOperations = calculator.sumAllOperation(a);
        System.out.println("sum: " + resultSum
                + "\nmultiply: " + resultMultiply
                + "\nminus: " + resultMinus
                + "\ndivide: " + resultDivide
                + "\nsumAll: " + resultSumAllOperations);
    }
}
