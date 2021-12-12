package com.example.saramobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class QuoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote);
    }
    public void classification(View view){

        Intent intent= new Intent(QuoteActivity.this,classicifactionActivity.class);
        startActivity(intent);
    }

    public void appointment(View view){

        Intent intent= new Intent(QuoteActivity.this,Psych.class);
        startActivity(intent);
    }
}