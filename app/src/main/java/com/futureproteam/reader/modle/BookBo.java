package com.futureproteam.reader.modle;

/**
 *
 * Created by ding-syi on 2017/10/8.
 */

public class BookBo {

    private String name;

    private String size;
    public BookBo(){

    }

    public BookBo(String title) {
        this.name = title;
    }

    public String getTitle() {
        return name;
    }

    public void setTitle(String title) {
        this.name = title;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
