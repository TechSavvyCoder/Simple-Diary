package com.example.diary;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Timer;
import java.util.TimerTask;

public class WelcomeAnimationActivity extends AppCompatActivity {

    AnimationDrawable anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_animation);

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