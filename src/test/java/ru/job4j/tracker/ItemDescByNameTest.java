package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ItemDescByNameTest {
    @Test
    public void whenSortDescByName() {
        List<Item> listActual = new ArrayList<>() {{
            add(new Item(1, "Abc"));
            add(new Item(2, "Cbc"));
            add(new Item(3, "Bbc"));
        }};
        List<Item> listExpected = new ArrayList<>() {{
            add(new Item(2, "Cbc"));
            add(new Item(3, "Bbc"));
            add(new Item(1, "Abc"));
        }};
        Collections.sort(listActual, new ItemDescByName());
        assertEquals(listActual, listExpected);
    }
}