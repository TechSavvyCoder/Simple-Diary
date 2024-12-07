package com.example.diary;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class WelcomeAnimationActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "AppSettings";
    private static final String KEY_NAME = "userName";
    private static final String KEY_PASSWORD = "userPassword";
    private static final String KEY_CDATETIME = "curDateTime";

    AnimationDrawable anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_animation);

        SharedPreferences shared = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        String datetimeRegistered = (shared.getString(KEY_CDATETIME, ""));

        Date currentDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());

        try {
            Date givenDate = sdf.parse(datetimeRegistered);
            long differenceInMillis = currentDate.getTime() - givenDate.getTime();
            long differenceInSeconds = differenceInMillis / 1000;

            TextView tvWelcomeMsg = (TextView) findViewById(R.id.tvWelcomeMsg);
            tvWelcomeMsg.setText("You have been using this app for " + differenceInSeconds + " seconds.");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        ImageView imgViewProfiles = findViewById(R.id.imgViewProfiles);
        imgViewProfiles.setBackgroundResource(R.drawable.profiles);
        anim = (AnimationDrawable) imgViewProfiles.getBackground();
        anim.start();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(WelcomeAnimationActivity.this, DiaryInputActivity.class));
            }
        };

        Timer opening = new Timer();
        opening.schedule(task, 5000);

    }
}