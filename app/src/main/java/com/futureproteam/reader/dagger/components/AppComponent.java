package com.futureproteam.reader.dagger.components;

import com.futureproteam.reader.activity.BookcaseActivity;
import com.futureproteam.reader.dagger.modules.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ding-syi on 2017/10/14.
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(BookcaseActivity activity);
}
