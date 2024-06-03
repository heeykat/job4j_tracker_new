package ru.job4j.oop;

public class Triangle {
    private Point first;
    private Point second;
    private Point third;

    public Triangle(Point ap, Point bp, Point cp) {
        this.first = ap;
        this.second = bp;
        this.third = cp;
    }

    public double semiPerimeter(double a, double b, double c) {
        return (a + b + c) / 2;
    }

    public boolean exist(double ab, double ac, double bc) {
        return ((ab + bc > ac) && (ab + ac > bc) && (ac + bc > ab));
    }

    public double area() {
        double result = -1;
        double ab = first.distance(second);
        double ac = first.distance(third);
        double bc = second.distance(third);
        if (this.exist(ab, ac, bc)) {
            double p = semiPerimeter(ab, ac, bc);
            result = Math.sqrt(p * (p - ab) * (p - ac) * (p - bc));
        }
        return result;
    }

    public static void main(String[] args) {
        Point a = new Point(0, 1);
        Point b = new Point(6, 1);
        Point c = new Point(1, 5);
        Triangle triangle = new Triangle(a, b, c);
        double result = triangle.area();
        System.out.println(result);
    }
}