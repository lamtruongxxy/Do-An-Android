package com.doan.DoAnAndroid;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

public class CreditLoader extends AsyncTaskLoader<String> {
    private String token;

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    public CreditLoader(@NonNull Context context ,String token) {
        super(context);
        this.token = token;
    }

    @Nullable
    @Override
    public String loadInBackground() {
        return NetWorkUtils.doRequest("goi-credit","GET",null,token);
    }
}
