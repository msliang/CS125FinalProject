package com.example.cs125finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    TimePicker alarm;
    AlarmManager alarm_Manager;
    Calendar calendar;
    Context context;
    PendingIntent pendingIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calendar = Calendar.getInstance();
        alarm = findViewById(R.id.timePicker);
        alarm_Manager = (AlarmManager) getSystemService(ALARM_SERVICE);
        this.context = this;
        final TextView status = findViewById(R.id.status);
        //Stop alarm button
        final Button stop = findViewById(R.id.stop);
        //not visible until alarm is started
        stop.setVisibility(View.GONE);
        //set alarm button
        final Button set = findViewById(R.id.set);
        //visible at first gone after alarm is started
        set.setVisibility(View.VISIBLE);
        final Intent intent = new Intent(context, AlarmReceiver.class);
        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                final Intent intent = new Intent(context, AlarmReceiver.class);
                calendar.set(Calendar.HOUR_OF_DAY, alarm.getCurrentHour());
                calendar.set(Calendar.MINUTE, alarm.getCurrentMinute());
                //returns alarm as a string
                status.setText("Alarm Set For " + AlarmToTime());
                intent.putExtra("extra", "on");
                //delays the intent for AlarmReceiver
                pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                // delays until alarm time
                alarm_Manager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis() , pendingIntent);
                set.setVisibility(View.GONE);
                stop.setVisibility(View.VISIBLE);
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                status.setText("No Alarm Set");
                alarm_Manager.cancel(pendingIntent);
                intent.putExtra("extra", "off");
                sendBroadcast(intent);
                stop.setVisibility(View.GONE);
                set.setVisibility(View.VISIBLE);
            }

        });

    }
    public String AlarmToTime() {
        Integer alarmHours = alarm.getCurrentHour();
        Integer alarmMin = alarm.getCurrentMinute();
        String alarmHrString;
        String alarmMinString;
        String AMorPM;
        if (alarmHours > 12) {
            alarmHours -= 12;
            alarmHrString = alarmHours.toString().concat(":");
            AMorPM = "PM";
        } else {
            alarmHrString = alarmHours.toString().concat(":");
            AMorPM = "AM";
        }
        if (alarmMin < 10) {
            alarmMinString = "0" +  alarmMin.toString();
        } else {
            alarmMinString = alarmMin.toString();
        }


        return alarmHrString + alarmMinString + " " + AMorPM;

    }

}
