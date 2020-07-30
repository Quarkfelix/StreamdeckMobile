package com.example.streamdeck;

import android.util.Log;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class MSG implements Runnable{
    private Thread t;
    private String msg = "Soundpad\n";

    public void send(String msg) {
        this.msg = msg;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        Client.writer.write(msg);
        Client.writer.flush();
    }
}
