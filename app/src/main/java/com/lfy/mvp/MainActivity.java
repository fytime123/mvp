package com.lfy.mvp;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

@CreatePresenter(RequestPresenter5.class)
public class MainActivity extends BaseMvpActivitiy<RequestView5, RequestPresenter5> implements RequestView5 {

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //设置自己的Presenter工厂，如果你想自定义的话
        // setPresenterFactory(xxx);
        if(savedInstanceState != null){
            Log.e("perfect-mvp","MainActivity  onCreate 测试  = " + savedInstanceState.getString("test") );
        }
    }
    //点击事件
    public void request(View view) {
        Log.e("perfect-mvp","点击事件");
        getMvpPresenter().clickRequest("101010100");
    }
    @Override
    public void requestLoading() {
        textView.setText("请求中,请稍后...");
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e("perfect-mvp","MainActivity onSaveInstanceState 测试");
        outState.putString("test","test_save");
    }
    @Override
    public void resultSuccess(WeatherBean result) {
        //成功
        textView.setText(result.getWeatherinfo().toString());
    }
    @Override
    public void resultFailure(String result) {
        //失败
        textView.setText(result);
    }
}
