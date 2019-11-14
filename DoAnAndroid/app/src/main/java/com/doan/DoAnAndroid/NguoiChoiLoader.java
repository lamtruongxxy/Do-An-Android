package com.doan.DoAnAndroid;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

public class NguoiChoiLoader extends AsyncTaskLoader<String> {
    public NguoiChoiLoader(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Nullable
    @Override
    public String loadInBackground() {
         return NetWorkUtils.getJSONData("nguoi-choi","GET");
    }
}
