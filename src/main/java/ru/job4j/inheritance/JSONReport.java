package ru.job4j.inheritance;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSONReport extends TextReport {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public String generate(String name, String body) {
        return "{\n"
                + "\t\"name\" : \"" + name + "\","
                + "\n\t\"body\" : \"" + body + "\""
                + "\n}";
    }
}
