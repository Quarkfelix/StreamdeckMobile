package com.example.streamdeck;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import maes.tech.intentanim.CustomIntent;

public class Music extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music);

        Intent myIntent = getIntent();
        final Client client = myIntent.getParcelableExtra("client");

        findViewById(R.id.backButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.msg.send("back\n");
                Intent i = new Intent(Music.this, MainActivity.class);
                startActivity(i);
                CustomIntent.customType(Music.this, "right-to-left");

            }
        });

        findViewById(R.id.startYTMusic).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.msg.send("startYTMusic\n");
            }
        });

        //slider
        SeekBar seekBar = (SeekBar)findViewById(R.id.musicvolume);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                MainActivity.msg.send(seekBar.getProgress() + "\n");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                MainActivity.msg.send("volume\n");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                MainActivity.msg.send("dickandballs\n");
            }
        });

    }
}
