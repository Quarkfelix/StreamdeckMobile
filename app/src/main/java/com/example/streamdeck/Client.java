package com.example.streamdeck;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.util.LogPrinter;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;

public class Client extends Activity implements Runnable, Parcelable {
    Thread t;
    public static Socket client = null;
    private OutputStream out;
    public static PrintWriter writer;
    private TextView ausgabe;
    private boolean initialized = false;

    //Constructor-------------------------------------------------------------------
    public Client(Activity activity) {
        ausgabe = activity.findViewById(R.id.ausgabe);
    }


    public void initiate() {
        t = new Thread(this);
        t.start();
    }

    //methods-----------------------------------------------------------------------
    private void initialize() {
        try {
            client = new Socket();
            SocketAddress sa = new InetSocketAddress("192.168.178.80",8143);
            client.connect(sa, 200);
            out = client.getOutputStream();
            writer = new PrintWriter(out);
            initialized = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(client.isConnected()) {
            ausgabe.setText("connected");
        } else {
            ausgabe.setText("connection failed");
        }
    }

    public void disconnect() {
        try {
            MainActivity.msg.send("disconnect\n");
            Thread.sleep(200);
            writer.close();
            out.close();
            client.close();
            ausgabe.setText("verbindung geschlossen");
        } catch (IOException | InterruptedException e) {
            ausgabe.setText("schließen fehlgeschlagen");
            e.printStackTrace();
        }
    }

    public boolean isConnected() {
        if (initialized) {
            return client.isConnected();
        }
        return false;
    }




    protected Client(Parcel in) {
    }

    public static final Creator<Client> CREATOR = new Creator<Client>() {
        @Override
        public Client createFromParcel(Parcel in) {
            return new Client(in);
        }

        @Override
        public Client[] newArray(int size) {
            return new Client[size];
        }
    };

    @Override
    public void run() {
        initialize();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }
}
