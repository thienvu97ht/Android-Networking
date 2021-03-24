package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Lab1 extends AppCompatActivity implements View.OnClickListener {
    Button button;
    TextView textView;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab1);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView2);
        imageView = findViewById(R.id.imageView);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //download anh
                final Bitmap bitmap = getPicture("https://scontent.fsgn5-2.fna.fbcdn.net/v/t1.0-9/158642718_1280258412367661_8960931184564836823_o.jpg?_nc_cat=105&ccb=1-3&_nc_sid=825194&_nc_ohc=TzijxhxrIgMAX-OIo6T&_nc_ht=scontent.fsgn5-2.fna&oh=382f28ed93c4773e71dfabc77bdb2cad&oe=607792B8");
                imageView.post(new Runnable() {
                    @Override
                    public void run() {
                        imageView.setImageBitmap(bitmap);
                        textView.setText("Dowloand thanh cong");
                    }
                });
            }
        });
        thread.start();
    }
    private Bitmap getPicture(String link){
        URL url;
        Bitmap bitmap = null ;
        try {
            url = new URL(link);// lay ve duong dan anh
            bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}