package com.example.myalertdialogdemo;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button exitButton;
    private AlertDialog.Builder alertDialogBuilder;


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
        exitButton = findViewById(R.id.buttonId);
        exitButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        // For setting title
        alertDialogBuilder.setTitle(R.string.title_text);

        //For setting message
        alertDialogBuilder.setMessage(R.string.message_text);

        //For setting icon
        alertDialogBuilder.setIcon(R.drawable.remove);

        alertDialogBuilder.setCancelable(false);

        //For Setting positive button
        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //exit
                finish();

            }
        });

        //for negative Button
        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
//                Toast.makeText(MainActivity.this, "You have clicked on 'no' button!", Toast.LENGTH_SHORT).show();
                dialogInterface.cancel();
            }
        });

        //for nutral Button
        alertDialogBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "You have clicked on 'cancel' button!", Toast.LENGTH_SHORT).show();

            }
        });



        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }
}