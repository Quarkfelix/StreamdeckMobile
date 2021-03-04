package com.example.streamdeck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import maes.tech.intentanim.CustomIntent;

public class MainActivity extends AppCompatActivity {
    public static MSG msg = new MSG();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Client client = new Client(MainActivity.this);

        if(client.client == null) {
            Toast.makeText(getApplicationContext(),"connected to host!", Toast.LENGTH_SHORT).show();
            client.initiate();
        }


        findViewById(R.id.connectButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(client.client == null) {
                    Toast.makeText(getApplicationContext(),"connected to host", Toast.LENGTH_SHORT).show();
                    client.initiate();
                }
            }
        });

        findViewById(R.id.games).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                msg.send("Games\n");
                Intent i = new Intent(MainActivity.this, Games.class);
                startActivity(i);
                CustomIntent.customType(MainActivity.this, "left-to-right");
            }
        });

        findViewById(R.id.soundpad).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                msg.send("Soundpad\n");
                Intent i = new Intent(MainActivity.this, Soundpad.class);
                startActivity(i);
                CustomIntent.customType(MainActivity.this, "left-to-right");
            }
        });

        findViewById(R.id.music).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                msg.send("Music\n");
                Intent i = new Intent(MainActivity.this, Music.class);
                startActivity(i);
                CustomIntent.customType(MainActivity.this, "left-to-right");
            }
        });

        findViewById(R.id.chrome).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                msg.send("Chrome\n");
            }
        });

        findViewById(R.id.youtube).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                msg.send("Youtube\n");
            }
        });

        findViewById(R.id.screenshot).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                msg.send("Screenshot\n");
            }
        });

        findViewById(R.id.muteSystem).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                msg.send("Mute System\n");
            }
        });

        findViewById(R.id.powerOff).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                msg.send("Power Off\n");
            }
        });

        findViewById(R.id.audioSwitch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                msg.send("switch audiooutput\n");
            }
        });

    }


}

