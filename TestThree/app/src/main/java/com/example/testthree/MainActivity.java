package com.example.testthree;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageView1,imageView2;
    private Button clickButton;

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
        imageView1 = findViewById(R.id.imageView1Id);
        imageView2 = findViewById(R.id.imageView2Id);
        clickButton = findViewById(R.id.clickButtonId);
        imageView1.setOnClickListener(this);
        imageView2.setOnClickListener(this);

        clickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = getLayoutInflater();
                View customView = inflater.inflate(R.layout.customtoast_layout,findViewById(R.id.customToastId));

                Toast toast = new Toast(MainActivity.this);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0,0);
                toast.setView(customView);
                toast.show();

            }
        });

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.imageView1Id){
            Toast.makeText(MainActivity.this,"Sun Rise", Toast.LENGTH_SHORT).show();
        }
        else if (view.getId() == R.id.imageView2Id){
            Toast.makeText(MainActivity.this, "Sun Set", Toast.LENGTH_SHORT).show();
        }
    }
}