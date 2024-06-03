package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        Book red = new Book("1984", 523);
        Book blue = new Book("Clean code", 123);
        Book green = new Book("Harry Potter", 670);
        Book black = new Book("Dune", 790);
        books[0] = red;
        books[1] = blue;
        books[2] = green;
        books[3] = black;
        for (Book book: books) {
            System.out.println(book.getName() + " " + book.getPages());
        }
        Book temp = new Book("", 0);
        temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (Book book: books) {
            System.out.println(book.getName() + " " + book.getPages());
        }
        for (Book book: books) {
            if (book.getName().equals("Clean code")) {
                System.out.println(book.getName() + " " + book.getPages());
            }
        }
    }
}
