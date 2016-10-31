package com.common.libary.listener;

import com.lzy.okgo.convert.Converter;

import org.json.JSONObject;

import okhttp3.Response;

/**
 * @name Example
 * @class name：com.common.libary.listener
 * @class describe
 * @anthor Vincent QQ:1032006226
 * @time 2016/10/31 17:14
 * @change
 * @chang time
 * @class describe
 */
public class JsonObjectConvert implements Converter<JSONObject> {

    public static JsonObjectConvert create(){
       return jsonObjectViewHodler.jsonObjectConvert;
    }

    private static class jsonObjectViewHodler{
        private static JsonObjectConvert jsonObjectConvert=new JsonObjectConvert();
    }

    @Override
    public JSONObject convertSuccess(Response response) throws Exception {
        return new JSONObject(response.body().toString());
    }

}
