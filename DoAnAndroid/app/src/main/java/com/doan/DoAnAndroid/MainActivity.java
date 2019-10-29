package com.doan.DoAnAndroid;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ThemedSpinnerAdapter;


public class MainActivity extends AppCompatActivity  {
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.nhacnen);
        mediaPlayer.start();

       // Button btFinish = (Button) findViewById(R.id.btnthoat);
        //btFinish.setOnClickListener(new View.OnClickListener() {

           // @Override
           // public void onClick(View v) {
                //Khoi tao lai Activity main
               // Intent intent = new Intent(getApplicationContext(), Activity.class);
               // startActivity(intent);

                // Tao su kien ket thuc app
               // Intent startMain = new Intent(Intent.ACTION_MAIN);
               // startMain.addCategory(Intent.CATEGORY_HOME);
               // startActivity(startMain);
               // finish();
           // }
       // });
    }

    public void exit(View view) {
        mediaPlayer.stop();
        //Khoi tao lai Activity main deo can tao cai nay
        //Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        //startActivity(intent);

        // Tao su kien ket thuc app
        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startActivity(startMain);
        finish();
    }


    public void playgame(View view) {
        mediaPlayer.stop();
       Intent intent = new Intent(this,dangnhap.class);
        startActivity(intent);
        //android:label="second";//ten lable
        //android:parentActivityName=".MainActivity";//chuyen ve lop cha


    }

    public void btnbangxephang(View view) {
        Intent intent = new Intent(this,bangXepHang.class);
        startActivity(intent);
    }
}
