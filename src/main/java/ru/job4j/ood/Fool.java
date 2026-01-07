package ru.job4j.ood;

import java.util.Scanner;

public class Fool {
    public static void main(String[] args) {
        System.out.println("Игра FizzBuzz.");
        var startAt = 1;
        var input = new Scanner(System.in);
        while (startAt < 100) {
            System.out.println(fizzBuzz(startAt));
            startAt++;
            var answer = input.nextLine();
            if (!fizzBuzz(startAt).equals(answer)) {
                startAt = restartGame();
            }
            startAt++;
        }
    }

    static String fizzBuzz(int startAt) {
        String answer;
        if (startAt % 3 == 0 && startAt % 5 == 0) {
            answer = "FizzBuzz";
        } else if (startAt % 3 == 0) {
            answer = "Fizz";
        } else if (startAt % 5 == 0) {
            answer = "Buzz";
        } else {
            answer = String.valueOf(startAt);
        }
        return answer;
    }

    private static int restartGame() {
        System.out.println("Ошибка. Начинай снова.");
        return 0;
    }
}
