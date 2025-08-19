package com.example.optionmenu;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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
    }
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_layout, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.settingId){
            Toast.makeText(MainActivity.this,item.toString() , Toast.LENGTH_SHORT).show();
        }
        if (item.getItemId()==R.id.shareId){
            Toast.makeText(MainActivity.this,item.toString() , Toast.LENGTH_SHORT).show();
        }
        if (item.getItemId()==R.id.feedbackId){
            Toast.makeText(MainActivity.this,item.toString() , Toast.LENGTH_SHORT).show();
        }
        if (item.getItemId()==R.id.aboutusId){
            Toast.makeText(MainActivity.this,item.toString() , Toast.LENGTH_SHORT).show();
        }

        return true;
    }
}