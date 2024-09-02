package ru.job4j.map;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class College {

    private final Map<Student, Set<Subject>> students;

    public College(Map<Student, Set<Subject>> students) {
        this.students = students;
    }

    public Optional<Student> findByAccount(String account) {
        return Optional.of(students.keySet()
                        .stream()
                        .filter(student -> student.account().equals(account))
                        .findFirst())
                .orElse(Optional.empty());
    }

    public Optional<Subject> findBySubjectName(String account, String name) {
        return findByAccount(account)
                .map(students::get)
                .stream()
                .flatMap(Collection::stream)
                .filter(subject -> subject.name().equals(name))
                .findFirst();
    }
}
