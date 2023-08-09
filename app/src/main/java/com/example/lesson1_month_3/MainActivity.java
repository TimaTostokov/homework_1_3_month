package com.example.lesson1_month_3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText et_emil, et_theme, et_massage;
    private Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_emil = findViewById(R.id.et_email);
        et_theme = findViewById(R.id.et_theme);
        et_massage = findViewById(R.id.et_message);
        send = findViewById(R.id.btn_send);

        send.setOnClickListener(v -> {
            String email;
            String theme;
            String message;
            email = et_emil.getText().toString();
            theme = et_theme.getText().toString();
            message = et_massage.getText().toString();
            setSend(email, theme, message);
        });
    }

    private void setSend(String email, String theme, String message) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, email);
        intent.putExtra(Intent.EXTRA_SUBJECT, theme);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Send"));
    }
}