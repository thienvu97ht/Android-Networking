package com.example.PS11284_DuongVu_Lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button bai1, bai2, bai3, bai4, bai5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bai1 = findViewById(R.id.button);
        bai2 = findViewById(R.id.button2);
        bai3 = findViewById(R.id.button3);
        bai4 = findViewById(R.id.button4);
        bai5 = findViewById(R.id.button5);
        bai1.setOnClickListener(this);
        bai2.setOnClickListener(this);
        bai3.setOnClickListener(this);
        bai4.setOnClickListener(this);
        bai5.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.button){
            startActivity(new Intent(MainActivity.this, Bai1.class));
        }
        if(view.getId() == R.id.button2){
            startActivity(new Intent(MainActivity.this, Bai2.class));
        }
        if(view.getId() == R.id.button3){
            startActivity(new Intent(MainActivity.this, Bai3.class));
        }
        if(view.getId() == R.id.button4){
            startActivity(new Intent(MainActivity.this, Bai4.class));
        }
        if(view.getId() == R.id.button5){
            startActivity(new Intent(MainActivity.this, Bai5.class));
        }
    }
}