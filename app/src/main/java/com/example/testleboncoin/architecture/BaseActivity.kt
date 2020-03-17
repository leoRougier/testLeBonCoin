package com.example.testleboncoin.architecture

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.navigation.fragment.NavHostFragment
import com.example.testleboncoin.R
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity: DaggerAppCompatActivity(){

    open val layoutRes = R.layout.frame

    protected abstract val navigationRes: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutRes)
        val finalHost = NavHostFragment.create(navigationRes)
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame, finalHost)
            .setPrimaryNavigationFragment(finalHost)
            .commit()
    }
}