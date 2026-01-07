package ru.job4j.ood;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FoolTest {

    @Test
    void when1Then1() {
        assertEquals("1", Fool.fizzBuzz(1));
    }

    @Test
    void when3ThenFizz() {
        assertEquals("Fizz", Fool.fizzBuzz(3));
    }

    @Test
    void when5ThenBuzz() {
        assertEquals("Buzz", Fool.fizzBuzz(5));
    }

    @Test
    void when15ThenFizzBuzz() {
        assertEquals("FizzBuzz", Fool.fizzBuzz(15));
    }
}