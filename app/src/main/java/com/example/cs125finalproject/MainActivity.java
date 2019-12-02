package com.example.cs125finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextClock;
import android.widget.TimePicker;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    TimePicker alarm;
    TextClock currentTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alarm = findViewById(R.id.timePicker);
        currentTime = findViewById(R.id.textClock);
        Timer time = new Timer();
        time.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (currentTime.getText().toString().equals(AlarmToTime())) {
                    //WEB API FOR SPOTIFY
                    //CURRENT RINGTONE WILL PLAY
                }
            }
        }, 0, 1000);
    }
    public String AlarmToTime() {
        Integer alarmHours = alarm.getCurrentHour();
        Integer alarmMin = alarm.getCurrentMinute();
        String alarmAsString;
        if (alarmHours > 12) {
            alarmHours -= 12;
            alarmAsString = alarmHours.toString().concat(":").concat(alarmMin.toString()).concat(" PM");
        } else {
            alarmAsString = alarmHours.toString().concat(":").concat(alarmMin.toString()).concat(" AM");
        }
        return alarmAsString;

    }
}
