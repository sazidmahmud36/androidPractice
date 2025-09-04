package com.example.framelayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView afganistanImageView, bangladeshImageView, nepalImageView, pakistanImageView;

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
        afganistanImageView = findViewById(R.id.afganistanImageViewId);
        bangladeshImageView = findViewById(R.id.bangladeshImageViewId);
        nepalImageView = findViewById(R.id.nepalImageViewId);
        pakistanImageView = findViewById(R.id.pakistanImageViewId);

        afganistanImageView.setOnClickListener(this);
        bangladeshImageView.setOnClickListener(this);
        nepalImageView.setOnClickListener(this);
        pakistanImageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.afganistanImageViewId){
            afganistanImageView.setVisibility(View.GONE);
            bangladeshImageView.setVisibility(View.VISIBLE);
        }
        if (view.getId() == R.id.bangladeshImageViewId){
            bangladeshImageView.setVisibility(View.GONE);
            nepalImageView.setVisibility(View.VISIBLE);
        }
        if (view.getId() == R.id.nepalImageViewId){
            nepalImageView.setVisibility(View.GONE);
            pakistanImageView.setVisibility(View.VISIBLE);
        }
        if (view.getId() == R.id.pakistanImageViewId){
            pakistanImageView.setVisibility(View.GONE);
            afganistanImageView.setVisibility(View.VISIBLE);
        }
    }
}