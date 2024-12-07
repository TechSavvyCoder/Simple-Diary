package com.example.diary;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DiaryInputActivity extends AppCompatActivity {


    private EditText txtDiaryEntry;
    private SharedPreferences preferences;
    private static final String PREFS_NAME = "DiaryPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_input);

        txtDiaryEntry = findViewById(R.id.editTextText);
        Button btnConfirm = (Button) findViewById(R.id.btnConfirm);

        preferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        Date cDate = new Date();
        String fDate = new SimpleDateFormat("YYY-MM-dd").format(cDate);

        String entry = preferences.getString(fDate, "");
        if(!entry.isEmpty()) {
            txtDiaryEntry.setText(entry);
        }

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString(fDate, txtDiaryEntry.getText().toString());
                editor.commit();

                startActivity(new Intent(DiaryInputActivity.this, BrowserActivity.class));
            }
        });
    }
}