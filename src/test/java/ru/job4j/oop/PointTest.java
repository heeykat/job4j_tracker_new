package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    @Test
    public void when00to20then2() {
        int expected = 2;
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        double out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when10to30then2() {
        int expected = 2;
        Point a = new Point(1, 0);
        Point b = new Point(3, 0);
        double out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when06to09then3() {
        int expected = 3;
        Point a = new Point(0, 6);
        Point b = new Point(0, 9);
        double out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when067to095then3() {
        int expected = 3;
        Point a = new Point(0, 6, 7);
        Point b = new Point(0, 9, 5);
        double out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when40to70then3() {
        int expected = 3;
        int x1 = 4;
        int y1 = 0;
        int x2 = 7;
        int y2 = 0;
        Point a = new Point(4, 0);
        Point b = new Point(7, 0);
        double out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);
    }
}