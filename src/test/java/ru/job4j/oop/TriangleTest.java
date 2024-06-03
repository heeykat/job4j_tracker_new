package ru.job4j.oop;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class TriangleTest {
    @Test
    public void when00and40and04Then8() {
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        Point c = new Point(0, 4);
        Triangle triangle = new Triangle(a, b, c);
        double result = triangle.area();
        double expected = 8;
        assertThat(result).isCloseTo(expected, offset(0.001));
    }

    @Test
    public void when01and50and05Then10() {
        Point a = new Point(0, 1);
        Point b = new Point(5, 0);
        Point c = new Point(0, 5);
        Triangle triangle = new Triangle(a, b, c);
        double result = triangle.area();
        double expected = 10;
        assertThat(result).isCloseTo(expected, offset(0.001));
    }

    @Test
    public void when01and60and15Then12() {
        Point a = new Point(0, 1);
        Point b = new Point(6, 1);
        Point c = new Point(1, 5);
        Triangle triangle = new Triangle(a, b, c);
        double result = triangle.area();
        double expected = 12;
        assertThat(result).isCloseTo(expected, offset(0.001));
    }
}