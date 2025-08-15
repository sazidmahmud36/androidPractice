package com.example.mydatepickerdialogue;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textView;
    private Button button;
    private DatePickerDialog datePickerDialog;


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
        textView = findViewById(R.id.textViewId);
        button = findViewById(R.id.buttonId);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        DatePicker datePicker = new DatePicker(this);
        int currentday = datePicker.getDayOfMonth();
        int currentmonth = (datePicker.getMonth())+1;
        int currentyear = datePicker.getYear();


        datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener(){
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        textView.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                    }
                },currentyear, currentmonth,currentday);
        datePickerDialog.show();


    }

}