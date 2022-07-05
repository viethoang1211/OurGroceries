package com.example.ourgroceries;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;

public class SettingActivity extends AppCompatActivity {
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this,gso);
        Switch music= findViewById(R.id.music);
        music.setChecked(true);
    }

    public void onDarkmodeClicked(View view) {
        // Is the switch on?
        boolean on = ((Switch) view).isChecked();
        if (on) {
            AppCompatDelegate
                    .setDefaultNightMode(
                            AppCompatDelegate
                                    .MODE_NIGHT_YES);
        } else {
            AppCompatDelegate
                    .setDefaultNightMode(
                            AppCompatDelegate
                                    .MODE_NIGHT_NO);
        }
    }
    public void onMusicClicked(View view) {
        // Is the switch on?
        boolean on = ((Switch) view).isChecked();
        if (on) {
            PlayBackgroundSound();
        } else {
            StopBackgroundSound();
        }
    }
    public void PlayBackgroundSound() {
        Intent intent = new Intent(SettingActivity.this, BackgroundSoundService.class);
        int x=1;
        intent.putExtra(BranchInfo.EXTRA_MESSAGE,x);
        startService(intent);
    }
    public void StopBackgroundSound() {
        Intent intent = new Intent(SettingActivity.this, BackgroundSoundService.class);
        int x=0;
        intent.putExtra(BranchInfo.EXTRA_MESSAGE,x);
        stopService(intent);
    }

    public void onLogOut(View view) {
        gsc.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(Task<Void> task) {
                finish();
                startActivity(new Intent(SettingActivity.this,LoginActivity.class));
            }
        });
    }

    public void onbackbuttonsetting(View view) {
        finish();
    }
}