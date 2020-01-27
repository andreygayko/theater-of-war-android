package com.example.theaterofwar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class StartScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

    }

    public void onClickGoToHeroes(View view) {
        Context context = StartScreenActivity.this;
        Class destinationActivity = MainActivity.class;
        Intent intent = new Intent(context, destinationActivity);
        startActivity(intent);
    }
}
