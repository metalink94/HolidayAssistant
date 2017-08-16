package ru.assistent.holidayassistant.utils;

import android.support.annotation.NonNull;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Денис on 16.08.2017.
 */

public class ViewPresenter<V extends IView> {

    private WeakReference<V> mViewRef;

    public void setView(V view) {
        mViewRef = new WeakReference<V>(view);
    }

    protected V getView() {
        return mViewRef == null ? null : mViewRef.get();
    }

    public void onDetachView() {
        mViewRef.clear();
        mCompositeDisposable.clear();
    }


    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    protected void unsubscribeOnDestroy(@NonNull Disposable subscription) {
        mCompositeDisposable.add(subscription);
    }
}