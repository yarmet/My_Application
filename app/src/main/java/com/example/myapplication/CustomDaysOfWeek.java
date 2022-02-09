package com.example.myapplication;

import java.util.Arrays;
import java.util.List;

public class CustomDaysOfWeek {
    private static List<String> DAYS = Arrays.asList("Понедельник", "Вторник", "Среда", "Четверг", "Пятница", "Суббота", "Воскресенье");

    public static String get(int i) {
        return DAYS.get(i - 1);
    }
}
