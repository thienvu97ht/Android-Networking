package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Lab2 extends AppCompatActivity implements View.OnClickListener {
    private EditText editName, editSore;
    private Button button;
    private TextView textView;

    String link;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2);
        link = "http://192.168.1.178/hoangngocphuc/student_get.php";
        editName = (EditText) findViewById(R.id.editName);
        editSore = (EditText) findViewById(R.id.editSore);
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        BackgroundTask_GET BackgroundTask_GET = new BackgroundTask_GET(this,link,editName.getText().toString(),editSore.getText().toString(),textView);
        BackgroundTask_GET.execute();
    }
}