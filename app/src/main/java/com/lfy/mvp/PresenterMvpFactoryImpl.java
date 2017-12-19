package com.lfy.mvp;

/**
 * Created by fuyi.liu on 2017/12/14.
 * 工厂实现类
 */

public class PresenterMvpFactoryImpl<V extends BaseMvpView, P extends BaseMvpPresenter<V>>  implements PresenterMvpFactory<V,P>{
    /**
     * 需要创建的Presenter的类型
     */
    private final Class<P> presenterClass;

    public static <V extends BaseMvpView, P extends BaseMvpPresenter<V>> PresenterMvpFactoryImpl<V,P> createFactory(Class<?> viewClazz){
        CreatePresenter annotation = viewClazz.getAnnotation(CreatePresenter.class);
        Class<P> pClass = null;
        if(annotation != null){
            pClass = (Class<P>) annotation.value();
        }
        return pClass == null ? null : new PresenterMvpFactoryImpl<V, P>(pClass);
    }

    private PresenterMvpFactoryImpl(Class<P> presenterClass) {
        this.presenterClass = presenterClass;
    }

    @Override
    public P createMvpPresenter() {
        try {
            return presenterClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Presenter创建失败!，检查是否声明了@CreatePresenter(xx.class)注解");
        }
    }
}
