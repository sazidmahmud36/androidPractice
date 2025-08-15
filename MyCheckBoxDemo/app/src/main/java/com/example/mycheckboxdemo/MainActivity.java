package com.example.mycheckboxdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private CheckBox milkCheckBox, sugarCheckBox, waterCheckBox;
    private Button showButton;
    private TextView resultTextView;



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
        milkCheckBox = findViewById(R.id.milkCheckBoxId);
        sugarCheckBox = findViewById(R.id.sugarCheckBoxId);
        waterCheckBox =findViewById(R.id.waterCheckBoxId);

        showButton = findViewById(R.id.showButtonId);
        resultTextView = findViewById(R.id.resultTextViewId);
        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder stringBuilder = new StringBuilder();
                if (milkCheckBox.isChecked()) {
                    String value = milkCheckBox.getText().toString();
                    stringBuilder.append(value + " has been ordered!\n");
                }
                if (sugarCheckBox.isChecked()) {
                    String value = sugarCheckBox.getText().toString();
                    stringBuilder.append(value + " has been ordered!\n");
                }
                if (waterCheckBox.isChecked()){
                    String value = waterCheckBox.getText().toString();
                    stringBuilder.append(value +" has been ordered!\n");
                }

                resultTextView.setText(stringBuilder);
            }
        });

    }
}