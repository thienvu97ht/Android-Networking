package com.example.PS11284_DuongVu_Lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.net.URL;

public class Bai1 extends AppCompatActivity implements View.OnClickListener {
    Button btnLoad;
    ImageView imgHinh;
    TextView txtText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);
        btnLoad = findViewById(R.id.btnLoad);
        imgHinh = findViewById(R.id.imgHinh);
        txtText = findViewById(R.id.txtTextview);
        btnLoad.setOnClickListener(this);
    }
    private Bitmap loadImage(String link){
        URL url;
        Bitmap bmp = null;
        try {
            url = new URL(link);
            bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return bmp;
    }

    @Override
    public void onClick(View view) {
        final Thread mythread = new Thread(new Runnable() {
            @Override
            public void run() {
                final Bitmap bitmap = loadImage("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQs4SgdrF5QJkfA2oSdAgl4bEdpLVJM_cXxCQ&usqp=CAU");
                imgHinh.post(new Runnable() {
                    @Override
                    public void run() {
                      txtText.setText("Image dang load");
                      imgHinh.setImageBitmap(bitmap);
                    }
                });
            }
        });
        mythread.start();
    }

}