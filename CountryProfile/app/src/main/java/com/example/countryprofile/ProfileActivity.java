package com.example.countryprofile;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProfileActivity extends AppCompatActivity {
    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        imageView = findViewById(R.id.imageViewId);
        textView = findViewById(R.id.textViewId);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            String countryName = bundle.getString("name");
            showDetails(countryName);
        }


    }
    void showDetails(String countryName){
        if (countryName.equals("bangladesh")){
            imageView.setImageResource(R.drawable.bd_img);
            textView.setText(R.string.bd_text);
        }
        if (countryName.equals("india")){
            imageView.setImageResource(R.drawable.ind_img);
            textView.setText(R.string.ind_text);
        }
        if (countryName.equals("pakistan")){
            imageView.setImageResource(R.drawable.pak_img);
            textView.setText(R.string.pak_text);
        }
    }
}