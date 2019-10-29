package com.doan.DoAnAndroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;

public class quanLyTaiKhoan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quanlytaikhoan);
    }

    public void btnMuaCredit(View view) {
        Intent intent =new Intent(this,muaCredit.class);
        startActivity(intent);
    }
}
