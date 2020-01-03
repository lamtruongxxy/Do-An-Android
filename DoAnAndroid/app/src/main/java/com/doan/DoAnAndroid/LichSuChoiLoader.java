package com.doan.DoAnAndroid;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

public class LichSuChoiLoader extends AsyncTaskLoader<String> {
    private String token;
    private String id;
    public LichSuChoiLoader(@NonNull Context context,String token,String id) {
        super(context);
        this.token = token;
        this.id = id;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Nullable
    @Override
    public String loadInBackground() {
        return NetWorkUtils.doRequest("luot-choi/"+id,"GET",null,token);
    }
}
