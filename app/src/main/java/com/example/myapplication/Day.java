package com.example.myapplication;

public class Day {
    private String[] exercises;
    private DayType type;

    public Day(DayType type2, String... exercises2) {
        this.type = type2;
        this.exercises = exercises2;
    }

    public DayType getType() {
        return this.type;
    }

    public String[] getExercises() {
        return this.exercises;
    }

}
