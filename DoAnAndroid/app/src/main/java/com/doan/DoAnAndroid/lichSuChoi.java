package com.doan.DoAnAndroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class lichSuChoi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lichsuchoi);
    }

    public void rank(View view) {
        Intent intent =new Intent(this,bangXepHang.class);
        startActivity(intent);
    }
}
