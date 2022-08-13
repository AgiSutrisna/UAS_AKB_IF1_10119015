package com.example.uas_akb_if1_10119015;

/*
    Nama    : Agi Sutrisna
    Nim     : 10119015
    Kelas   : IF1
 */

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class splahScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splah_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(splahScreen.this, viewPager.class);
                startActivity(intent);
            }
        },5000);
    }
}