package com.lfy.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by fuyi.liu on 2017/12/14.
 *
 */

public abstract class BaseMvpPresenter <V extends BaseMvpView>{
    /**
     * V层view
     */
    private V view;
    /**
     * Presenter被创建后调用
     *
     * @param savedState 被意外销毁后重建后的Bundle
     */
    public void onCreatePersenter(@Nullable Bundle savedState) {
        Log.e("perfect-mvp","P onCreatePersenter = ");
    }
    /**
     * 绑定View
     */
    public void onAttachMvpView(V mvpView) {
        view = mvpView;
        Log.e("perfect-mvp","P onResume");
    }
    /**
     * 解除绑定View
     */
    public void onDetachMvpView() {
        view = null;
        Log.e("perfect-mvp","P onDetachMvpView = ");
    }
    /**
     * Presenter被销毁时调用
     */
    public void onDestroyPersenter() {
        Log.e("perfect-mvp","P onDestroy = ");
    }
    /**
     * 在Presenter意外销毁的时候被调用，它的调用时机和Activity、Fragment、View中的onSaveInstanceState
     * 时机相同
     *
     * @param outState
     */
    public void onSaveInstanceState(Bundle outState) {
        Log.e("perfect-mvp","P onSaveInstanceState = ");
    }
    /**
     * 获取V层接口View
     *
     * @return 返回当前MvpView
     */
    public V getMvpView() {
        return view;
    }
}
