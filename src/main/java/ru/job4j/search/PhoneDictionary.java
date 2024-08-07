package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список пользователей, которые прошли проверку.
     */
    public ArrayList<Person> find(String key) {
        Predicate<Person> checkName = (person) -> person.getName().contains(key);
        Predicate<Person> checkSurname = (person) -> person.getSurname().contains(key);
        Predicate<Person> checkPhone = (person) -> person.getPhone().contains(key);
        Predicate<Person> checkAddress = (person) -> person.getPhone().contains(key);
        Predicate<Person> combine = (person) -> checkName.or(checkSurname).or(checkPhone).or(checkAddress).test(person);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
