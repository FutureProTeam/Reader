package com.futureproteam.reader.andserver;

import com.futureproteam.reader.modle.BookBo;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/10/14.
 */

public class TempCache {

    public static ArrayList<BookBo> bookBos = new ArrayList<>();

    static {
        BookBo bookBo = new BookBo();
        bookBo.setTitle("Android系统源代码情景分析 [罗升阳著].pdf");
        bookBo.setSize("204.8 MB");
        bookBos.add(bookBo);

        BookBo bookBo1 = new BookBo();
        bookBo1.setTitle("《插翅难逃》.txt");
        bookBo1.setSize("195.8 KB");
        bookBos.add(bookBo1);

        BookBo bookBo2 = new BookBo();
        bookBo2.setTitle("《三国》 作者：时.txt");
        bookBo2.setSize("569.9 KB");
        bookBos.add(bookBo2);
    }

    public static void delete(String filename){
        for(BookBo bookBo:bookBos){
            if(bookBo.getTitle().equals(filename)){
                bookBos.remove(bookBo);
            }
        }
    }

    public static void insert(BookBo bookBo){
        bookBos.add(bookBo);
    }
}
