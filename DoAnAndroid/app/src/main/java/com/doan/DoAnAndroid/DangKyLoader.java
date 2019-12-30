package com.doan.DoAnAndroid;

import android.os.AsyncTask;

import java.util.HashMap;

public class DangKyLoader extends AsyncTask<String , Void ,String> {
    @Override
    protected String doInBackground(String... strings) {
        HashMap<String, String> param = new HashMap<>();
        param.put("ten_dang_nhap", strings[0]);
        param.put("email", strings[1]);
        param.put("mat_khau", strings[2]);
        param.put("ho_ten", strings[3]);
        return NetWorkUtils.postRequest("dang-ky", param);
    }
}
