package com.example.labbnumber2;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.Subscribe;


public class MainActivity extends AppCompatActivity {

    private long count = 0, add = 1;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.textView);
        EventBus.getDefault().register(this);
    }

    // Метод onClick для обработки клика (например, для увеличения счёта)
    public void onClick(View view) {
        count += add;
        String timesText = getTimesText(count);
        text.setText(String.format("У вас на счете %d %s", count, timesText));

        if (count == 15) {
            Toast.makeText(this, "ВЫ БИЗНЕСМЕН", Toast.LENGTH_SHORT).show();
        }
        if (count == 25) {
            Toast.makeText(this, "ВЫ МИЛЛИОНЕР", Toast.LENGTH_SHORT).show();
        }
        if (count == 35) {
            Toast.makeText(this, "ВЫ МИЛЛИАРДЕР", Toast.LENGTH_SHORT).show();
        }
    }

    // Метод для выбора правильной формы слова "доллар"
    private String getTimesText(long count) {
        if (count % 10 == 1 && count % 100 != 11) {
            return "доллар";
        } else if (count % 10 >= 2 && count % 10 <= 4 && !(count % 100 >= 12 && count % 100 <= 14)) {
            return "доллара";
        } else {
            return "долларов";
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    // Обработчик событий от EventBus
    @SuppressLint("DefaultLocale")
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(Message event) {
        count = event.getCount();
        add = event.getAdd();
        String timesText = getTimesText(count);
        text.setText(String.format("У вас на счете %d %s", count, timesText));
    }

    // Обработчик для перехода в ShopActivity
    public void onClickShopActivity(View view) {
        Intent intent = new Intent(this, ShopActivity.class);
        startActivity(intent);

        // Отложенный пост события через EventBus
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                EventBus.getDefault().post(new Message(count, add));
            }
        }, 200);
    }

    // Обработчик для перехода в RateActivity
    public void onClickRateActivity(View view) {
        Intent intent = new Intent(MainActivity.this, RateActivity.class);
        startActivity(intent);
    }
}

