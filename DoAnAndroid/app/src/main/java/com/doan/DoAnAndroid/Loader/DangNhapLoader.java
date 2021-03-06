package com.doan.DoAnAndroid.Loader;

import android.os.AsyncTask;
import android.util.Log;

import com.doan.DoAnAndroid.NetWorkUtils;

import java.util.HashMap;

public class DangNhapLoader extends AsyncTask<String , Void , String> {
    @Override
    protected String doInBackground(String... strings) {
        String tenDangNhap = strings[0];
        String password = strings[1];
        HashMap<String, String> params = new HashMap<>();
        params.put("ten_dang_nhap", tenDangNhap);
        params.put("password", password);
        return NetWorkUtils.doRequest("dang-nhap", "POST", params, null);
    }
}
