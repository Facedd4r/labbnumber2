package com.example.labbnumber2;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class RateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_rate);
        Button button2 = findViewById(R.id.button2);
        Button button5 = findViewById(R.id.button5);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Показываем уведомление (Toast)
                Toast.makeText(RateActivity.this, "Спасибо за отзыв", Toast.LENGTH_SHORT).show();
                // Завершаем активность, возвращаясь в MainActivity
                finish();
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Показываем уведомление (Toast)
                Toast.makeText(RateActivity.this, "Спасибо за отзыв", Toast.LENGTH_SHORT).show();
                // Завершаем активность, возвращаясь в MainActivity
                finish();
            }
        });
    }
}