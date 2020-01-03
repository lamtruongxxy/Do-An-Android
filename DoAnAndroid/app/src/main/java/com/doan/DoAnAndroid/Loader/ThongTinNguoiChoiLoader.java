package com.doan.DoAnAndroid.Loader;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import com.doan.DoAnAndroid.NetWorkUtils;

public class ThongTinNguoiChoiLoader extends AsyncTaskLoader {
    private String token;
    public ThongTinNguoiChoiLoader(@NonNull Context context,String token) {
        super(context);
        this.token = token;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Nullable
    @Override
    public Object loadInBackground() {
        return NetWorkUtils.doRequest("lay-thong-tin","GET",null,token);
    }
}
