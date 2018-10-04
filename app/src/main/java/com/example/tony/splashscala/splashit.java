package com.example.tony.splashscala;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class splashit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashit);
        Thread scala= new Thread() {
            @Override
            public void run() {
                try {
                    sleep(3000);
                    Intent jj = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(jj);
                    finish();
                } catch
                        (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        };
}
    }