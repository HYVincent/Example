package com.common.libary.netutil;

import com.common.libary.listener.JsonObjectConvert;
import com.lzy.okgo.callback.AbsCallback;

import org.json.JSONObject;

import okhttp3.Call;
import okhttp3.Response;

/**
 * @name Example
 * @class name：com.common.libary.netutil
 * @class describe
 * @anthor Vincent QQ:1032006226
 * @time 2016/10/31 17:04
 * @change
 * @chang time
 * @class describe
 */
public abstract class JsonObjectCallBack extends AbsCallback<JSONObject>{

    @Override
    public JSONObject convertSuccess(Response response) throws Exception {
        JSONObject result= JsonObjectConvert.create().convertSuccess(response);
        response.close();
        return result;
    }
}
