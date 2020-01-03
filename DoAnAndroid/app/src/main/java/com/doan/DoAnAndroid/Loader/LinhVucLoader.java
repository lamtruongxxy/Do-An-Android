package com.doan.DoAnAndroid.Loader;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import com.doan.DoAnAndroid.NetWorkUtils;

public class LinhVucLoader extends AsyncTaskLoader <String> {
    private String token;
    public LinhVucLoader(@NonNull Context context, String token) {
        super(context);
        this.token = token;
    }

    @Nullable
    @Override
    public String loadInBackground() {
        return NetWorkUtils.doRequest("linh-vuc","GET",null,token);
    }
    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

}
