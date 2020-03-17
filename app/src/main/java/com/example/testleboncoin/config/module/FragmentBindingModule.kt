package com.example.testleboncoin.config.module

import com.example.testleboncoin.features.albums.AlbumFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBindingModule {

    @ContributesAndroidInjector
    abstract fun albumFragment () : AlbumFragment

}