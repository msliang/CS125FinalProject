package com.example.cs125finalproject;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.media.ToneGenerator;
import android.net.Uri;
import android.util.Log;

public class AlarmReceiver extends BroadcastReceiver {
    MediaPlayer media;
    @Override
    public void onReceive(Context context, Intent intent) {
        //Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        //Ringtone ring = RingtoneManager.getRingtone(intent.get, notification);
        //ToneGenerator tone = new ToneGenerator(AudioManager.STREAM_MUSIC, 100);
        //tone.startTone(ToneGenerator.TONE_CDMA_PIP, 200);
        media = MediaPlayer.create(context, R.raw.alarm);
        media.start();
        //final Ringtone ring = RingtoneManager.getDefaultUri()
        Log.e("In receiver", "yay");
    }
}
