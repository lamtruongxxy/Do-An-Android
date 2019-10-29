package com.doan.DoAnAndroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class dangnhap extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);
    }

    public void dangKy(View view) {
        Intent intent =new Intent(this,DangKi.class);
        startActivity(intent);
    }

    public void btnLayMatKhau(View view) {
        Intent intent =new Intent(this,quenMatKhau.class);
        startActivity(intent);
    }

    public void btnDangNhap(View view) {
        Intent intent =new Intent(this,manhinhchinh.class);
        startActivity(intent);
    }
}
