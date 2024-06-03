package ru.job4j.pojo;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Iaroslav Lymar Pupsichek");
        student.setGroup("sweetest pupsiks");
        student.setDate(new GregorianCalendar(2015, Calendar.SEPTEMBER, 22));
        System.out.println("student: " + student.getName() + "\n"
                            + "group: " + student.getGroup() + "\n"
                            + "date: " + student.getDate().getTime());
    }
}
