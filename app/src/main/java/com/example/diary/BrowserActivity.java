package com.example.diary;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BrowserActivity extends AppCompatActivity {

    private static final String PREFS_NAME_DIARY = "DiaryPrefs";
    private static final String KEY_DATETODAY = "dateToday";
    private static final String KEY_ENTRY = "entry";

    EditText txtDate;
    TextView tvEntry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);

        txtDate = findViewById(R.id.txtDate);
        tvEntry = findViewById(R.id.tvEntry);

        txtDate.setOnClickListener(v -> showDatePickerDialog());

        Button btnNext = (Button) findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BrowserActivity.this, WebBrowserActivity.class));
            }
        });
    }

    private void showDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                (view, year1, monthOfYear, dayOfMonth) -> {
                    Calendar selectedDate = Calendar.getInstance();
                    selectedDate.set(year1, monthOfYear, dayOfMonth);

                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", getResources().getConfiguration().locale);
                    String formattedDate = sdf.format(selectedDate.getTime());
                    txtDate.setText(formattedDate);

                    // getting the diary for current date
                    Date cDate = new Date();
                    String fDate = new SimpleDateFormat("YYY-MM-dd").format(cDate);

                    SharedPreferences shared = getSharedPreferences(PREFS_NAME_DIARY, MODE_PRIVATE);
                    String entry = (shared.getString(formattedDate, ""));

                    if(!entry.isEmpty()) {
                        tvEntry.setText(entry);
                    } else {
                        tvEntry.setText("");
                    }
                },
                year, month, day);

        datePickerDialog.show();
    }
}