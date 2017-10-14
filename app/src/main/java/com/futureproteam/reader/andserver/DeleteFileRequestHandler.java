package com.futureproteam.reader.andserver;

import com.blankj.utilcode.util.EncodeUtils;
import com.yanzhenjie.andserver.RequestHandler;

import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.protocol.HttpContext;

import java.io.IOException;

/**
 * 删除上传文件操作
 * Created by Administrator on 2017/10/14.
 */

public class DeleteFileRequestHandler implements RequestHandler{
    @Override
    public void handle(HttpRequest request, HttpResponse response, HttpContext context) throws HttpException, IOException {
        String uri = request.getRequestLine().getUri();
        String fileName = EncodeUtils.urlDecode(uri).replace("/files/","");
        TempCache.delete(fileName);
        response.setStatusCode(200);
    }
}
