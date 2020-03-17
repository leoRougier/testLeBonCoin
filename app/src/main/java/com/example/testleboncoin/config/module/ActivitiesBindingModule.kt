package com.example.testleboncoin.config.module

import com.example.testleboncoin.features.albums.AlbumActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivitiesBindingModule {

    @ContributesAndroidInjector
    abstract fun albumActivity () : AlbumActivity

}