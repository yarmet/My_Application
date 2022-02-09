package com.example.myapplication;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        List<String> strings = this.fillDays();

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
            int position = this.getDayInSchedulePosition(((int) offset) + i);
            Day currDay = Schedule.DAYS.get(position);

            String dayName = this.getDayName(i);
            LocalDate localDate = now.plusDays(i);

            String header = new StringBuilder()
                    .append(dayName)
                    .append(localDate)
                    .append(" ")
                    .append(DayOfWeekRussianNames.get(localDate.getDayOfWeek().getValue()))
                    .toString();

            String s = this.convertDayToPrintDay(header, currDay, i == 0);
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
        return new StringBuilder()
                .append(name)
                .append("\n")
                .append(day.getExercisesAsText(today))
                .toString();
    }


    private int getDayInSchedulePosition(int val) {
        if (val > 0) {
            return val % 10;
        }
        if (val < 0) {
            return 10 - ((-val) % 10);
        }
        return val;
    }


}
