package com.example.vincent.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.common.libary.util.ToastUtil;
import com.example.vincent.R;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.StringCallback;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;

/**
 * @name Example
 * @class name：com.example.vincent
 * @class describe OkGo网络框架 https://github.com/jeasonlzy/okhttp-OkGo
 * @anthor Vincent QQ:1032006226
 * @time 2016/10/31 15:26
 * @change
 * @chang time
 * @class describe
 */
public class OkGoTestActivity extends AppCompatActivity {
    private static final String SERVICE_URI = "http://v.juhe.cn/weather/index?format=2&cityname=深圳&key=77a262c554de40916edc78858221b4a9";
    @BindView(R.id.tv_request_weather)
    TextView tvRequestWeather;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_okgo_test);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.tv_request_weather)
    public void onClick() {
        OkGo.get(SERVICE_URI)
                .tag("get weather")
                .cacheKey("weather")
                .cacheMode(CacheMode.DEFAULT)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
//                        MyLog.d("result",s);
                        ToastUtil.showDefaultToast(getApplicationContext(),s);
                    }
                });
    }
}
