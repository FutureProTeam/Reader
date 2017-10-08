package com.futureproteam.reader.base;

import android.app.Application;
import android.content.Context;

import com.blankj.utilcode.util.Utils;
import com.facebook.stetho.Stetho;
import com.morgoo.droidplugin.PluginHelper;
import com.uphyca.stetho_realm.RealmInspectorModulesProvider;

import io.realm.Realm;
import timber.log.Timber;

/**
 * Created by ding-syi on 2017/9/28.
 */

public class BaeApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //realm、stetho and stetho-realm configuration
        Realm.init(this);
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(RealmInspectorModulesProvider.builder(this).build())
                        .build());

        //init droidplugin
        PluginHelper.getInstance().applicationOnCreate(getBaseContext()); //must be after super.onCreate()

        //init Timber
        Timber.plant(new Timber.DebugTree());

        //init 工具库module
        Utils.init(this);
    }

    @Override
    protected void attachBaseContext(Context base) {

        //init droidplugin
        PluginHelper.getInstance().applicationAttachBaseContext(base);
        super.attachBaseContext(base);
    }
}
