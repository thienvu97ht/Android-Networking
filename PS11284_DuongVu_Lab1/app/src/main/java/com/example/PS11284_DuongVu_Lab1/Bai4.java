package com.example.PS11284_DuongVu_Lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Bai4 extends AppCompatActivity implements View.OnClickListener {
    Button button;
    EditText editText;
    TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4);
        button = findViewById(R.id.btnRun);
        editText = findViewById(R.id.edtSoGiay);
        tvResult = findViewById(R.id.txtResult);
        button.setOnClickListener(this);
    }

    public class AsyncTaskRunner extends AsyncTask<String, String, String>{
        private String resp;
        ProgressDialog dialog;
        TextView tvResult;
        EditText time;
        Context context;
        public AsyncTaskRunner(Context context, TextView tvResult, EditText time){
            this.tvResult = tvResult;
            this.context = context;
            this.time = time;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            if(editText.getText().toString().trim().isEmpty() ){
                Toast.makeText(Bai4.this, "Vui lòng nhập số giây",Toast.LENGTH_LONG).show();
            }
            dialog = ProgressDialog.show(context,"ProgressDialog", "Wait for " + time.getText().toString() + " seconds" );
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (dialog.isShowing()){
                dialog.dismiss();
            }
            tvResult.setText(s);
        }

        @Override
        protected String doInBackground(String... strings) {
            publishProgress("Sleeping....");
            try {
                int time = Integer.parseInt(strings[0])*1000;
                Thread.sleep(time);
                resp = "Slept for " + strings[0] + " seconds";
            } catch (Exception e){
                e.printStackTrace();
                resp = e.getMessage();
            }
            return resp;
        }
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnRun:
                AsyncTaskRunner asyncTaskRunner = new AsyncTaskRunner(this, tvResult, editText);
                String sleepTime = editText.getText().toString();
                asyncTaskRunner.execute(sleepTime);
                break;
        }
    }
}