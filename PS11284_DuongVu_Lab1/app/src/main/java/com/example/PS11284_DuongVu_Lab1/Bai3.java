package com.example.PS11284_DuongVu_Lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.net.URL;

public class Bai3 extends AppCompatActivity implements View.OnClickListener {
    Button btnLoad;
    ImageView imgHinh;
    TextView txtText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);
        imgHinh = findViewById(R.id.imgHinhBai3);
        btnLoad = findViewById(R.id.btnLoadBai3);
        btnLoad.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        new LoadImage().execute("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRRYLbytj76ImG_iXfI6qQVlYCRJyJMKEvavQ&usqp=CAU");
    }

    class LoadImage extends AsyncTask<String, String, Bitmap> {
        @Override
        protected Bitmap doInBackground(String... strings) {
            URL url;
            Bitmap bmp = null;
            try {
                url = new URL(strings[0]);
                bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bmp;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            imgHinh.setImageBitmap(bitmap);
        }
    }
}