package ru.job4j.queue;

import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;

    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        Customer c = null;
        for (int i = 0; i < count; i++) {
            c = queue.poll();
        }
        return c.name();
    }

    public String getFirstUpsetCustomer() {
        Customer c = null;
        for (int i = 0; i < count + 1; i++) {
            c = queue.poll();
        }
        return c.name();
    }
}

