package com.example.testleboncoin.architecture

import android.content.Context
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.plusAssign
import java.lang.ref.WeakReference

abstract class BasePresenter<out T : BaseView> : LifecycleObserver {

    private var mView: WeakReference<T>? = null
    protected val view: T?
        get() = mView?.get()
    protected var onDestroyDisposable: CompositeDisposable? = null

    fun Disposable.disposeOnDestroy() {
        onDestroyDisposable!! += this
    }

    @Suppress("UNCHECKED_CAST")
    fun onViewAttach(view: BaseView) {
        mView = WeakReference(view as T)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    open fun onCreate(){
        onDestroyDisposable = CompositeDisposable()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    open fun onDestroy() {
        onDestroyDisposable?.dispose()
        onDestroyDisposable = null
        mView?.clear()
    }

    fun lifecycleDisposable(disposable: Disposable) {
    }

    protected fun getContext(): Context? {
        val view = mView?.get()
        return if (view is Context) view else null
    }
}