package ru.job4j.gc.ref;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/**
 *
 * Основной принцип безопасного использования:
 * 1. Перед обращением к данным нужно проверить, что ссылка ещё жива (ref.get() != null).
 * 2. Если GC удалил объект, нужно пересоздать или заново загрузить данные.
 * 3. Не держать сильных ссылок на тот же объект, иначе GC не сможет его удалить.
 */

public class ReferenceExample {

    private SoftReference<String> softCache;

    private WeakReference<String> weakTemp;

    public void example() {
        String data = "Данные, которые можно пересоздать";
        softCache = new SoftReference<>(data);
        data = null;
        String cached = softCache.get();
        if (cached == null) {
            cached = "Пересозданные данные";
            softCache = new SoftReference<>(cached);
            System.out.println("SoftReference: данные пересозданы");
        } else {
            System.out.println("SoftReference: данные ещё в памяти");
        }

        weakTemp = new WeakReference<>("Временные данные");
        String temp = weakTemp.get();
        if (temp != null) {
            System.out.println("WeakReference: данные доступны");
        } else {
            System.out.println("WeakReference: данные уже собраны GC");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReferenceExample example = new ReferenceExample();
        example.example();

        System.gc();
        TimeUnit.SECONDS.sleep(1);
        example.example();
    }
}
