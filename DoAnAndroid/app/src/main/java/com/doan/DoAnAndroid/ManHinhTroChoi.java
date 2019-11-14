package com.doan.DoAnAndroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

public class ManHinhTroChoi extends AppCompatActivity {
    private TextView textTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manhinhtrochoi);

        textTime=(TextView)findViewById(R.id.txttime);

    }
    public ManHinhTroChoi(){
        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                textTime.setText("" + millisUntilFinished / 1000);
            }

            public void onFinish() {
                textTime.setText("0");
            }
        }.start();
    }
}
