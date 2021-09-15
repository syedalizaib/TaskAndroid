package com.taskandroid.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
open class AppModule(context: App) {

    private val mContext = context

    @Singleton
    @Provides
    open fun provideContext(): Context {
        return mContext
    }

}