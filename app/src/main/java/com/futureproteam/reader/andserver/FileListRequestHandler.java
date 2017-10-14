package com.futureproteam.reader.andserver;

import com.google.gson.Gson;

import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.entity.StringEntity;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpRequestHandler;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

/**
 * 获取上传文件列表接口
 * Created by Administrator on 2017/10/14.
 */

public class FileListRequestHandler implements HttpRequestHandler {
    @Override
    public void handle(HttpRequest request, HttpResponse response, HttpContext context) throws HttpException, IOException {
        String json = new Gson().toJson(TempCache.bookBos);
        StringEntity stringEntity = new StringEntity(json,"utf-8");
        response.setEntity(stringEntity);
    }
}
