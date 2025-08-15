package com.example.countryprofile;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.window.OnBackInvokedDispatcher;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button bdBtn, indBtn, pakBtn;
    private Intent intent;

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
        bdBtn = findViewById(R.id.bdButtonId);
        indBtn = findViewById(R.id.indButtonId);
        pakBtn = findViewById(R.id.pakButtonId);
        bdBtn.setOnClickListener(this);
        indBtn.setOnClickListener(this);
        pakBtn.setOnClickListener(this);


        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                showExitDialog();
            }
        });

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.bdButtonId){
            intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("name", "bangladesh");
            startActivity(intent);
        }
        if (view.getId() == R.id.indButtonId){
            intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("name", "india");
            startActivity(intent);
        }
        if (view.getId() == R.id.pakButtonId){
            intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("name", "pakistan");
            startActivity(intent);
        }
    }



    public void showExitDialog(){
        AlertDialog.Builder alertdialogBuilder;
        alertdialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertdialogBuilder.setIcon(R.drawable.remove);
        alertdialogBuilder.setTitle(R.string.title_text);
        alertdialogBuilder.setMessage(R.string.message_text);
        alertdialogBuilder.setCancelable(false);

        alertdialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        alertdialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog alertDialog = alertdialogBuilder.create();
        alertDialog.show();

    }
}