package ru.job4j.polymorphism;

public class Main {
    public static void main(String[] args) {
        Vehicle townCar = new TownCar();
        townCar.changeGear();
        townCar.accelerate();
        townCar.steer();
        townCar.brake();
        SportCar sportCar = new SportCar();
        Vehicle vehicle = sportCar;
        Fuel fuel = sportCar;
        vehicle.changeGear();
        vehicle.accelerate();
        vehicle.steer();
        vehicle.brake();
        fuel.refill();
    }
}
