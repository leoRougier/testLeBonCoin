package com.example.testleboncoin.util


import androidx.room.RoomDatabase
import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

fun RoomDatabase.transactionCompletable(vararg args: () -> Unit): Completable {
    return Completable.concatArray(*args.map { Completable.fromAction(it) }.toTypedArray())
        .doOnSubscribe { beginTransaction() }
        .doOnComplete { setTransactionSuccessful() }
        .doFinally { endTransaction() }
        .subscribeOnIO()

}
fun Completable.subscribeOnIO() = subscribeOn(Schedulers.io())
fun <T> Flowable<T>.subscribeOnIO() = subscribeOn(Schedulers.io())
fun <T> Single<T>.subscribeOnIO() = subscribeOn(Schedulers.io())
fun <T> Maybe<T>.subscribeOnIO() = subscribeOn(Schedulers.io())

fun <T> Observable<T>.observeOnMain() = observeOn(AndroidSchedulers.mainThread())!!
fun <T> Flowable<T>.observeOnMain() = observeOn(AndroidSchedulers.mainThread())!!
fun <T> Single<T>.observeOnMain() = observeOn(AndroidSchedulers.mainThread())
fun <T> Maybe<T>.observeOnMain() = observeOn(AndroidSchedulers.mainThread())
fun Completable.observeOnMain() = observeOn(AndroidSchedulers.mainThread())



