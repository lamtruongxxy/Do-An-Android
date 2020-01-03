package com.doan.DoAnAndroid.Loader;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import com.doan.DoAnAndroid.NetWorkUtils;

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
         return NetWorkUtils.getJSONData("nguoi-choi/xep-hang","GET");
    }
}
