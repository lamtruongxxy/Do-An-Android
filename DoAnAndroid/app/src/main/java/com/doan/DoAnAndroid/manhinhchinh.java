package com.doan.DoAnAndroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class manhinhchinh extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manhinhchinh);
        mediaPlayer = MediaPlayer.create(manhinhchinh.this,R.raw.musicbackground2);
        mediaPlayer.start();
    }

    public void btnDangXuat(View view) {
        Intent intent =new Intent(this,dangnhap.class);
        startActivity(intent);
        mediaPlayer.stop();
    }

    public void btnQuanLyTaiKhoan(View view) {
        Intent intent =new Intent(this,quanLyTaiKhoan.class);
        startActivity(intent);
    }

    public void startgame(View view) {
        Intent intent =new Intent(this,ChonLinhVuc.class);
        startActivity(intent);
    }

    public void lichSuGame(View view) {
        Intent intent =new Intent(this,lichSuChoi.class);
        startActivity(intent);
    }

    public void bangXepHang1(View view) {
        Intent intent =new Intent(this,bangXepHang.class);
        startActivity(intent);
    }
}
