package com.example.ourgroceries;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;

import androidx.annotation.Nullable;
public class BackgroundSoundService extends Service {
    MediaPlayer mediaPlayer;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = MediaPlayer.create(this,Settings.System.DEFAULT_RINGTONE_URI);
        mediaPlayer.setVolume(70, 70);
        mediaPlayer.setLooping(true);
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer.start();
//        Toast.makeText(getApplicationContext(), "Playing Bohemian Rashpody in the Background",    Toast.LENGTH_SHORT).show();
        return startId;
    }
    @Override
    public void onDestroy() {
        mediaPlayer.stop();
        mediaPlayer.release();
    }
    @Override
    public void onLowMemory() {
        //implemented in the future
    }
}