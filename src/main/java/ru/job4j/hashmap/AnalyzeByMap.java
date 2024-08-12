package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double sum = 0;
        int count = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
                count++;
            }
        }
        return count != 0 ? sum / count : 0;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double sum = 0;
            List<Subject> subjects = pupil.subjects();
            for (Subject subject : subjects) {
                sum += subject.score();
            }
            if (!subjects.isEmpty()) {
                list.add(new Label(pupil.name(), sum / subjects.size()));
            }
        }
        return list;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        int numberPupils = pupils.size();
        List<Label> list = new ArrayList<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.merge(subject.name(), subject.score(), Integer::sum);
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            list.add(new Label(entry.getKey(), (double) entry.getValue() / numberPupils));
        }
        return list;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double sum = 0;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
            }
            list.add(new Label(pupil.name(), sum));
        }
        list.sort(Comparator.naturalOrder());
        return list.get(list.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.merge(subject.name(), subject.score(), Integer::sum);
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            list.add(new Label(entry.getKey(), (double) entry.getValue()));
        }
        list.sort(Comparator.naturalOrder());
        return list.get(list.size() - 1);
    }
}