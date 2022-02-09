package com.example.myapplication;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Day {

    private String[] exercises;
    private boolean workingDay;


    public Day(boolean workingDay, String... exercises2) {
        this.workingDay = workingDay;
        this.exercises = exercises2;
    }


    public String getExercisesAsText(boolean today) {
        return today ? makeTodaySchedule() : makeSchedule();
    }


    private String makeTodaySchedule() {
        return workingDay ? Arrays.stream(exercises).map(" -> "::concat).collect(Collectors.joining("\n")) : " -> ОТДЫХ";
    }


    private String makeSchedule() {
        return workingDay ? String.join("\n", exercises) : "ОТДЫХ";
    }


}
