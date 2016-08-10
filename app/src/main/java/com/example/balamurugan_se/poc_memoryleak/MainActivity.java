package com.example.balamurugan_se.poc_memoryleak;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static MainActivity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((Button) findViewById(R.id.btnClick)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setStaticActivity();
                nextActivity();
            }
        });
    }

    void setStaticActivity() {
        activity = this;
    }

    void nextActivity() {
        Intent intent = new Intent(this, DestinationActivity.class);
        startActivity(intent);
        SystemClock.sleep(600);
        finish();
    }
}
