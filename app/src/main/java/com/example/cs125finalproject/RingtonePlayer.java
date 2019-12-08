package com.example.cs125finalproject;

import android.app.Service;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class RingtonePlayer extends Service {
    final Ringtone ring = RingtoneManager.getRingtone(getApplicationContext(), RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE));
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}
