package com.example.diary;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Settings extends AppCompatActivity {

    private static final String PREFS_NAME = "AppSettings";
    private static final String KEY_NAME = "userName";
    private static final String KEY_PASSWORD = "userPassword";
    private static final String KEY_CDATETIME = "curDateTime";

    private EditText txtName, txtPass;
    private Button btnConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        txtName = (EditText) findViewById(R.id.txtName);
        txtPass = (EditText) findViewById(R.id.txtPassword);
        btnConfirm = (Button) findViewById(R.id.btnConfirm);

        SharedPreferences preferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        String userName = preferences.getString(KEY_NAME, "");
        String userPassword = preferences.getString(KEY_PASSWORD, "");

        // clearSharedPreferences();

        if(!userName.isEmpty() || !userPassword.isEmpty()){
            startActivity(new Intent(Settings.this, LoginActivity.class));
        } else {
            btnConfirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String name = txtName.getText().toString();
                    String password = txtPass.getText().toString();

                    // check if length of password is less than 4 digits
                    if (password.length() < 4) {
                        Toast.makeText(Settings.this, "Password must be at least 4 digits long", Toast.LENGTH_SHORT).show();
                    } else {
                        if (!name.isEmpty() && !password.isEmpty()) {
                            Date currentTime = Calendar.getInstance().getTime();
                            String currentDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(currentTime);

                            SharedPreferences.Editor editor = preferences.edit();
                            editor.putString(KEY_NAME, name);
                            editor.putString(KEY_PASSWORD, password);
                            editor.putString(KEY_CDATETIME, currentDateTime);
                            editor.commit();

                            startActivity(new Intent(Settings.this, LoginActivity.class));
                        } else {
                            Toast.makeText(Settings.this, "Please enter both username and password", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });
        }
    }

    public void clearSharedPreferences () {
        SharedPreferences preferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        preferences.edit().clear().commit();
    }
}