package com.example.mediaplayerdemo;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageButton playButton, pauseButton;
    private MediaPlayer mediaPlayer;

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
        playButton = findViewById(R.id.playButtonId);
        pauseButton = findViewById(R.id.pauseButtonId);

        mediaPlayer = MediaPlayer.create(this, R.raw.niye_jabe_ki);
        playButton.setOnClickListener(this);
        pauseButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.playButtonId){
            if (mediaPlayer != null){
                mediaPlayer.start();
                int duration = mediaPlayer.getDuration()/1000;
                Toast.makeText(MainActivity.this,"Song Played"+duration, Toast.LENGTH_SHORT).show();
            }
        }
        if (view.getId() == R.id.pauseButtonId){
            if (mediaPlayer != null){
                mediaPlayer.pause();
                Toast.makeText(MainActivity.this, "Song Paused", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onDestroy() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDestroy();
    }
}