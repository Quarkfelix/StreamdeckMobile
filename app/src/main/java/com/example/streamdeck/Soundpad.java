package com.example.streamdeck;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import maes.tech.intentanim.CustomIntent;

public class Soundpad extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soundpad);

        Intent myIntent = getIntent();
        final Client client = myIntent.getParcelableExtra("client");

        findViewById(R.id.backButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.msg.send("back\n");
                Intent i = new Intent(Soundpad.this, MainActivity.class);
                startActivity(i);
                CustomIntent.customType(Soundpad.this, "right-to-left");
            }
        });

        findViewById(R.id.sound1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.msg.send("sound1\n");
            }
        });
        findViewById(R.id.sound2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.msg.send("sound2\n");
            }
        });
        findViewById(R.id.sound3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.msg.send("sound3\n");
            }
        });
        findViewById(R.id.sound4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.msg.send("sound4\n");
            }
        });
        findViewById(R.id.sound5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.msg.send("sound5\n");
            }
        });
        findViewById(R.id.sound6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.msg.send("sound6\n");
            }
        });
        findViewById(R.id.sound7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.msg.send("sound7\n");
            }
        });
        findViewById(R.id.sound8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.msg.send("sound8\n");
            }
        });
        findViewById(R.id.sound9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.msg.send("sound9\n");
            }
        });
        findViewById(R.id.sound10).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.msg.send("sound10\n");
            }
        });
    }



}
