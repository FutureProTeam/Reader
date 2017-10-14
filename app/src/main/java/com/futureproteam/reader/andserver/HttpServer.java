package com.futureproteam.reader.andserver;

import android.content.Context;
import android.util.Log;

import com.blankj.utilcode.util.NetworkUtils;
import com.futureproteam.reader.base.BaseApplication;
import com.yanzhenjie.andserver.AndServer;
import com.yanzhenjie.andserver.Server;
import com.yanzhenjie.andserver.website.AssetsWebsite;
import com.yanzhenjie.andserver.website.WebSite;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.logging.Logger;


/**
 * Created by Administrator on 2017/10/10.
 */

public class HttpServer {
    private final Server mServer;

    private BaseApplication application;
    public HttpServer(Context context){

        AndServer andServer = new AndServer.Build()
                .port(8080)
                .timeout(10 * 1000)
               // .registerHandler("login", new RequestLoginHandler())
                // .registerHandler("download", new RequestFileHandler("Your file path"))
              //  .registerHandler("upload", new RequestUploadHandler())
                .noMatchHandler(new NoMatchHttpRequestHandler())
                .website(new AssetsWebsite(context.getAssets(), ""))
                //.listener(mListener)
                .build();

        // Create server.
        mServer = andServer.createServer();
       // String ip = NetUtil.getLocalIPAddress();

        mServer.start();
    }
}
