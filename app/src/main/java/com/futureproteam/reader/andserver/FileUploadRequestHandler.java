package com.futureproteam.reader.andserver;

import android.util.Log;

import com.futureproteam.reader.modle.BookBo;
import com.yanzhenjie.andserver.RequestHandler;
import com.yanzhenjie.andserver.upload.HttpFileUpload;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.MultipartStream;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.protocol.HttpContext;

import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by Administrator on 2017/10/14.
 */

public class FileUploadRequestHandler implements RequestHandler {
    @Override
    public void handle(HttpRequest request, HttpResponse response, HttpContext context) throws HttpException, IOException {
        try {
            FileItemIterator itemIterator = new HttpFileUpload().getItemIterator(request);

            if(itemIterator.hasNext()){
                FileItemStream fileItemStream = itemIterator.next();
                String filename= fileItemStream.getName();
                InputStream inputStream = fileItemStream.openStream();
                long count = ((MultipartStream.ItemInputStream) inputStream).getBytesRead();
                long len = 0;
                byte[] bytes = new byte[1024];
                int readlen = 0;
                while ( (readlen = inputStream.read(bytes)) > 0){
                    len = len + readlen;
                    ProgressCache.putProgress(filename,(float) len/count);
                }
                BookBo bookBo = new BookBo();
                bookBo.setTitle(filename);
                bookBo.setSize(readableFileSize(len));
                TempCache.insert(bookBo);
            }
           // itemIterator.hasNext()
            Log.e("","");
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }

    public static String readableFileSize(long size) {
        if (size <= 0) {
            return "0";
        }
        final String[] units = new String[]{"B", "kB", "MB", "GB", "TB"};
        int digitGroups = (int) (Math.log10(size) / Math.log10(1024));
        return new DecimalFormat("#,##0.#").format(size / Math.pow(1024, digitGroups)) + " " + units[digitGroups];
    }
}
