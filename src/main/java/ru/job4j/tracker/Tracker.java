package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>(100);
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(size++, item);
        return item;
    }

    public List<Item> findAll() {
        return new ArrayList<>(items.subList(0, size));
    }

    public List<Item> findByName(String key) {
        List<Item> itemsByName = new ArrayList<>(size);
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (items.get(i).getName().equals(key)) {
                itemsByName.add(index++, items.get(i));
            }
        }
        return new ArrayList<>(itemsByName.subList(0, index));
    }

    private int indexOf(int id) {
        int result = -1;
        for (int index = 0; index < size; index++) {
            if (items.get(index).getId() == id) {
                result = index;
                break;
            }
        }
        return result;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public boolean replace(int id, Item item) {
        boolean rst = false;
        int index = indexOf(id);
        boolean result = index != -1;
        if (result) {
            item.setId(id);
            items.set(index, item);
            rst = true;
        }
        return rst;
    }

    public void delete(int id) {
        int index = indexOf(id);
        boolean result = index != -1;
        if (result) {
            int start = index + 1;
            int length = size - index - 1;
            items.subList(start, start + length);
            items.set(size - 1, null);
            size--;
        }
    }
}