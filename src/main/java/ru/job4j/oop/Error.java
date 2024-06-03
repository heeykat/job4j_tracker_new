package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {

    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Status: " + status);
        System.out.println("Is active: " + active);
        System.out.println("Message: " + message);
    }

    public static void main(String[] args) {
        Error error = new Error();
        Error error404 = new Error(false, 404, "Not Found");
        Error error500 = new Error(true, 500, "Internal Server Error");
        error404.printInfo();
        error500.printInfo();
    }
}
