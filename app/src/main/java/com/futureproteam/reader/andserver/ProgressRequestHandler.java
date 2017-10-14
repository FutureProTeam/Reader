package com.futureproteam.reader.andserver;

import com.blankj.utilcode.util.EncodeUtils;
import com.google.gson.Gson;

import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.entity.StringEntity;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpRequestHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/13.
 */

public class ProgressRequestHandler implements HttpRequestHandler {
    @Override
    public void handle(HttpRequest request, HttpResponse response, HttpContext context) throws HttpException, IOException {
        String uri = request.getRequestLine().getUri();
        String fileName = EncodeUtils.urlDecode(uri).replace("/progress/","").split("\\?")[0];
        float value = ProgressCache.getProgress(fileName);
        StringEntity stringEntity = null;
        if(value > -1){
            Map<String,String> map = new HashMap<>();
            map.put("fileName","");
            map.put("progress",value+"");//Todo这个暂时有些问题
            map.put("size","334565");
            stringEntity = new StringEntity(new Gson().toJson(map), "utf-8");
        } else {
             stringEntity = new StringEntity("{}", "utf-8");
        }


        response.setEntity(stringEntity);
    }
}
