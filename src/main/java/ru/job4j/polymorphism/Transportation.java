package ru.job4j.polymorphism;

public class Transportation {

    public static void main(String[] args) {
        Transport bus = new Bus();
        Transport plane = new Plane();
        Transport train = new Train();
        Transport[] transport = {bus, plane, train};
        for (Transport type: transport) {
            type.move();
        }
    }
}
