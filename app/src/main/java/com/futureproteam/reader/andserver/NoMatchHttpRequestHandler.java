package com.futureproteam.reader.andserver;

import android.util.Log;

import com.yanzhenjie.andserver.util.HttpRequestParser;

import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpRequestHandler;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/12.
 */

public class NoMatchHttpRequestHandler implements HttpRequestHandler {
    private ProgressRequestHandler progressRequestHandler;
    private FileListRequestHandler fileListRequestHandler;
    private FileUploadRequestHandler fileUploadRequestHandler;
    private DeleteFileRequestHandler deleteFileRequestHandler;

    public NoMatchHttpRequestHandler(){
        progressRequestHandler = new ProgressRequestHandler();
        fileListRequestHandler = new FileListRequestHandler();
        fileUploadRequestHandler = new FileUploadRequestHandler();
        deleteFileRequestHandler = new DeleteFileRequestHandler();
    }
    @Override
    public void handle(HttpRequest request, HttpResponse response, HttpContext context) throws HttpException, IOException {
        Log.e("","");
        if(request.getRequestLine().getUri().contains("progress")){
            progressRequestHandler.handle(request,response,context);
        } else if(request.getRequestLine().getUri().contains("file")){
            if(request.getRequestLine().getMethod().equals("GET")){
                fileListRequestHandler.handle(request,response,context);
            } else {
               // : application/x-www-form-urlencoded; charset=UTF-8.
                Header header = request.getLastHeader("Content-Type");
                if(header.getValue().contains("application/x-www-form-urlencoded")){
                    Map<String,String> params = HttpRequestParser.parse(request);
                    String method = params.get("_method");
                    if(method != null && method.equals("delete")){
                        deleteFileRequestHandler.handle(request,response,context);
                    }
                }
                fileUploadRequestHandler.handle(request,response,context);
            }
        }
    }
}
