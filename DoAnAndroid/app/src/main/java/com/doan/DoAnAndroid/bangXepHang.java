package com.doan.DoAnAndroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class bangXepHang extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bangxephang);
    }

    public void lichSuGame(View view) {
        Intent intent =new Intent(this,lichSuChoi.class);
        startActivity(intent);
    }
}
