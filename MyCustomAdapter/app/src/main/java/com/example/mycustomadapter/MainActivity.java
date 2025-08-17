package com.example.mycustomadapter;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private String[] countryName;
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
            R.drawable.srilanka,

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
        listView = findViewById(R.id.listViewId);
        countryName = getResources().getStringArray(R.array.country_names);
        CustomAdapter adapter = new CustomAdapter(this, countryName, flags);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String value = countryName[i];
                Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
            }
        });
    }
}