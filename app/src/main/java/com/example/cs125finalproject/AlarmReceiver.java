package com.example.cs125finalproject;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.util.Log;

public class AlarmReceiver extends BroadcastReceiver {
    MediaPlayer media;
    @Override
    public void onReceive(Context context, Intent intent) {
        media = MediaPlayer.create(getApplicationContext(), R.raw.alarm);
        final Ringtone ring = RingtoneManager.getDefaultUri()
        Log.e("In receiver", "yay");
    }
}
