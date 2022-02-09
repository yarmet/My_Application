package com.example.myapplication;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        List<String> strings = fillDays();

        ListView listView = findViewById(R.id.listParent);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, strings);
        listView.setAdapter(adapter);
    }


    private List<String> fillDays() {
        LocalDate prev = LocalDate.of(2020, 1, 1);
        LocalDate now = LocalDate.now();
        long offset = ChronoUnit.DAYS.between(prev, now) % ((long) Schedule.DAYS.size());

        List<String> result = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            int position = this.getPosition(((int) offset) + i);
            Day currDay = Schedule.DAYS.get(position);

            String dayName = this.getDayName(i);
            LocalDate localDate = now.plusDays(i);

            StringBuilder header = new StringBuilder()
                    .append(dayName)
                    .append(localDate)
                    .append(" ")
                    .append(CustomDaysOfWeek.get(localDate.getDayOfWeek().getValue()));

            String s = convertDayToPrintDay(header.toString(), currDay, i == 0);
            result.add(s);
        }
        return result;
    }


    private String getDayName(int i) {
        switch (i) {
            case -2:
                return "ПОЗАВЧЕРА ";
            case -1:
                return "ВЧЕРА ";
            case 0:
                return "СЕГОДНЯ ";
            case 1:
                return "ЗАВТРА ";
            case 2:
                return "ПОСЛЕЗАВТРА ";
            default:
                return "";
        }
    }

    private String convertDayToPrintDay(String name, Day day, boolean today) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name);
        stringBuilder.append("\n");

        if (today) {
            if (day.getType() == DayType.ON) {
                String collect = Arrays.stream(day.getExercises()).map(" -> "::concat).collect(Collectors.joining("\n"));
                stringBuilder.append(collect);
            } else {
                stringBuilder.append(" -> ОТДЫХ");
            }
        } else {
            if (day.getType() == DayType.ON) {
                stringBuilder.append(String.join("\n", day.getExercises()));
            } else {
                stringBuilder.append("ОТДЫХ");
            }
        }
        return stringBuilder.toString();
    }


    private int getPosition(int val) {
        if (val > 0) {
            return val % 10;
        }
        if (val < 0) {
            return 10 - ((-val) % 10);
        }
        return val;
    }


}
