package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class MatrixToListTest {
    @Test
    public void whenInputSquareMatrix() {
        Integer[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        List<Integer> result = MatrixToList.convert(matrix);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        assertThat(result).containsAll(expected);
    }

    @Test
    public void whenInputNoSquareMatrix() {
        Integer[][] matrix = {
                {1},
                {2, 3},
                {4, 5, 6}
        };
        List<Integer> result = MatrixToList.convert(matrix);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(result).containsAll(expected);
    }
}