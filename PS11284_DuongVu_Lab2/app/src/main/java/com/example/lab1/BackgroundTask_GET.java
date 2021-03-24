package com.example.lab1;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class BackgroundTask_GET extends AsyncTask<String, Void, String> {
    private Context context;
    private String link, name, score;
    private  TextView textView;
    private  String kq="";
    public BackgroundTask_GET(Context context,String link,String name,String score, TextView textView){
        this.context = context;
        this.link = link;
        this.name = name;
        this.score = score;
        this.textView = textView;
    }

    @Override
    protected String doInBackground(String... strings) {
        link +="?name="+name+"&score="+score;
        try {
            URL url = new URL(link);
            HttpURLConnection urlConnection=(HttpURLConnection)url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String line="";
            while ((line = br.readLine())!=null){
                sb.append(line);
            }
            kq = sb.toString();
            urlConnection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return kq;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        textView.setText(kq);
    }
}
