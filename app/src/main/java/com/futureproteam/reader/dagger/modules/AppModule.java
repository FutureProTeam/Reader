package com.futureproteam.reader.dagger.modules;

import android.content.Context;

import com.futureproteam.reader.base.BaseApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ding-syi on 2017/10/14.
 */

@Module
public class AppModule {
    private BaseApplication baseApplication;

    public AppModule(BaseApplication baseApplication){
        this.baseApplication = baseApplication;
    }


    @Provides
    @Singleton
    Context provideApplicationContext(){
        return baseApplication;
    }

}
