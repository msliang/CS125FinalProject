package com.example.cs125finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Ringtone;
import android.media.RingtoneManager;
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
        final Ringtone ring = RingtoneManager.getRingtone(getApplicationContext(), RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE));
        Timer time = new Timer();
        time.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (currentTime.getText().toString().equals(AlarmToTime())) {
                    ring.play();
                    //WEB API FOR SPOTIFY
                    //CURRENT RINGTONE WILL PLAY
                } else {
                    ring.stop();
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
