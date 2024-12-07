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

public class UpdateSettings extends AppCompatActivity {

    private static final String PREFS_NAME = "AppSettings";
    private static final String KEY_NAME = "userName";
    private static final String KEY_PASSWORD = "userPassword";

    private EditText txtName, txtPass;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_settings);

        SharedPreferences preferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        String userName = preferences.getString(KEY_NAME, "");
        String userPassword = preferences.getString(KEY_PASSWORD, "");

        txtName = (EditText) findViewById(R.id.txtName);
        txtPass = (EditText) findViewById(R.id.txtPassword);
        btnSave = (Button) findViewById(R.id.btnSave);

        txtName.setText(userName);
        txtPass.setText(userPassword);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = txtName.getText().toString();
                String password = txtPass.getText().toString();

                // check if length of password is less than 4 digits
                if (password.length() < 4) {
                    Toast.makeText(UpdateSettings.this, "Password must be at least 4 digits long", Toast.LENGTH_SHORT).show();
                } else {
                    if (!name.isEmpty() && !password.isEmpty()) {
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString(KEY_NAME, name);
                        editor.putString(KEY_PASSWORD, password);
                        editor.commit();

                        Toast.makeText(UpdateSettings.this, "Changes has been saved", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(UpdateSettings.this, "Please enter both username and password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}