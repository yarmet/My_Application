package com.example.myapplication;

import java.util.Arrays;
import java.util.List;

public class Schedule {

  public static List<Day> DAYS;

    static {
        Day day1 = new Day(DayType.ON, Exercise.EXERCISE1, Exercise.EXERCISE2, Exercise.EXERCISE3, Exercise.EXERCISE4, Exercise.EXERCISE15);
        Day day2 = new Day(DayType.ON, Exercise.EXERCISE5, Exercise.EXERCISE6, Exercise.EXERCISE7, Exercise.EXERCISE8, Exercise.EXERCISE16);
        Day day3 = new Day(DayType.ON, Exercise.EXERCISE9, Exercise.EXERCISE10, Exercise.EXERCISE11, Exercise.EXERCISE17, Exercise.EXERCISE14);
        Day day4 = new Day(DayType.OFF);
        Day day5 = new Day(DayType.OFF);
        Day day6 = new Day(DayType.ON, Exercise.EXERCISE12, Exercise.EXERCISE2, Exercise.EXERCISE3, Exercise.EXERCISE4, Exercise.EXERCISE15);
        Day day7 = new Day(DayType.ON, Exercise.EXERCISE5, Exercise.EXERCISE6, Exercise.EXERCISE7, Exercise.EXERCISE8, Exercise.EXERCISE16);
        Day day8 = new Day(DayType.ON, Exercise.EXERCISE13, Exercise.EXERCISE10, Exercise.EXERCISE11, Exercise.EXERCISE17, Exercise.EXERCISE14);
        Day day9 = new Day(DayType.OFF);
        Day day10 = new Day(DayType.OFF);

        DAYS = Arrays.asList(day1, day2, day3, day4, day5, day6, day7, day8, day9, day10);
    }




}
