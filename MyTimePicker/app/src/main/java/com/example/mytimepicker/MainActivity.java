package com.example.mytimepicker;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
//    private TimePicker timePicker;
    private Button button;
    private TextView textView;
    private TimePickerDialog timePickerDialog;


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
//        timePicker = findViewById(R.id.timePickerId);
//        timePicker.setIs24HourView(true);
        button = findViewById(R.id.showButtonId);
        textView = findViewById(R.id.textViewId);

//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String time = timePicker.getCurrentHour() + ": "+ timePicker.getCurrentMinute();
//                textView.setText(time);
//            }
//        });


        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        TimePicker timePicker= new TimePicker(this);
        int currentHour = timePicker.getCurrentHour();
        int currentMinute = timePicker.getCurrentMinute();


        timePickerDialog = new TimePickerDialog(MainActivity.this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                        textView.setText(hourOfDay+": "+minute);
                    }
                }, currentHour, currentMinute, true);

        timePickerDialog.show();
    }
}