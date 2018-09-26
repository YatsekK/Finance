package com.example.yatsek.finance.app;

import android.app.Application;

public class AppContext extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DbConnection.initConnection(this);
    }
}
