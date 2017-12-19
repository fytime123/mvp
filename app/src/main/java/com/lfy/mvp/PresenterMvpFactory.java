package com.lfy.mvp;

/**
 * Created by fuyi.liu on 2017/12/14.
 * 工厂接口
 */

public interface PresenterMvpFactory<V extends BaseMvpView,P extends BaseMvpPresenter<V>> {
    /**
     * 创建Presenter的接口方法
     * @return 需要创建的Presenter
     */
    P createMvpPresenter();
}
