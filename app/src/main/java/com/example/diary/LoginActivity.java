package com.example.diary;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LoginActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "AppSettings";
    private static final String KEY_NAME = "userName";
    private static final String KEY_PASSWORD = "userPassword";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SharedPreferences shared = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        String userName = (shared.getString(KEY_NAME, ""));

        Date cDate = new Date();
        String fDate = new SimpleDateFormat("YYY-MM-dd").format(cDate);

        TextView tvHello = findViewById(R.id.tvHello);
        TextView tvDate = findViewById(R.id.tvDate);
        TextView tvError = findViewById(R.id.tvError);
        EditText txtPass = (EditText) findViewById(R.id.txtPassword);

        tvHello.setText("Hello, " + userName + "!");
        tvDate.setText("Today is " + fDate);

        ImageButton imgBtnProceed = findViewById(R.id.imgBtnProceed);
        imgBtnProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String password = txtPass.getText().toString();

                if(password.equals(shared.getString(KEY_PASSWORD, ""))){
                    startActivity(new Intent(LoginActivity.this, WelcomeAnimationActivity.class));
                } else {
                    tvError.setText("Invalid Password! Please try again.");
                }
            }
        });
    }
}