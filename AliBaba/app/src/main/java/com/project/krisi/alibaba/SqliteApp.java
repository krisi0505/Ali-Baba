package com.project.krisi.alibaba;

/**
 * Created by Krisi on 11.10.2017 г..
 */

import android.app.Application;

import com.orm.SugarContext;

public class SqliteApp extends Application {

    @Override
    public void onCreate(){
        super.onCreate();
        SugarContext.init(this);
    }
}