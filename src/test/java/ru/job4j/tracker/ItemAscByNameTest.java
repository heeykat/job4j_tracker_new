package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemAscByNameTest {
    @Test
    public void whenSortAscByName() {
        List<Item> listActual = new ArrayList<>() {{
            add(new Item(1, "Abc"));
            add(new Item(2, "Cbc"));
            add(new Item(3, "Bbc"));
        }};
        List<Item> listExpected = new ArrayList<>() {{
            add(new Item(1, "Abc"));
            add(new Item(3, "Bbc"));
            add(new Item(2, "Cbc"));
        }};
        Collections.sort(listActual, new ItemAscByName());
        for (int i = 0; i < listActual.size(); i++) {
            assertEquals(listExpected.get(i).getName(), listActual.get(i).getName());
        }
    }
}