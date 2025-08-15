package com.example.myclockdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.TextClock;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextClock textClock;
    private AnalogClock analogClock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        analogClock = findViewById(R.id.analogClockId);
        textClock = findViewById(R.id.textClockId);
        analogClock.setOnClickListener(this);
        textClock.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId()== R.id.analogClockId){
            Toast.makeText(MainActivity.this, "Analog Clock", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.textClockId) {
            Toast.makeText(MainActivity.this, "Digital Clock", Toast.LENGTH_SHORT).show();
        }
    }
}