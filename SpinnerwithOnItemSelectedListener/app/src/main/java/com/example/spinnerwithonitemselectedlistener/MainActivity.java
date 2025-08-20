package com.example.spinnerwithonitemselectedlistener;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner;
    private String[] countryNames, population;
    private boolean isFirstSelection = true;
    private int[] flags = {
            R.drawable.afghanistan,
            R.drawable.bangladesh,
            R.drawable.bhutan,
            R.drawable.cambodia,
            R.drawable.china,
            R.drawable.cyprus,
            R.drawable.georgia,
            R.drawable.india,
            R.drawable.indonesia,
            R.drawable.iran,
            R.drawable.iraq,
            R.drawable.israel,
            R.drawable.japan,
            R.drawable.maldives,
            R.drawable.nepal,
            R.drawable.pakistan,
            R.drawable.srilanka
    };

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
        countryNames = getResources().getStringArray(R.array.country_names);
        population = getResources().getStringArray(R.array.populations);
        spinner = findViewById(R.id.spinnerId);

        CustomAdapter adapter = new CustomAdapter(this, flags, countryNames, population);
        spinner.setAdapter(adapter);



        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (isFirstSelection==true){
                    isFirstSelection = false;
                }else {
                    Toast.makeText(getApplicationContext(),countryNames[i],Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }
}